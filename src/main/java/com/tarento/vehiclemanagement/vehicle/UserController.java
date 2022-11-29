package com.tarento.vehiclemanagement.vehicle;

import com.tarento.vehiclemanagement.vehicle.dto.User;
import com.tarento.vehiclemanagement.vehicle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/User")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public Optional<User> getUser(@PathVariable int userId){
        return userService.getUser(userId);
    }

    @GetMapping("/{userName}")
    public List<User> getUserByName(@PathVariable String userName){
        return userService.getUserByName(userName);
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @DeleteMapping("/{userId}")
        public long deleteUser(@RequestBody long userId){
            return userService.deleteUser(userId);
        }

    @PutMapping("/{userId}")
    public int updateUser(@RequestBody User user,@PathVariable int userId){
        return userService.updateUser(user,userId);
    }
}
