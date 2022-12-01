package com.tarento.vehiclemanagement.uservehiclemap.dto;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MapIdClass implements Serializable {
    private long userId;
    private long vehicleId;

    public MapIdClass() {
    }

    public MapIdClass(long userId, long vehicleId) {
        this.userId = userId;
        this.vehicleId = vehicleId;
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

    @Override
    public String toString() {
        return "MapIdClass{" +
                "userId=" + userId +
                ", vehicleId=" + vehicleId +
                '}';
    }
}
