package br.com.ifood.controllers;

import br.com.ifood.models.Restaurant;
import br.com.ifood.repositories.RestaurantRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;


@Path("/restaurants")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RestaurantController {

    @Inject
    RestaurantRepository restaurantRepository;


    @GET
    public List<Restaurant> findAll(){
        return restaurantRepository.listAll();
    }

    @POST
    @Transactional
    public void addRestaurant(Restaurant restaurant){
        restaurantRepository.persist(restaurant);
    }

    @PUT
    @Path("{id}")
    @Transactional
    public void updateRestaurant(@PathParam("id") Long id, Restaurant restaurant){
        Optional<Restaurant> internalRestaurant = restaurantRepository.findByIdOptional(id);
        if(internalRestaurant.isEmpty()){
            throw new NotFoundException();
        }
        Restaurant foundRestaurant= internalRestaurant.get();
        restaurantRepository.persist(foundRestaurant);
    }
}
