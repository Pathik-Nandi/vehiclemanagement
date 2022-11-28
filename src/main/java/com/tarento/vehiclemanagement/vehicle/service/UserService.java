package com.tarento.vehiclemanagement.vehicle.service;

import com.tarento.vehiclemanagement.vehicle.dto.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public String addUser(User user);
    public Optional<User> getUser(long userId);

    public List<User> getUserByName(String userName);

    public long deleteUser(long userId);
    public int updateUser(User user,int userId);

}
