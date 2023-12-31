package com.tarento.vehiclemanagement.vehiclemodel.dto;

import com.tarento.vehiclemanagement.audit.Auditable;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

//extends Auditable implements Source
@Entity
public class VehicleModel extends Auditable {
    @Id
    private long modelId;
    @NotEmpty(message = "Name must not be blank")
    private String modelName;
    @NotNull(message = "modelNumber must not be blank")
    private long modelNumber;
    @NotEmpty(message = "manufacturer must not be blank")
    private String manufacturer;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_of_manufacture", nullable = false, updatable = false)
    private Date dateOfManufacture;

    private boolean status;
    public VehicleModel() {
    }

    public VehicleModel(long modelId, String modelName, long modelNumber, String manufacturer, Date dateOfManufacture, boolean status) {
        this.modelId = modelId;
        this.modelName = modelName;
        this.modelNumber = modelNumber;
        this.manufacturer = manufacturer;
        this.dateOfManufacture = dateOfManufacture;
        this.status = status;
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

    public long getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(long modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Date getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(Date dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "VehicleModel{" +
                "modelId=" + modelId +
                ", modelName='" + modelName + '\'' +
                ", modelNumber=" + modelNumber +
                ", manufacturer='" + manufacturer + '\'' +
                ", dateOfManufacture=" + dateOfManufacture +
                ", status=" + status +
                '}';
    }
}
