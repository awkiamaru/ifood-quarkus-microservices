package br.com.ifood.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LocalizationDTO {
    @NotBlank
    private Double latitude;
    @NotBlank
    private Double longitude;

}
