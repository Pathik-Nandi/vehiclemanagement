package com.tarento.vehiclemanagement.service;
import com.tarento.vehiclemanagement.dao.UserDao;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//import java.util.Optional;


@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User saveUser(User user) {
        return userDao.save(user);
    }

    public List<User> saveUsers(List<User> users) {
        return userDao.saveAll(users);
    }

    public List<User> getUsers() {
        return userDao.findAll();


    }

    public User getUserById(int id) {
        return userDao.findById(id).orElse(null);//OrElse is if we not give here values means it's come null that's why
    }

    public User getUserByU_Name(String name) {
        return userDao.findByU_Name(name);
    }

    public String deleteUser(int id) {
        userDao.deleteById(id);
        return "user removed !!" + id;

    }
//    public User updateUser(User user){
//       userDao.save(user);
//       return user;
//    }


    public User updateuser(User user) {


        return user;
    }

}
































