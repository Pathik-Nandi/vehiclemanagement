package com.tarento.demo.exception;


import com.tarento.demo.util.AppDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

@ControllerAdvice
public class AppExceptionHandling {

    @Autowired
    AppErrorResponse errorResponse;

    @Autowired
    AppDateTime timestamp;

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
    public ValidationError onBusinessValidationException(com.tarento.demo.exception.ValidationException ex) {
        ValidationError errors = new ValidationError();
        ex.getErrorCodes().stream().forEach(
                businessValidationError -> errors.getErrors().add(businessValidationError)
        );
        return errors;
    }






    /**
     * Adding generic exception handling
     */

    public ResponseEntity<AppErrorResponse> handleException(Exception exc) {
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(exc.getMessage());
        errorResponse.setTimestamp(timestamp.getCurrentDate());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     * Custom error response
     */

    public ResponseEntity<AppErrorResponse> handleException(AppException exc) {

        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(exc.getMessage());
        errorResponse.setTimestamp(timestamp.getCurrentDate());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
