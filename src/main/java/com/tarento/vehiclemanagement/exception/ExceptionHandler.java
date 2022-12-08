package com.tarento.vehiclemanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class ExceptionHandler {

    @ResponseBody
    @org.springframework.web.bind.annotation.ExceptionHandler({ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationError onConstraintException(ConstraintViolationException ex) {
        ValidationError errors = new ValidationError();
        ex.getConstraintViolations().stream().forEach(constraintViolation -> errors.getErrors().add(new KeyValuePair(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage())));
        errors.setType("requestbodyerror");
        return errors;
    }

    @ResponseBody
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationError onMethodArgException(MethodArgumentNotValidException ex) {
        ValidationError erros = new ValidationError();
        ex.getBindingResult().getFieldErrors().stream().forEach(bindingError -> erros.getErrors().add(new KeyValuePair(bindingError.getField(), bindingError.getDefaultMessage())));
        erros.setType("requestbodyerror");
        return erros;
    }

    @ResponseBody
    @org.springframework.web.bind.annotation.ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationError onBusinessValidationException(NotFoundException ex) {
        ValidationError error = new ValidationError();
        ex.getErrorCodes().stream().forEach(businessValidationError -> error.getErrors().add(businessValidationError));
        error.setType("BusinessValidationError");
        return error;
    }

    @ResponseBody
    @org.springframework.web.bind.annotation.ExceptionHandler(CustomException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationError onBusinessValidationException(CustomException ex) {
        ValidationError error = new ValidationError();
        ex.getErrorCodes().forEach(businessValidationError -> error.getErrors().add(businessValidationError));
        error.setType("BusinessValidationError");
        return error;
    }

}