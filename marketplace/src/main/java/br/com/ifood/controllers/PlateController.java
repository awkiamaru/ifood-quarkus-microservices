package br.com.ifood.controllers;

import br.com.ifood.dto.PlateDTO;
import br.com.ifood.models.Plate;
import io.smallrye.mutiny.Multi;
import io.vertx.mutiny.pgclient.PgPool;
import org.flywaydb.core.Flyway;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/plates")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PlateController {

    @Inject
    PgPool pgPool;

    @GET
    public Multi<PlateDTO> findAllPlates(){
        return Plate.findAll(pgPool);
    }
}
