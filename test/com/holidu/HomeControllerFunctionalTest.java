package com.holidu;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Module;
import models.Apartment;
import models.ApartmentType;
import models.Facility;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import play.Application;
import play.ApplicationLoader;
import play.Environment;
import play.inject.guice.GuiceApplicationBuilder;
import play.inject.guice.GuiceApplicationLoader;

import play.mvc.Result;

import play.test.Helpers;

import javax.inject.Inject;

import java.util.Arrays;
import java.util.List;

import static play.mvc.Http.Status.*;
import static play.test.Helpers.contentAsString;
import static play.test.Helpers.route;

// Use FixMethodOrder to run the tests sequentially
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HomeControllerFunctionalTest {

    @Inject private Application application;

    @Before
    public void setup() {
        Module testModule = new AbstractModule() {
            @Override
            public void configure() {
                // Install custom test binding here
            }
        };

        GuiceApplicationBuilder builder = new GuiceApplicationLoader()
                .builder(new ApplicationLoader.Context(Environment.simple()))
                .overrides(testModule);
        Guice.createInjector(builder.applicationModule()).injectMembers(this);

        Helpers.start(application);
    }

    @After
    public void teardown() {
        Helpers.stop(application);
    }

   @Test
    public void a_testIndex(){
       Result result = route(application,controllers.routes.HomeController.index());
       assertEquals(SEE_OTHER,result.status());
       assertEquals("/apartments",result.redirectLocation().get());
   }

   @Test
    public void b_apartmentsInitiallyFound(){
       Result result = route(application,controllers.routes.HomeController.list("","",""));
       assertEquals(OK,result.status());
       assertTrue(contentAsString(result).contains("9 apartments found"));
   }

   @Test
    public void c_searchByInvalidApartmentName(){
       Result result = route(application,controllers.routes.HomeController.list("Testing","",""));
       assertEquals(OK,result.status());
       assertTrue(contentAsString(result).contains("No apartments found"));
   }

    @Test
    public void d_searchByValidApartmentName(){
        Result result = route(application,controllers.routes.HomeController.list("Finca","",""));
        assertEquals(OK,result.status());
        assertTrue(contentAsString(result).contains("3 apartments found"));
    }

    @Test
    public void e_searchByValidApartmentNameAndFacility(){
        Result result = route(application,controllers.routes.HomeController.list("Finca","pool",""));
        assertEquals(OK,result.status());
        assertTrue(contentAsString(result).contains("3 apartments found"));
    }

    @Test
    public void f_searchByValidApartmentNameAndFacilityWithInvalidType(){
        Result result = route(application,controllers.routes.HomeController.list("Finca","pool","Apartment"));
        assertEquals(OK,result.status());
        assertTrue(contentAsString(result).contains("No apartments found"));
    }


    @Test
    public void g_indexNewApartmentAndSearch(){
        Apartment apartment = new Apartment();
        ApartmentType aptType = new ApartmentType();
        aptType.setName("Test");
        Facility fac1 = new Facility();
        Facility fac2 = new Facility();
        Facility fac3 = new Facility();
        fac1.setName("JUnit");
        fac2.setName("Mock");
        fac3.setName("UnitTest");
        List<Facility> facilityList = Arrays.asList(fac1,fac2,fac3);

        apartment.setId(100001L);
        apartment.setName("Testing Home");
        apartment.setLatitude(38.55006);
        apartment.setLongitude(24.55667);
        apartment.setFacilities(facilityList);
        apartment.setApartmentType(aptType);

        Result result = controllers.HomeController.saveApartment(apartment);
        assertEquals(OK,result.status());
    }

    @Test
    public void h_findIndexedApartmentById(){
        Result result = route(application,controllers.routes.HomeController.findById(100001L));
        assertEquals(OK,result.status());
        assertTrue(contentAsString(result).contains("Apartment Details"));
    }

    @Test
    public void i_deleteIndexedApartment(){
        Result result = controllers.HomeController.deleteApartment(100001L);
        assertEquals(OK,result.status());
    }

    @Test
    public void j_findIndexedApartmentByIdAfterDelete(){
        Result result = route(application,controllers.routes.HomeController.findById(100001L));
        assertEquals(NOT_FOUND,result.status());
    }

    @Test
    public void k_deleteInvalidApartmentById(){
        Result result = controllers.HomeController.deleteApartment(999999L);
        assertEquals(BAD_REQUEST,result.status());
    }
}
