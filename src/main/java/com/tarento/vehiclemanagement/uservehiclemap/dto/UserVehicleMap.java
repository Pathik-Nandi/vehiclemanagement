package com.tarento.vehiclemanagement.uservehiclemap.dto;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "uv_map")
public class UserVehicleMap {
    @Id
    private long userId;
    private long vehicleId;

    private Date createdAt;

    private  Date updatedAt;

    private String createdBy;

    private String updatedBy;

    public UserVehicleMap() {
    }

    public UserVehicleMap(long userId, long vehicleId, Date createdAt, Date updatedAt, String createdBy, String updatedBy) {
        this.userId = userId;
        this.vehicleId = vehicleId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
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
        return "UserVehicleMap{" +
                "userId=" + userId +
                ", vehicleId=" + vehicleId +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                '}';
    }
}
