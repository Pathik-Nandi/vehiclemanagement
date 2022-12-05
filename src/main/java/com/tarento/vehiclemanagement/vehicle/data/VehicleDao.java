package com.tarento.vehiclemanagement.vehicle.data;

import com.tarento.vehiclemanagement.vehicle.dto.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@ControllerAdvice
public interface VehicleDao extends JpaRepository<Vehicle, Long> {
//    @Modifying
//    @Query(value = "Select * from vehicle where chassis_number=?1", nativeQuery = true)
    public List<Vehicle> findBychassisNumber(long chassisNumber);
}

