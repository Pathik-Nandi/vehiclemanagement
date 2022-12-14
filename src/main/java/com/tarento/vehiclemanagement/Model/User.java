package com.tarento.vehiclemanagement.Model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;

@Entity
@Table(name="User_Table")
public class User {
    @Id
    @GeneratedValue
    private int U_id;

    public User() {
    }

    public User(int u_id, String u_Name, int p_Number, String address, String dataCreated) {
        U_id = u_id;
        U_Name = u_Name;
        P_Number = p_Number;
        Address = address;
        this.dataCreated = dataCreated;
    }

    private String U_Name;
    private int P_Number;

    public int getU_id() {
        return U_id;
    }

    public void setU_id(int u_id) {
        U_id = u_id;
    }

    public String getU_Name() {
        return U_Name;
    }

    public void setU_Name(String u_Name) {
        U_Name = u_Name;
    }

    public int getP_Number() {
        return P_Number;
    }

    public void setP_Number(int p_Number) {
        P_Number = p_Number;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getDataCreated() {
        return dataCreated;
    }

    public void setDataCreated(String dataCreated) {
        this.dataCreated = dataCreated;
    }

    private String Address;
    @JsonFormat(pattern = "yyyy- MM_dd",shape = JsonFormat.Shape.STRING)
    @Column(name="date_create")
    private String dataCreated;

}
