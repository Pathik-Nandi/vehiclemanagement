package com.tarento.vehiclemanagement.data;

import com.tarento.vehiclemanagement.dto.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Repository
//@ControllerAdvice
public interface VehicleModelDao extends JpaRepository<VehicleModel,Long> {
}
