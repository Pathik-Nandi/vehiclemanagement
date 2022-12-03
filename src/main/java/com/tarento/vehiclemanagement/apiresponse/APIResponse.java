package com.tarento.vehiclemanagement.apiresponse;

public class APIResponse {
    private Boolean status;
    private String statusCode;
    private Object responseData;

    public APIResponse() {
    }

    public APIResponse(Boolean status, String statusCode, Object responseData) {
        this.status = status;
        this.statusCode = statusCode;
        this.responseData = responseData;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Object getResponseData() {
        return responseData;
    }

    public void setResponseData(Object responseData) {
        this.responseData = responseData;
    }
}
