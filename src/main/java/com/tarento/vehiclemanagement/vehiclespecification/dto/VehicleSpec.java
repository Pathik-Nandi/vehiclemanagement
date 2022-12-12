package com.tarento.vehiclemanagement.vehiclespecification.dto;

import com.tarento.vehiclemanagement.audit.Auditable;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
public class VehicleSpec {
    @Id
    private long specId;
    @NotEmpty(message = "vehicleRPM must not be blank")
    private long vehicleRpm;
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
    private Date createdAt;
    private Date updatedAt;
    private String createdBy;
    private String updatedBy;
    @Column(name = "status")
//    private Boolean active = true;
    private boolean deleted = Boolean.FALSE;

    public VehicleSpec() {
    }
    public VehicleSpec(long specId, long vehicleRpm, String fuelCap, String engineCap, String mileage, long modelId, Date createdAt, Date updatedAt, String createdBy, String updatedBy, boolean deleted) {
        this.specId = specId;
        this.vehicleRpm = vehicleRpm;
        this.fuelCap = fuelCap;
        this.engineCap = engineCap;
        this.mileage = mileage;
        this.modelId = modelId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.deleted = deleted;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
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
    public String toString() {
        return "VehicleSpec{" +
                "specId=" + specId +
                ", vRPM=" + vehicleRpm +
                ", fuelCap='" + fuelCap + '\'' +
                ", engineCap='" + engineCap + '\'' +
                ", mileage='" + mileage + '\'' +
                ", modelId=" + modelId +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}
