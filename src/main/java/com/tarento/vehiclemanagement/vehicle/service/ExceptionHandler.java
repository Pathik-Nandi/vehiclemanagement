package com.tarento.vehiclemanagement.vehicle.service;

import com.tarento.vehiclemanagement.vehicle.dto.KeyValuePair;
import com.tarento.vehiclemanagement.vehicle.dto.ValidationError;
import org.springframework.boot.context.properties.bind.validation.ValidationErrors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.tarento.vehiclemanagement.vehicle.exception.ValidationException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;


@ControllerAdvice
public class ExceptionHandler {

    @ResponseBody
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationError onConstrainException(ConstraintViolationException ex){
        ValidationError errors = new ValidationError();
        ex.getConstraintViolations().stream().forEach(
                ConstraintViolation -> errors.getErrors().add(
                        new KeyValuePair(ConstraintViolation.getPropertyPath().toString(),ConstraintViolation.getMessage()))
        );
        errors.setType("requestbodyerrors");
        return errors;
    }

    public ValidationError onMethodArgException(MethodArgumentNotValidException ex){
        ValidationError errors = new ValidationError();
        ex.getBindingResult().getFieldErrors().stream().forEach(
                bindingError -> errors.getErrors().add(
                        new KeyValuePair(bindingError.getField(), bindingError.getDefaultMessage()))
        );
        errors.setType("requestbodyerrors");
        return errors;
    }

    @ResponseBody
    @org.springframework.web.bind.annotation.ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationError onBusinessValidationException(ValidationException ex){
        ValidationError errors = new ValidationError();
        ex.getErrorCodes().stream().forEach(
                businessValidationError -> errors.getErrors().add(businessValidationError)
        );
        errors.setType("businessValidationErrors");
        return errors;
    }

}
