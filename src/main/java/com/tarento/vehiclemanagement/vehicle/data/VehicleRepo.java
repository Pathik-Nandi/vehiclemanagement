package com.tarento.vehiclemanagement.vehicle.data;

import com.tarento.vehiclemanagement.vehicle.dto.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicle, Long> {
}
