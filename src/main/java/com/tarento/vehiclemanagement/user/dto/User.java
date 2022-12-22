package com.tarento.vehiclemanagement.user.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
@Table(name = "user", schema = "Vehiclemanagement")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Size(min = 3, max = 15)

    private String userName;

    private Long aadharNum;
    private Date createdAt;
    private String createdBy;
    private Date updatedAt;
    private String updatedBy;
    @JsonIgnore
    private boolean deleted = Boolean.FALSE;

    public User() {

    }

    public User(long userId, String userName, Long aadharNum, Date createdAt, String createdBy, Date updatedAt, String updatedBy, boolean deleted) {
        this.userId = userId;
        this.userName = userName;
        this.aadharNum = aadharNum;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
        this.deleted = deleted;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getAadharNum() {
        return aadharNum;
    }

    public void setAadharNum(Long aadharNum) {
        this.aadharNum = aadharNum;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;

    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", aadharNum=" + aadharNum +
                ", createdAt=" + createdAt +
                ", createdBy='" + createdBy + '\'' +
                ", updatedAt=" + updatedAt +
                ", updatedBy='" + updatedBy + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}

