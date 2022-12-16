package com.tarento.vehiclemanagement.vehicle.dto;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "vehicle", schema = "Vehiclemanagement")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long vehicleId;
    private String vehicleName;
    private String vehicleType;
    @JoinColumn(name = "model_id")
    private long modelId;
    private long chassisNumber;
    private Date createdAt;
    private Date updatedAt;
    private String createdBy;
    private String updatedBy;
    @Column(name = "status")
    private boolean status = true;


    public Vehicle() {
    }

    public Vehicle(long vehicleId, String vehicleName, String vehicleType, long modelId, long chassisNumber, Date createdAt, Date updatedAt, String createdBy, String updatedBy) {
        this.vehicleId = vehicleId;
        this.vehicleName = vehicleName;
        this.vehicleType = vehicleType;
        this.modelId = modelId;
        this.chassisNumber = chassisNumber;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public long getModelId() {
        return modelId;
    }

    public void setModelId(long modelId) {
        this.modelId = modelId;
    }

    public long getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(long chassisNumber) {
        this.chassisNumber = chassisNumber;
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

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", vehicleName='" + vehicleName + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", modelId=" + modelId +
                ", chassisNumber=" + chassisNumber +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                '}';
    }
}