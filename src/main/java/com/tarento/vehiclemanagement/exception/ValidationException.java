package com.tarento.vehiclemanagement.exception;

import com.tarento.vehiclemanagement.dto.KeyValuePair;

import java.util.ArrayList;
import java.util.List;

public class ValidationException extends RuntimeException {
    private List<KeyValuePair> errorCodes = new ArrayList<>();
    public ValidationException(String key, String value){
        errorCodes.add(new KeyValuePair(key,value));

    }
    public List<KeyValuePair> getErrorCodes() {
        return errorCodes;
    }

    public void setErrorCodes(List<KeyValuePair> errorCodes) {
        this.errorCodes = errorCodes;
    }
    public void addErrorCodes(KeyValuePair keyValuePair){
        this.errorCodes.add(keyValuePair);
    }

}
