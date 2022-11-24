package com.tarento.vehiclemanagement.vehicle.dto;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Vehicle {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String v_name;
    private String v_type;
    private long m_id;

    public Vehicle() {
    }

    public Vehicle(long id, String v_name, String v_type, long m_id) {
        this.id = id;
        this.v_name = v_name;
        this.v_type = v_type;
        this.m_id = m_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getV_name() {
        return v_name;
    }

    public void setV_name(String v_name) {
        this.v_name = v_name;
    }

    public String getV_type() {
        return v_type;
    }

    public void setV_type(String v_type) {
        this.v_type = v_type;
    }

    public long getM_id() {
        return m_id;
    }

    public void setM_id(long m_id) {
        this.m_id = m_id;
    }
}