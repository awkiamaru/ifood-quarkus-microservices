package br.com.ifood.controllers;

import br.com.ifood.dto.RestaurantDTO;
import br.com.ifood.mappers.RestaurantMapper;
import br.com.ifood.repositories.RestaurantRepository;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;


@Path("/restaurants")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "Restaurant", description = "Restaurant operations")
public class RestaurantController {

    @Inject
    RestaurantRepository restaurantRepository;

    @Inject
    RestaurantMapper restaurantMapper;

    @GET
    public List<RestaurantDTO> findAll(){
        return restaurantRepository.listAll()
                                    .stream()
                                    .map(restaurantMapper::mapInternalToExternal)
                                    .collect(Collectors.toList());
    }

    @POST
    @Transactional
    public Response addRestaurant(RestaurantDTO restaurant){
        restaurantRepository.persist(restaurantMapper.mapExternalToInternal(restaurant));
        return Response.created(null).entity(restaurant).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public void updateRestaurant(@PathParam("id") Long id, RestaurantDTO restaurant){
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
