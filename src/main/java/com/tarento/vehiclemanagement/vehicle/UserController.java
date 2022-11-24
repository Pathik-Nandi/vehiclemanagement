package com.tarento.vehiclemanagement.vehicle;

import com.tarento.vehiclemanagement.vehicle.dto.User;
import com.tarento.vehiclemanagement.vehicle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser/{uId}")
    public Optional<User> getUser(@PathVariable int uId){
        return userService.getUser(uId);
    }


//    @GetMapping("/findByUName/{uName}")
//    public List<User> findByUName(@PathVariable String uName){
//        return userService.findByUName(uName);
//    }
//
    @GetMapping("/getUserByName/{uName}")
    public User getUserByName(@PathVariable String uName){
        return userService.getUserByName(uName);
    }

    @PostMapping("/addUser")
    public int addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @DeleteMapping("/deleteUser/{uId}")
        public int deleteUser(@RequestBody int uId){
            return userService.deleteUser(uId);
        }

    @PutMapping("/updateUser/{uId}")
    public int updateUser(@RequestBody User user,@PathVariable int uId){
        return userService.updateUser(user,uId);
    }
}
