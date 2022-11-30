package com.tarento.vehiclemanagement.uservehiclemap.dto;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Date;

@Entity
@Table(name = "uv_map")
//@IdClass(MapIdClass.class)
public class UserVehicleMap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long map_id;
    @Min(2)
    private long userId;

    private long vehicleId;

//    @EmbeddedId
//    private MapIdClass mapIdClass;

    private Date createdAt;

    private Date updatedAt;

    private String createdBy;

    private String updatedBy;

    public UserVehicleMap() {
    }

    public UserVehicleMap(long map_id, long userId, long vehicleId, Date createdAt, Date updatedAt, String createdBy, String updatedBy) {
        this.map_id = map_id;
        this.userId = userId;
        this.vehicleId = vehicleId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public long getMap_id() {
        return map_id;
    }

    public void setMap_id(long map_id) {
        this.map_id = map_id;
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
        return "UserVehicleMap{" + "map_id=" + map_id + ", userId=" + userId + ", vehicleId=" + vehicleId + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", createdBy='" + createdBy + '\'' + ", updatedBy='" + updatedBy + '\'' + '}';
    }
    //    public UserVehicleMap(MapIdClass mapIdClass, Date createdAt, Date updatedAt, String createdBy, String updatedBy) {
//        this.mapIdClass = mapIdClass;
//        this.createdAt = createdAt;
//        this.updatedAt = updatedAt;
//        this.createdBy = createdBy;
//        this.updatedBy = updatedBy;
//    }
//
//    public MapIdClass getMapIdClass() {
//        return mapIdClass;
//    }
//
//    public void setMapIdClass(MapIdClass mapIdClass) {
//        this.mapIdClass = mapIdClass;
//    }
//
//    public Date getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(Date createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public Date getUpdatedAt() {
//        return updatedAt;
//    }
//
//    public void setUpdatedAt(Date updatedAt) {
//        this.updatedAt = updatedAt;
//    }
//
//    public String getCreatedBy() {
//        return createdBy;
//    }
//
//    public void setCreatedBy(String createdBy) {
//        this.createdBy = createdBy;
//    }
//
//    public String getUpdatedBy() {
//        return updatedBy;
//    }
//
//    public void setUpdatedBy(String updatedBy) {
//        this.updatedBy = updatedBy;
//    }
//
//    @Override
//    public String toString() {
//        return "UserVehicleMap{" +
//                "mapIdClass=" + mapIdClass +
//                ", createdAt=" + createdAt +
//                ", updatedAt=" + updatedAt +
//                ", createdBy='" + createdBy + '\'' +
//                ", updatedBy='" + updatedBy + '\'' +
//                '}';
//    }
}
