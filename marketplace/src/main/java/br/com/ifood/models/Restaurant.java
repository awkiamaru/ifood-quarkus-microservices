package br.com.ifood.models;


import lombok.Data;

@Data
public class Restaurant {
    private Long id;
    public String name;
    public Localization localization;

}
