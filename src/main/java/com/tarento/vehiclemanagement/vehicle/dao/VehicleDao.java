package com.tarento.vehiclemanagement.vehicle.dao;

import com.tarento.vehiclemanagement.vehicle.dto.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.List;

@Repository
@ControllerAdvice
public interface VehicleDao extends JpaRepository <Vehicle,Long> {
    public  List<Vehicle> findBychassisNumber(long chassisNumber);
}

