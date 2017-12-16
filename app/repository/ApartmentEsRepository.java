package repository;

import models.Apartment;
import org.elasticsearch.ResourceAlreadyExistsException;
import org.elasticsearch.action.admin.cluster.state.ClusterStateResponse;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.collect.ImmutableOpenMap;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.SearchHits;
import org.springframework.stereotype.Repository;
import services.ElasticsearchService;
import util.ApartmentUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * An Elasticsearch repository for the Apartment
 * class to handle CRUD operations from the
 * Elasticsearch cluster.
 */
@Repository
public class ApartmentEsRepository {

    private final Client client = ElasticsearchService.get();

    /**
     * Find all the matching Apartments based on
     * the Query that is passed. The query can
     * either be a findAll query or a find based
     * on search parameters
     *
     * @param query   Query to be used
     *                       for fetching
     * @return SearchHits
     */
    public SearchHits getApartments(QueryBuilder query){

        SearchResponse response = client.prepareSearch(ApartmentUtils.INDEX)
                .setTypes(ApartmentUtils.TYPE)
                .setSearchType(SearchType.QUERY_THEN_FETCH)
                .setQuery(query)
                .setFrom(0).setSize(100).execute().actionGet();

        return response.getHits();
    }

    /**
     * Find an Apartment by the Id passed
     *
     * @param id   Id of the document to be
     *             fetched
     * @return Map<String, Object>
     */
    public Map<String, Object> findById(Long id){
        GetResponse response = client.prepareGet(ApartmentUtils.INDEX,ApartmentUtils.TYPE,id.toString()).get();
        return response.getSource();

    }

    /**
     * Index the Apartment provided
     *
     * This is a static method as we have not
     * implemented the routes for this
     * functionality yet. This is currently
     * supported only during Unit Testing
     *
     * @param apartment   Apartment to be
     *                    indexed
     * @return int
     */
    public static int indexApartment(Apartment apartment) throws IOException {
        IndexResponse response = ElasticsearchService.get()
                .prepareIndex(ApartmentUtils.INDEX,ApartmentUtils.TYPE,apartment.getId().toString())
                .setSource(jsonBuilder()
                        .startObject()
                        .field("name", apartment.getName())
                        .field("latitude", apartment.getLatitude())
                        .field("longitude", apartment.getLongitude())
                        .field("apartmentType", apartment.getApartmentType().getName())
                        .field("facilities",apartment.getFacilities().toArray())
                        .endObject()).get();

        return response.status().getStatus();
    }

    /**
     * Delete the Apartment for the id provided
     *
     * This is a static method as we have not
     * implemented the routes for this
     * functionality yet. This is currently
     * supported only during Unit Testing
     *
     * @param id   ID of the document to be
     *               deleted if present
     * @return int
     */
    public static int deleteApartment(Long id){
        DeleteResponse response = ElasticsearchService.get()
                .prepareDelete(ApartmentUtils.INDEX,ApartmentUtils.TYPE,id.toString())
                .get();
        return response.status().getStatus();
    }

    /**
     * Invoke the Bulk API of elastic search to index
     * Apartments from a list in bulk.
     *
     * @param apartmentList  List of all the apartments
     *                       to be indexed
     */
    public void indexApartmentsBulk(List<Apartment> apartmentList){
        prepareApartmentIndex();
        BulkRequestBuilder bulk = client.prepareBulk();
        for(Apartment apt:apartmentList){
            try {
                bulk.add(client.prepareIndex(ApartmentUtils.INDEX, ApartmentUtils.TYPE,apt.getId().toString())
                        .setSource(jsonBuilder()
                                .startObject()
                                .field("name", apt.getName())
                                .field("latitude", apt.getLatitude())
                                .field("longitude", apt.getLongitude())
                                .field("apartmentType", apt.getApartmentType().getName())
                                .field("facilities",apt.getFacilities().toArray())
                                .endObject()
                        )
                );
            }catch(IOException e){
                //do nothing
            }
        }

    }


    /**
     * Prepare the Mappings for the 'holidu' index
     * for type 'apartment'
     *
     * Fields like 'name' and 'apartmentType' have a
     * raw field for further use, as it may be used
     * for a full text match, and for that reason
     * the raw fields are not analyzed on indexing
     *
     * 'facilities' field is analyzed using an english
     * analyzer as it will lowercase the words
     *
     * 'latitude' and 'longitude' fields are retained
     * as float type
     */
    private void prepareApartmentIndex(){
        try{
            client.admin().indices().prepareCreate(ApartmentUtils.INDEX).get();
        }catch(ResourceAlreadyExistsException ex){
            //Index already exists
            //Do nothing, create Type.
            //even if it already exsits
        }
        ClusterStateResponse response =client.admin().cluster().prepareState().execute().actionGet();
        ImmutableOpenMap mappings = response.getState().metaData().index(ApartmentUtils.INDEX).getMappings();
        if(mappings.containsKey(ApartmentUtils.TYPE)){
            return;
        }
        client.admin().indices().preparePutMapping(ApartmentUtils.INDEX)
                .setType(ApartmentUtils.TYPE)
                .setSource("{\n" +
                        "                        \"properties\":{\n" +
                        "                                \"name\":{\"type\":\"string\"," +
                        "                                   \"fields\":{" +
                        "                                       \"raw\":{\"type\":\"string\",\"index\":\"not_analyzed\"}" +
                        "                                   }" +
                        "                                 },\n" +
                        "                                \"latitude\":{\"type\":\"float\"},\n" +
                        "                                \"longitude\":{\"type\":\"float\"},\n" +
                        "                                \"apartmentType\":{\"type\":\"string\",\"analyzer\":\"english\"," +
                        "                                   \"fields\":{" +
                        "                                       \"raw\":{\"type\":\"string\",\"index\":\"not_analyzed\"}" +
                        "                                   }" +
                        "                                 },\n" +
                        "                                \"facilities\":{\"type\":\"string\",\"analyzer\":\"english\"}\n" +
                        "                        }\n" +
                        "}", XContentType.JSON)
                .get();
    }
}