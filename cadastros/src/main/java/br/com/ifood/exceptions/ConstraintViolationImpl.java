package br.com.ifood.exceptions;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.validation.ConstraintViolation;
import java.io.Serializable;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConstraintViolationImpl implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "Path of attribute, ex: initialDate, address, number", required = true)
    private final String attribute;

    @Schema(description = "Descriptive message of error associated to path", required = true)
    private final String message;

    public ConstraintViolationImpl(String attribute, String message) {
        this.attribute = attribute;
        this.message = message;
    }

    public ConstraintViolationImpl(ConstraintViolation<?> constraintViolation) {
        this.attribute = constraintViolation.getMessage();
        this.message = Stream.of(constraintViolation
                                    .getPropertyPath()
                                    .toString()
                                    .split("\\."))
                                    .skip(2)
                                    .collect(Collectors.joining("."));
    }

    public static ConstraintViolationImpl of(ConstraintViolation<?> constraintViolation){
        return new ConstraintViolationImpl(constraintViolation);
    }

    public static ConstraintViolationImpl of(String constraintViolation){
        return new ConstraintViolationImpl(null, constraintViolation);
    }

    public String getAttribute() {
        return attribute;
    }

    public String getMessage() {
        return message;
    }
}
