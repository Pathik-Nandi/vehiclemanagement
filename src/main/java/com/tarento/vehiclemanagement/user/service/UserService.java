package com.tarento.vehiclemanagement.user.service;

import com.tarento.vehiclemanagement.user.dto.User;

import javax.xml.bind.ValidationException;
import java.util.List;



public interface UserService {
    public User addUser(User user) throws ValidationException;

    public User getUserById(long userId);

    public List<User> getUserByName(String userName);

    public List<User> getUserByAadhar(long aadharNum);

    public User updateUser(User user);

    public void deleteUser(long aadharNum);


}



