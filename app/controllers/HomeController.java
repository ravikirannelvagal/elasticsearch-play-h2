package controllers;

import models.Apartment;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import repository.ApartmentEsRepository;
import services.ApartmentService;

import javax.inject.Inject;
import java.io.IOException;
import java.util.*;

/**
 * This class controls the flow
 * of navigation and routes the
 * results to the appropriate
 * views
 */
public class HomeController extends Controller {

    /*
     * The instance of service, autowired here
     * */
    @Inject
    private ApartmentService apartmentService;

    private Result GO_HOME = Results.redirect(routes.HomeController.list("","",""));

    /**
     * Navigate to Home
     *
     * @return Result
     */
    public Result index() {
        return GO_HOME;
    }

    /**
     * Navigate to view the results
     * of Apartments found
     *
     * @param filterByName Filter by name
     * @param filterByFac  Filter by facility
     * @param filterByType Filter by Apartment Type
     * @return Result
     */
    public Result list(String filterByName, String filterByFac, String filterByType){
        apartmentService.readAllApartments();
        if("".equals(filterByName) & "".equals(filterByFac) & "".equals(filterByType)){
            List<Apartment> apartmentList = apartmentService.queryAllDocs();
            return ok(views.html.list.render(apartmentList,"","",""));
        }else {
            List<Apartment> apartmentList = apartmentService.applyFilter(filterByName, filterByFac, filterByType);
            return ok(views.html.list.render(apartmentList, filterByName, filterByFac, filterByType));
        }
    }

    /**
     * Find document by Id
     *
     * @param id Id for which the document needs to be fetched
     * @return Result
     */
    public Result findById(Long id){
        Apartment apartment = apartmentService.findById(id);
        if(apartment!= null)
            return ok(views.html.details.render(id,apartment));
        else
            return notFound();
    }

    /**
     * Endpoint used to index apartment.
     * This is not called from a view as of now,
     * but used for Unit test purpose
     *
     * @param apartment Apartment to be indexed
     * @return Result
     */
    public static Result saveApartment(Apartment apartment){
        int ret=0;
        try {
             ret = ApartmentEsRepository.indexApartment(apartment);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(ret == CREATED)
            return ok();
        else if(ret == OK)
            return ok();
        else
            return badRequest();
    }

    /**
     * Endpoint used to delete an apartment.
     * This is not called from a view as of now,
     * but used for Unit test purpose
     *
     * @param id Id which needs to be deleted
     * @return Result
     */
    public static Result deleteApartment(Long id){
        int ret = ApartmentEsRepository.deleteApartment(id);
        if(ret == OK)
            return ok();
        else
            return badRequest();
    }
}
