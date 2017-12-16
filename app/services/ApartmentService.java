package services;

import models.Apartment;
import models.ApartmentType;
import models.Facility;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.stereotype.Service;
import repository.ApartmentEsRepository;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Apartment Service class, that handles the
 * business level transformations and other
 * logic, before calling on the repository
 * to perform CRUD operations.
 * This class also handles forwarding of
 * the Apartment/List<Apartment> objects
 * built to the UI layer.
 */

@Service
public class ApartmentService{

    /*
    * The instance of repository, autowired here
    * */
    @Inject
    private ApartmentEsRepository apartmentEsRepository;

    /**
     * Find an Apartment by the Id passed
     *
     * @param id   Id of the document to be
     *             fetched
     * @return Apartment
     */
    public Apartment findById(Long id){
        Map<String,Object> response = apartmentEsRepository.findById(id);
        Apartment apartment=null;
        if(response!=null) {
            // If the response is not null, get an Apartment object from its source
            apartment = getApartmentFromSource(response, id.toString());
        }
        return apartment;
    }


    /**
     * This is more of a utility method, that
     * uses the Apartment Model to findAll the
     * Apartments that are present in the H2
     * Embedded database.
     *
     * This is quite a trivial way of handling
     * the migration from H2 Database to ES
     *
     * Instead, try using Logstash or Beats
     * framework to continually monitor the
     * Database and migrate any new data.
     *
     */
    public void readAllApartments(){
        List<Apartment> apartmentList = Apartment.find.all();
        apartmentEsRepository.indexApartmentsBulk(apartmentList);
    }

    /**
     * Find all the Apartments present in
     * the Elasticsearch cluster. The query is
     * formed here and passed on to the
     * ApartmentEsRepository.
     *
     * The Repository returns a SearchHits
     * object, which contains all the
     * documents that are present.
     * We later use the Map to
     * extract each Apartment Document from
     * the hit
     *
     * @return List<Apartment>
     */
    public List<Apartment> queryAllDocs(){
        List<Apartment> apartmentList = new ArrayList<>();
        SearchHits searchHits =  apartmentEsRepository.getApartments(QueryBuilders.matchAllQuery());
        /*SearchResponse searchResponse = client.prepareSearch(ApartmentUtils.INDEX)
                .setTypes(ApartmentUtils.TYPE)
                .setQuery()
                .execute()
                .actionGet();
          */
        Iterator<SearchHit> searchHitsItr = searchHits.iterator();
        while(searchHitsItr.hasNext()){
            SearchHit hit = searchHitsItr.next();
            apartmentList.add(getApartmentFromSource(hit.getSource(),hit.getId()));
        }
        return apartmentList;
    }

    /**
     * Find the Apartments present in
     * the Elasticsearch cluster which
     * matches the search parameters.
     * The query is formed here and
     * passed on to the ApartmentEsRepository.
     *
     * The Repository returns a SearchHits
     * object, which contains all the
     * documents that are present.
     * We later use the Map to
     * extract each Apartment Document from
     * the hit
     *
     * @param filterByName filter by name
     * @param filterByFac  filter by facility
     * @param filterByType filter by type
     *
     * @return List<Apartment>
     */
    public List<Apartment> applyFilter(String filterByName, String filterByFac, String filterByType){
        List<Apartment> apartmentList = new ArrayList<>();
        QueryBuilder queryByName;
        QueryBuilder queryByType;
        QueryBuilder queryByFac;

        if("".equals(filterByName)) {
            queryByName = QueryBuilders.wildcardQuery("name","*");
        }else{
            queryByName = QueryBuilders.matchQuery("name",filterByName);
        }
        if("".equals(filterByType)) {
            queryByType = QueryBuilders.wildcardQuery("apartmentType","*");
        }else{
            queryByType = QueryBuilders.matchQuery("apartmentType",filterByType);
        }
        if("".equals(filterByFac)) {
            queryByFac=QueryBuilders.wildcardQuery("facilities","*");
        }else{
            queryByFac=QueryBuilders.matchQuery("facilities",filterByFac);
        }

        BoolQueryBuilder filter = new BoolQueryBuilder().must(queryByName).must(queryByType).must(queryByFac);

        SearchHits searchHits =  apartmentEsRepository.getApartments(filter);

       /* SearchResponse response = client.prepareSearch(ApartmentUtils.INDEX)
                .setTypes(ApartmentUtils.TYPE)
                .setSearchType(SearchType.QUERY_THEN_FETCH)
                .setQuery(filter)
                .setFrom(0).setSize(100).execute().actionGet();
        */

        Iterator<SearchHit> searchHitsItr = searchHits.iterator();
        while(searchHitsItr.hasNext()){
            SearchHit hit = searchHitsItr.next();
            apartmentList.add(getApartmentFromSource(hit.getSource(),hit.getId()));
        }
        return apartmentList;
    }

    /**
     * This is a private helper method,
     * it uses the source Map to obtain
     * the Apartment document
     *
     * @param apartmentMap
     * @param id
     * @return Apartment
     */
    private Apartment getApartmentFromSource(Map<String,Object> apartmentMap, String id){
        Iterator<String> keys = apartmentMap.keySet().iterator();
        Apartment apartment= new Apartment();
        List<Facility> facilityList= new ArrayList<>();

        String facString = apartmentMap.get("facilities").toString();

        String [] facilitiesArr =facString.replace("[","").replace("]","").split(",");
        for(String facilityStr: facilitiesArr){
            Facility facility = new Facility();
            facility.setName(facilityStr.trim());
            facilityList.add(facility);
        }

        ApartmentType apartmentType = new ApartmentType();
        apartmentType.setName(apartmentMap.get("apartmentType").toString());

        apartment.setId(Long.parseLong(id));
        apartment.setName(apartmentMap.get("name").toString());
        apartment.setApartmentType(apartmentType);
        apartment.setLatitude(Double.parseDouble(apartmentMap.get("latitude").toString()));
        apartment.setLongitude(Double.parseDouble(apartmentMap.get("longitude").toString()));
        apartment.setFacilities(facilityList);

        return apartment;
    }
}
