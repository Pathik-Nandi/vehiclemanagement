package com.tarento.vehiclemanagement.dao;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository <User,Integer> {
  public User save(User users);

  User findByU_Name(String name);
}
