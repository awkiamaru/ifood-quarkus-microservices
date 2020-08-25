package br.com.ifood.dto;

import javax.validation.ConstraintValidatorContext;

public interface BaseDTO {

    default boolean isValid(ConstraintValidatorContext validatorContext){
        return true;
    }
}
