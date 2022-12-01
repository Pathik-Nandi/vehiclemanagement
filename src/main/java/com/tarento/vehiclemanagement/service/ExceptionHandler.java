package com.tarento.vehiclemanagement.service;

import com.tarento.vehiclemanagement.dto.KeyValuePair;
import com.tarento.vehiclemanagement.dto.ValidationError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

@ControllerAdvice
public class ExceptionHandler {

    @ResponseBody
    @org.springframework.web.bind.annotation.ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationError onConstraintException(ConstraintViolationException ex) {
        ValidationError errors = new ValidationError();
        ex.getConstraintViolations().stream().forEach(
                constraintViolation -> errors.getErrors().add(
                        new KeyValuePair(constraintViolation.getPropertyPath().toString(),constraintViolation.getMessage()))
        );
        errors.setType("requestbodyerrors");
        return errors;
    }

    @ResponseBody
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationError onMethodArgException(MethodArgumentNotValidException ex) {
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
    public ValidationError onBusinessValidationException(com.tarento.vehiclemanagement.exception.ValidationException ex) {
        ValidationError errors = new ValidationError();
        ex.getErrorCodes().stream().forEach(
                businessValidationError -> errors.getErrors().add(businessValidationError)
        );
        return errors;
    }

}
