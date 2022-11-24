package com.tarento.vehiclemanagement.vehicle.service;

import com.tarento.vehiclemanagement.vehicle.dto.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public int addUser(User user);
    public Optional<User> getUser(int uId);
//    List<User> findByUName(String uName);
        public User getUserByName(String uName);

    public int deleteUser(int uId);
    public int updateUser(User user,int uId);

}
