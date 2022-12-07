package com.tarento.vehiclemanagement.uservehiclemap.data;

import com.tarento.vehiclemanagement.uservehiclemap.dto.UserVehicleMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserVehicleMapDao extends JpaRepository<UserVehicleMap, Long> {

    public List<UserVehicleMap> findByVehicleId(long vehicleId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE uv_map SET status=0 where user_id=?1 and vehicle_id=?2", nativeQuery = true)
    public void deleteByUserIdAndVehicleId(long userId, long vehicleId);

    public List<UserVehicleMap> findByUserId(long userId);

    public Optional<UserVehicleMap> findByUserIdAndVehicleId(long userId,long vehicleId);


}
