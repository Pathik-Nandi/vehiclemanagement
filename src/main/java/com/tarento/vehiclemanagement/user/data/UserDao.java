package com.tarento.vehiclemanagement.user.data;

import com.tarento.vehiclemanagement.user.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    public List<User> findByuserName(String userName);

    public List<User> findByaadharNum(long aadharNum);
}
