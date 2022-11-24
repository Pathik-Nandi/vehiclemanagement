package com.tarento.vehiclemanagement.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class VehicleModel {
    @Id
    private long modelId;
    private String modelName;
    private long modelNumber;

    public VehicleModel() {
    }

    public VehicleModel(long modelId, String modelName, long modelNumber) {
        this.modelId = modelId;
        this.modelName = modelName;
        this.modelNumber = modelNumber;
    }

    public long getModelId() {
        return modelId;
    }

    public void setModelId(long modelId) {
        this.modelId = modelId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public long getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(long modelNumber) {
        this.modelNumber = modelNumber;
    }

    @Override
    public String toString() {
        return "VehicleModel{" +
                "modelId=" + modelId +
                ", modelName='" + modelName + '\'' +
                ", modelNumber=" + modelNumber +
                '}';
    }
}
