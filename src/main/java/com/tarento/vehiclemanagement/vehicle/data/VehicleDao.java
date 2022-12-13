package com.tarento.vehiclemanagement.vehicle.data;

import com.tarento.vehiclemanagement.vehicle.dto.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.List;

@Repository
@ControllerAdvice
public interface VehicleDao extends JpaRepository<Vehicle, Long> {
    public List<Vehicle> findBychassisNumber(long chassisNumber);

    @Modifying
    @Transactional
    @Query(value = "update vehicle set status=0 where vehicle_id=?1", nativeQuery = true)
    public void delete(long vehicleId);
}


