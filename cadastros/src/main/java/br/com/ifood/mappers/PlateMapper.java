package br.com.ifood.mappers;

import br.com.ifood.dto.PlateDTO;
import br.com.ifood.models.Plate;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PlateMapper {

    @Inject
    RestaurantMapper restaurantMapper;

    public Plate mapExternalToInternal(PlateDTO externalPlate){
        Plate plate = new Plate();
        plate.setPrice(externalPlate.getPrice());
        plate.setName(externalPlate.getName());
        plate.setDescription(externalPlate.getDescription());
        return plate;
    }

    public PlateDTO mapInternalToExternal(Plate internalPlate){
        PlateDTO plate = new PlateDTO();
        plate.setPrice(internalPlate.getPrice());
        plate.setName(internalPlate.getName());
        plate.setDescription(internalPlate.getDescription());
        return plate;
    }

}
