package br.com.ifood.dto;

import lombok.Data;

import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import br.com.ifood.validations.ValidDTO;


@ValidDTO
@Data
public class RestaurantDTO implements BaseDTO {

    @NotBlank(message = "The field [owner] cannot be empty")
    private String owner;

    @Size(min = 18, max = 18)
    @Pattern(regexp = "[0-9]{2}\\.[0-9]{3}\\.[0-9]{3}\\/[0-9]{4}\\-[0-9]{2}",
             message = "The field [document] is not valid")
    private String document;
    @Size(min = 3, max = 30, message = "The field [name] is not valid")
    private String name;
    @NotNull(message = "The field [localization] cannot be null")
    private LocalizationDTO localization;
}
