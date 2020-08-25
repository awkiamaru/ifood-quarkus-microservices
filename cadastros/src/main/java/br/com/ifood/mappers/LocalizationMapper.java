package br.com.ifood.mappers;

import br.com.ifood.dto.LocalizationDTO;
import br.com.ifood.models.Localization;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LocalizationMapper {

    public Localization mapExternalToInternal(LocalizationDTO externalLocalization){
        Localization localization = new Localization();
        localization.setLatitude(externalLocalization.getLatitude());
        localization.setLongitude(externalLocalization.getLongitude());
        return localization;
    }

    public LocalizationDTO mapInternalToExternal(Localization internalLocalization){
        LocalizationDTO externalLocalization = new LocalizationDTO();
        externalLocalization.setLatitude(internalLocalization.getLatitude());
        externalLocalization.setLongitude(internalLocalization.getLongitude());
        return externalLocalization;
    }

}
