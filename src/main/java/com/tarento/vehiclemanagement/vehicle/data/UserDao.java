package com.tarento.vehiclemanagement.vehicle.data;

import com.tarento.vehiclemanagement.vehicle.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {
   // public User findByUserId(int uId);
//    public List<User> findByUName(String uName);
 public User findByuName(String uName);
}
