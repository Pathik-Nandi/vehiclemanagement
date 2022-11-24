package com.tarento.vehiclemanagement.vehicle.service;

import com.tarento.vehiclemanagement.vehicle.data.UserDao;
import com.tarento.vehiclemanagement.vehicle.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;


    @Override
    public int addUser(User user) {
        return userDao.save(user).getuId();
    }

    @Override
    public Optional<User> getUser(int uId) {
        return userDao.findById(uId);
    }

//    @Override
//    public List<User> findByUName(String uName) {
//        return userDao.findByUName(uName);
//    }

//
    @Override
    public User getUserByName(String uName) {
        return userDao.findByuName(uName);
    }


    @Override
    public int deleteUser(int uId) {
         userDao.deleteById(uId);
        return uId;
    }

    @Override
    public int updateUser(User user, int uId) {
        userDao.save(user);
        return 1;
    }
}
