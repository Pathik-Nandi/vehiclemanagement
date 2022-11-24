package com.tarento.demo.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VehicleSpec extends Auditable {
    @Id
    private long specId;
    private long vRPM;
    private String fuelCap;
    private String engineCap;
    private String mileage;
    private  long modelId;

    public VehicleSpec(){

    }

    public VehicleSpec(long specId, long vRPM, String fuelCap, String engineCap, String mileage, long modelId) {
        this.specId = specId;
        this.vRPM = vRPM;
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

    public long getvRPM() {
        return vRPM;
    }

    public void setvRPM(long vRPM) {
        this.vRPM = vRPM;
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
    public String toString() {
        return "VehicleSpec{" +
                "specId=" + specId +
                ", vRPM=" + vRPM +
                ", fuelCap='" + fuelCap + '\'' +
                ", engineCap='" + engineCap + '\'' +
                ", mileage='" + mileage + '\'' +
                ", modelId=" + modelId +
                '}';
    }

}
