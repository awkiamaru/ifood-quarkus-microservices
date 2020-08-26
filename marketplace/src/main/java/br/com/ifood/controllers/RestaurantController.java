package br.com.ifood.controllers;

import br.com.ifood.dto.PlateDTO;
import br.com.ifood.models.Plate;
import io.smallrye.mutiny.Multi;
import io.vertx.mutiny.pgclient.PgPool;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/restaurant")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RestaurantController {

    @Inject
    PgPool pgPool;

    @GET
    @Path("{restaurantId}/plates")
    public Multi<PlateDTO> findAllPlates(@PathParam("restaurantId") Long restaurantId){
        return Plate.findAll(pgPool, restaurantId);
    }
}
