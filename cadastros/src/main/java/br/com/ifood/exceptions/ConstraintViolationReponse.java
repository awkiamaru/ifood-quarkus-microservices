package br.com.ifood.exceptions;


import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class ConstraintViolationReponse {

    private final List<ConstraintViolationImpl> violations = new ArrayList<>();

    ConstraintViolationReponse(ConstraintViolationException violationException){
        violationException.getConstraintViolations().forEach(constraintViolation -> violations.add(ConstraintViolationImpl.of(constraintViolation)));
    }

    public static ConstraintViolationReponse of(ConstraintViolationException violationException){
        return new ConstraintViolationReponse(violationException);
    }
    public List<ConstraintViolationImpl> getViolations(){
        return violations;
    }

}
