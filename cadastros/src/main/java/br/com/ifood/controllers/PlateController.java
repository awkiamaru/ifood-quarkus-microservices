package br.com.ifood.controllers;

import br.com.ifood.dto.PlateDTO;
import br.com.ifood.mappers.PlateMapper;
import br.com.ifood.models.Plate;
import br.com.ifood.models.Restaurant;
import br.com.ifood.repositories.PlateRepository;
import br.com.ifood.repositories.RestaurantRepository;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Path("/restaurant")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "Plate", description = "Plate operations")
public class PlateController {

    @Inject
    PlateRepository plateRepository;

    @Inject
    RestaurantRepository restaurantRepository;

    @Inject
    PlateMapper plateMapper;

    @GET
    @Path("{restaurantId}/plates")
    public List<PlateDTO> findAll(@PathParam("restaurantId") Long restaurantId){
        Optional<Restaurant> foudRestaurant = restaurantRepository.findByIdOptional(restaurantId);
        if(foudRestaurant.isEmpty()) {
            throw new NotFoundException();
        }
        return plateRepository.list("restaurant", foudRestaurant.get())
                                .stream()
                                .map(plateMapper::mapInternalToExternal)
                                .collect(Collectors.toList());
    }

    @POST
    @Path("{restaurantId}/plates")
    @Transactional
    public Response addPlate(@PathParam("restaurantId") Long restaurantId, PlateDTO plate){
        Optional<Restaurant> foundRestaurant = restaurantRepository.findByIdOptional(restaurantId);
        if(foundRestaurant.isEmpty()){
            throw new NotFoundException();
        }
        Plate newPlate = new Plate();
        newPlate.setDescription(plate.getDescription());
        newPlate.setName(plate.getName());
        newPlate.setPrice(plate.getPrice());
        newPlate.setRestaurant(foundRestaurant.get());
        plateRepository.persist(newPlate);
        return Response.created(null).entity(newPlate).build();
    }

    @PUT
    @Path("{restaurantId}/plates/{id}")
    @Transactional
    public void updatePlate(@PathParam("restaurantId") Long restaurantId, @PathParam("id") Long id, PlateDTO plate){
            Optional<Restaurant> foundRestaurant = restaurantRepository.findByIdOptional(restaurantId);
            if(foundRestaurant.isEmpty()){
                throw new NotFoundException("Restaurant don't exist");
            }
            Optional<Plate> foundPlate = plateRepository.findByIdOptional(id);

            if(foundPlate.isEmpty()){
                throw new NotFoundException("Plate don't exist");
            }
            Plate updatePlate = foundPlate.get();
            updatePlate.setPrice(plate.getPrice());
            plateRepository.persist(updatePlate);
    }

    @DELETE
    @Path("{restaurantId}/plates/{id}")
    @Transactional
    public void deletePlate(@PathParam("restaurantId") Long restaurantId, @PathParam("id") Long id) {
        Optional<Restaurant> foundRestaurant = restaurantRepository.findByIdOptional(restaurantId);
        if (foundRestaurant.isEmpty()) {
            throw new NotFoundException("Restaurant don't exist");
        }
        plateRepository.findByIdOptional(id).ifPresentOrElse(plateRepository::delete, () -> {
            throw new NotFoundException("Plate don't exist");
        });
    }
}
