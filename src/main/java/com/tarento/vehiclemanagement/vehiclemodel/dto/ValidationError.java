package com.tarento.vehiclemanagement.vehiclemodel.dto;

import java.util.ArrayList;
import java.util.List;

public class ValidationError {
    private List<KeyValuePair> errors = new ArrayList<>();
    private String type;

    public List<KeyValuePair> getErrors() {
        return errors;
    }

    public void setErrors(List<KeyValuePair> errors) {
        this.errors = errors;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}