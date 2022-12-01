package com.tarento.vehiclemanagement.vehicle.dto;

public class ApiResponse {
    private boolean status;
    private String statusCode;
    private Object responseData;

    public ApiResponse(boolean status, String statusCode, Object responseData) {
        this.status = status;
        this.statusCode = statusCode;
        this.responseData = responseData;
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

    public Object getResponseData() {
        return responseData;
    }

    public void setResponseData(Object responseData) {
        this.responseData = responseData;
    }
}
