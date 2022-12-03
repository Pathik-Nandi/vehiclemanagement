package com.tarento.vehiclemanagement.vehiclespecification.dto;

import net.bytebuddy.utility.dispatcher.JavaDispatcher;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.xml.transform.Source;

@Entity
public class VehicleSpec extends Auditable implements Source {
    @Id
    private long specId;
    @NotEmpty(message = "vRPM must not be blank")
    private long vRPM;
    @NotEmpty(message = "fuelCap must not be blank")
    private String fuelCap;
    @NotEmpty(message = "engineCap must not be blank")
    private String engineCap;
    @Min(1)
    @Max(99)
    private String mileage;
    @Min(101)
    @Max(999)
    private long modelId;

    public VehicleSpec() {

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
    @JavaDispatcher.Container
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

    @Override
    public String getSystemId() {
        return null;
    }

    @Override
    public void setSystemId(String systemId) {
    }

    @Override
    public boolean isEmpty() {
        return Source.super.isEmpty();
    }
}
