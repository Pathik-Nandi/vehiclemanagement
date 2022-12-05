package com.tarento.vehiclemanagement.vehiclespecification.data;

import com.tarento.vehiclemanagement.vehiclespecification.dto.VehicleSpec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleSpecDao extends JpaRepository<VehicleSpec, Long> {
}
