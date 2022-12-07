package com.tarento.demo.exception;

public class APIResponse {
    private boolean status;
    private String statusCode;
    private Object responseObject;

    public APIResponse(boolean status, String statusCode, Object responseObject) {
        this.status = status;
        this.statusCode = statusCode;
        this.responseObject = responseObject;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Object getResponseObject() {
        return responseObject;
    }

    public void setResponseObject(Object responseObject) {
        this.responseObject = responseObject;
    }
}
