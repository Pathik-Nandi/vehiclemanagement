package com.tarento.vehiclemanagement.exception;

import java.util.ArrayList;
import java.util.List;

public class NotFoundException extends RuntimeException {
    private transient List<KeyValuePair> errorCodes = new ArrayList<>();

    public NotFoundException(String key, String value) {
        errorCodes.add(new KeyValuePair(key, value));
    }

    public List<KeyValuePair> getErrorCodes() {
        return errorCodes;
    }

    public void setErrorCodes(List<KeyValuePair> errorCodes) {
        this.errorCodes = errorCodes;
    }

    public void addErrorCode(KeyValuePair keyValuePair) {
        this.errorCodes.add(keyValuePair);
    }
}
