package com.tarento.vehiclemanagement.vehicle.dto;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.ArrayList;
import java.util.List;

public class ValidationError {
    private List<KeyValuePair> errors = new ArrayList<>();
    private String type;

    public ValidationError() {

    }
    public ValidationError(List<KeyValuePair> errors, String type) {
        this.errors = errors;
        this.type = type;
    }

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

    @Override
    public String toString() {
        return "ValidationError{" +
                "errors=" + errors +
                ", type='" + type + '\'' +
                '}';
    }
}
