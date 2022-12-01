package com.tarento.vehiclemanagement.dto;

import net.bytebuddy.utility.dispatcher.JavaDispatcher;

import javax.persistence.*;
import javax.validation.constraints.*;
import javax.xml.transform.Source;
import java.util.Date;
 //extends Auditable implements Source
@Entity
public class VehicleModel extends Auditable{
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
    @JavaDispatcher.Container
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
