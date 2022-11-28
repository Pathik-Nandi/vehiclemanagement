package com.tarento.vehiclemanagement.vehicle.dto;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long vehicleId;
    private long chassisNumber;
    private String vehicleName;
    private String vehicleType;
    private long modelId;
    @Column(updatable = false)
    private  Date Created_at;
    private Date Updated_at;
    public Vehicle() {
    }

    public Vehicle(long vehicleId, long chassisNumber, String vehicleName, String vehicleType, long modelId, Date created_at, Date updated_at) {
        this.vehicleId = vehicleId;
        this.chassisNumber = chassisNumber;
        this.vehicleName = vehicleName;
        this.vehicleType = vehicleType;
        this.modelId = modelId;
        Created_at = created_at;
        Updated_at = updated_at;
    }

    public long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public long getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(long chassisNumber) {
        this.chassisNumber = chassisNumber;
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

    public Date getCreated_at() {
        return Created_at;
    }

    public void setCreated_at(Date created_at) {
        Created_at = created_at;
    }

    public Date getUpdated_at() {
        return Updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        Updated_at = updated_at;
    }
}