package com.tarento.vehiclemanagement.user.service;

import com.tarento.vehiclemanagement.user.dto.User;

import javax.xml.bind.ValidationException;
import java.util.List;



public interface UserService {
    public User addUser(User user) throws ValidationException;

    public User getUserById(long userId);

    public List<User> getUserByName(String userName);

    public List<User> getUserByAadhar(Long aadharNum);


    public long deleteUser(long userId);

    public User updateUser(User user,Long aadharNum);

    public Iterable<User> findAll(boolean isDeleted);

}



