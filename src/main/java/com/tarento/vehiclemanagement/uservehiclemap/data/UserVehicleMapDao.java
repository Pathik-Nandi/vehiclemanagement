package com.tarento.vehiclemanagement.uservehiclemap.data;

import com.tarento.vehiclemanagement.uservehiclemap.dto.UserVehicleMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserVehicleMapDao extends JpaRepository<UserVehicleMap,Long> {

}
