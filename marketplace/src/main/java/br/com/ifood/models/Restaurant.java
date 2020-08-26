package br.com.ifood.models;


import lombok.Data;

@Data
public class Restaurant {
    private Long id;
    private String name;
    private Localization localization;

}
