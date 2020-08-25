package br.com.ifood.controllers;

import br.com.ifood.models.Restaurant;
import br.com.ifood.repositories.RestaurantRepository;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/restaurants")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "Restaurant", description = "Restaurant operations")
public class RestaurantController {

    @Inject
    RestaurantRepository restaurantRepository;


    @GET
    public List<Restaurant> findAll(){
        return restaurantRepository.listAll();
    }

    @POST
    @Transactional
    public Response addRestaurant(Restaurant restaurant){
        restaurantRepository.persist(restaurant);
        return Response.created(null).entity(restaurant).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public void updateRestaurant(@PathParam("id") Long id, Restaurant restaurant){
        restaurantRepository.findByIdOptional(id)
                            .ifPresentOrElse(foundRestaurant-> {
                                foundRestaurant.setName(restaurant.getName());
                                restaurantRepository.persist(foundRestaurant);
                                }, ()->{
                                throw new NotFoundException();
                            });
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void deleteRestaurant(@PathParam("id") Long id){
        restaurantRepository.findByIdOptional(id)
                            .ifPresentOrElse(restaurantRepository::delete, () ->{
                              throw new NotFoundException();
                            });
    }
}
