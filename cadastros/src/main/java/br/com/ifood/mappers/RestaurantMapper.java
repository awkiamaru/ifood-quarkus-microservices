package br.com.ifood.mappers;

import br.com.ifood.dto.RestaurantDTO;
import br.com.ifood.models.Restaurant;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class RestaurantMapper {

    @Inject
    LocalizationMapper localizationMapper;

    public Restaurant mapExternalToInternal (RestaurantDTO externalRestaurant){
        Restaurant restaurant = new Restaurant();
        restaurant.setOwner(externalRestaurant.getOwner());
        restaurant.setName(externalRestaurant.getName());
        restaurant.setDocument(externalRestaurant.getDocument());
        restaurant.setLocalization(localizationMapper.mapExternalToInternal(externalRestaurant.getLocalization()));
        return restaurant;
    }


    public RestaurantDTO mapInternalToExternal (Restaurant externalRestaurant){
        RestaurantDTO restaurant = new RestaurantDTO();
        restaurant.setOwner(externalRestaurant.getOwner());
        restaurant.setName(externalRestaurant.getName());
        restaurant.setDocument(externalRestaurant.getDocument());
        restaurant.setLocalization(localizationMapper.mapInternalToExternal(externalRestaurant.getLocalization()));
        return restaurant;
    }
}
