package com.tarento.vehiclemanagement.vehicle.service;

import com.tarento.vehiclemanagement.vehicle.dto.KeyValuePair;
import com.tarento.vehiclemanagement.vehicle.dto.ValidationError;
import com.tarento.vehiclemanagement.vehicle.exception.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class ExceptionHandler {
    @ResponseBody
    @org.springframework.web.bind.annotation.ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
            public ValidationError onConstraintException(ConstraintViolationException ex){
        ValidationError errors = new ValidationError();
        errors.setType("requestbodyerrors");
        ex.getConstraintViolations().stream().forEach(
                constraintViolation -> errors.getErrors().add(
                        new KeyValuePair(constraintViolation.getPropertyPath().toString(),constraintViolation.getMessage()))
        );
//        errors.setType("requestbodyerrors");
        return errors;
    }

    @ResponseBody
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationError onMethodArgsException(MethodArgumentNotValidException ex) {
        ValidationError errors = new ValidationError();
        errors.setType("requestbodyerrors");
        ex.getBindingResult().getFieldErrors().stream().forEach(
                bindingErrors -> errors.getErrors().add(
                        new KeyValuePair(bindingErrors.getField(), bindingErrors.getDefaultMessage()))
        );
        return errors;
    }
    @ResponseBody
    @org.springframework.web.bind.annotation.ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationError onBusinessValidationException(ValidationException ex) {
        ValidationError errors = new ValidationError();
        ex.getErrorCodes().stream().forEach(
                businessValidationError ->errors.getErrors().add(businessValidationError)
        );
            errors.setType("businessValidationError");
//        return new APIResponse(false,"400",errors);
        return errors;
    }

}
