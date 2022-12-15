package com.tarento.vehiclemanagement.uservehiclemap.dto;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Date;

@Entity
@Table(name = "uv_map")
public class UserVehicleMap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long mapId;
    @Min(2)
    private long userId;

    private long vehicleId;


    private Date createdAt;

    private Date updatedAt;

    private String createdBy;

    private String updatedBy;

    public UserVehicleMap() {
    }

    public UserVehicleMap(long mapId, long userId, long vehicleId, Date createdAt, Date updatedAt, String createdBy, String updatedBy) {
        this.mapId = mapId;
        this.userId = userId;
        this.vehicleId = vehicleId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public long getMapId() {
        return mapId;
    }

    public void setMapId(long mapId) {
        this.mapId = mapId;
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
        return "UserVehicleMap{" + "map_id=" + mapId + ", userId=" + userId + ", vehicleId=" + vehicleId + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", createdBy='" + createdBy + '\'' + ", updatedBy='" + updatedBy + '\'' + '}';
    }
}
