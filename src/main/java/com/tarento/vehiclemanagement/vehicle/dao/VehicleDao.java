package com.tarento.vehiclemanagement.vehicle.dao;

import com.tarento.vehiclemanagement.vehicle.dto.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleDao extends JpaRepository <Vehicle,Long>{


//   public long addVehicle(Vehicle vehicle) ;

//    public List<Vehicle> getByVehicleId(long v_id) ;

}
