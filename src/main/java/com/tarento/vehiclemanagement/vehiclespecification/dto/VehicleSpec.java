package com.tarento.vehiclemanagement.vehiclespecification.dto;

import net.bytebuddy.utility.dispatcher.JavaDispatcher;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class VehicleSpec {
    @Id
    private long specId;
//    @NotEmpty(message = "vehicleRPM must not be blank")
    private long vehicleRpm;
//    @NotEmpty(message = "fuelCap must not be blank")
    private String fuelCap;
//    @NotEmpty(message = "engineCap must not be blank")
    private String engineCap;
    @Min(1)
    @Max(99)
    private String mileage;
    @Min(101)
    @Max(999)
    private long modelId;

    public VehicleSpec() {

    }

    public VehicleSpec(long specId, long vehicleRpm, String fuelCap, String engineCap, String mileage, long modelId) {
        this.specId = specId;
        this.vehicleRpm = vehicleRpm;
        this.fuelCap = fuelCap;
        this.engineCap = engineCap;
        this.mileage = mileage;
        this.modelId = modelId;
    }

    public long getSpecId() {
        return specId;
    }

    public void setSpecId(long specId) {
        this.specId = specId;
    }

    public long getVehicleRpm() {
        return vehicleRpm;
    }

    public void setVehicleRpm(long vehicleRpm) {
        this.vehicleRpm = vehicleRpm;
    }

    public String getFuelCap() {
        return fuelCap;
    }

    public void setFuelCap(String fuelCap) {
        this.fuelCap = fuelCap;
    }

    public String getEngineCap() {
        return engineCap;
    }

    public void setEngineCap(String engineCap) {
        this.engineCap = engineCap;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public long getModelId() {
        return modelId;
    }

    public void setModelId(long modelId) {
        this.modelId = modelId;
    }

    @Override
    @JavaDispatcher.Container
    public String toString() {
        return "VehicleSpec{" +
                "specId=" + specId +
                ", vRPM=" + vehicleRpm +
                ", fuelCap='" + fuelCap + '\'' +
                ", engineCap='" + engineCap + '\'' +
                ", mileage='" + mileage + '\'' +
                ", modelId=" + modelId +
                '}';
    }
}
