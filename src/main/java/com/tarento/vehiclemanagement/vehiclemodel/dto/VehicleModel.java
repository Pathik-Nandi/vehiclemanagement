package com.tarento.vehiclemanagement.vehiclemodel.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Year;
import java.util.Date;

@Entity
@Table(name = "vehicle_model")
public class VehicleModel {
    @Id
    private long modelId;
    private String modelName;
    private long modelNum;
    private long manufacturedYear;
    private Date createdAt;
    private Date updatedAt;
    private String createdBy;
    private String updatedBy;

    public VehicleModel() {
    }

    public VehicleModel(long modelId, String modelName, long modelNum, long manufacturedYear, Date createdAt, Date updatedAt, String createdBy, String updatedBy) {
        this.modelId = modelId;
        this.modelName = modelName;
        this.modelNum = modelNum;
        this.manufacturedYear = manufacturedYear;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
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

    public long getModelNum() {
        return modelNum;
    }

    public void setModelNum(long modelNum) {
        this.modelNum = modelNum;
    }

    public long getManufacturedYear() {
        return manufacturedYear;
    }

    public void setManufacturedYear(long manufacturedYear) {
        this.manufacturedYear = manufacturedYear;
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
        return "VehicleModel{" +
                "modelId=" + modelId +
                ", modelName='" + modelName + '\'' +
                ", modelNum=" + modelNum +
                ", manufacturedYear=" + manufacturedYear +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                '}';
    }
}
