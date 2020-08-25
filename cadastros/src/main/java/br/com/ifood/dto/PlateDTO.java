package br.com.ifood.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PlateDTO {
    private String name;
    private String description;
    private BigDecimal price;
}
