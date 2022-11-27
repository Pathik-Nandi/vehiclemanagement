package com.tarento.vehiclemanagement.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class VehicleModel extends Auditable{
    @Id
    private long modelId;
    private String modelName;
    private long modelNumber;
    private String manufacturer;
    private Date dateOfManufacture;

    public VehicleModel() {
    }

    public VehicleModel(long modelId, String modelName, long modelNumber, String manufacturer, Date dateOfManufacture) {
        this.modelId = modelId;
        this.modelName = modelName;
        this.modelNumber = modelNumber;
        this.manufacturer = manufacturer;
        this.dateOfManufacture = dateOfManufacture;
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

    @Override
    public String toString() {
        return "VehicleModel{" +
                "modelId=" + modelId +
                ", modelName='" + modelName + '\'' +
                ", modelNumber=" + modelNumber +
                ", manufacturer='" + manufacturer + '\'' +
                ", dateOfManufacture=" + dateOfManufacture +
                '}';
    }
}
