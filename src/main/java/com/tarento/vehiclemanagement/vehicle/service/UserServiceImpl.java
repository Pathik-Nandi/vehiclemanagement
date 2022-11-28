package com.tarento.vehiclemanagement.vehicle.service;

import com.tarento.vehiclemanagement.vehicle.data.UserDao;
import com.tarento.vehiclemanagement.vehicle.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;


    @Override
    public String addUser(User user) {
        String userName=user.getUserName();
        List usernameList=getUserByName(userName);
        if (usernameList.size()>0){
            return "User already exist";
        }
        userDao.save(user);
        return "Added";
    }

    @Override
    public Optional<User> getUser(long userId) {
        return userDao.findById(userId);
    }

//    @Override
//    public List<User> findByUName(String uName) {
//        return userDao.findByUName(uName);
//    }

//
    @Override
    public List<User> getUserByName(String userName) {
        return userDao.findByuserName(userName);
    }


    @Override
    public long deleteUser(long userId) {
         userDao.deleteById(userId);
        return userId;
    }

    @Override
    public int updateUser(User user, int userId) {
        userDao.save(user);
        return 1;
    }
}
