package com.tarento.vehiclemanagement.controller;

import com.tarento.vehiclemanagement.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService Service;
    @PostMapping("/addUser")
    public org.apache.catalina.User addUser(@RequestBody User user){
        return Service.saveUser(user);


    }
    @PostMapping("/addUsers")
    public List<User> AddUser(@RequestBody List<User> users){
        return Service.saveUsers(users);
    }

    @GetMapping("/users/{id}")
    public User findUserById(@PathVariable int id){
        return Service.getUserByU_Name(String.valueOf(id));//..

    }
    @GetMapping("/users{name}")
    public User findUserByU_Name(@PathVariable String name){
        return Service.getUserByU_Name(name);
    }
    @PutMapping("/update")
    public User UpdateUser(@RequestBody User user){
        return Service.updateuser(user);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteUser(int id){
        return Service.deleteUser(id);
    }

}