package br.com.ifood.validations;

import br.com.ifood.dto.BaseDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidDTOValidator implements ConstraintValidator<ValidDTO, BaseDTO> {

    @Override
    public void initialize(ValidDTO constraintAnnotation){
    }

    @Override
    public boolean isValid(BaseDTO validator, ConstraintValidatorContext constraintValidator){
        return validator.isValid(constraintValidator);
    }
}
