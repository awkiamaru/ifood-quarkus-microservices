package br.com.ifood.controllers;

import br.com.ifood.models.Restaurant;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static io.quarkus.hibernate.orm.panache.PanacheEntityBase.listAll;

@Path("/restaurants")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RestaurantsController {
    @GET
    public List<Restaurant> findAll(){
        return listAll();
    }

    @POST
    public void addRestaurant(Restaurant restaurant){
        restaurant.persist();
    }
}
