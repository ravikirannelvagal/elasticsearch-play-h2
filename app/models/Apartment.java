package models;

import com.avaje.ebean.Model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by michael on 06.08.17.
 */
@Entity
public class Apartment extends Model {

    @Id
    public Long id;

    public String name;

    private Double latitude;
    private Double longitude;

    @ManyToOne
    private ApartmentType apartmentType;

    @ManyToMany
    private List<Facility> facilities;

    public static Find<Long, Apartment> find = new Find<Long, Apartment>(){};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public ApartmentType getApartmentType() {
        return apartmentType;
    }

    public void setApartmentType(ApartmentType apartmentType) {
        this.apartmentType = apartmentType;
    }

    public List<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<Facility> facilities) {
        this.facilities = facilities;
    }

    /**
     * Provide the facilities as a continuous Strings
     * to be displayed as a CSV on screen
     */
    public String getFacilitiesToString(){
        StringBuilder facilitiesString = new StringBuilder();
        for(int i=0;i<facilities.size();i++){
            facilitiesString.append(facilities.get(i).getName());
            if(i!=facilities.size()-1){
                facilitiesString.append(", ");
            }
        }
        return facilitiesString.toString();
    }

}
