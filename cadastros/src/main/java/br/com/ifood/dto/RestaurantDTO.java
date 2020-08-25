package br.com.ifood.dto;

import lombok.Data;


@Data
public class RestaurantDTO {
    private String owner;
    private String document;
    private String name;
    private LocalizationDTO localization;
}
