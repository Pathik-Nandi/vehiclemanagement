package com.tarento.vehiclemanagement.user;

//import com.codahale.metrics.annotation.Timed;

import com.tarento.vehiclemanagement.user.dto.User;
import com.tarento.vehiclemanagement.user.service.UserService;
import com.tarento.vehiclemanagement.vehicle.dto.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.bind.ValidationException;
import java.util.List;

@RequestMapping("/User")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public User getUser(@PathVariable int userId) {
        return userService.getUser(userId);
    }

    @GetMapping("/{userName}")
    public List<User> getUserByName(@PathVariable String userName) {
        return userService.getUserByName(userName);
    }

    @PostMapping("/addUser")
//    @Timed(value = "add.user",description = "Time taken to add user")
    public ApiResponse addUser(@Valid @RequestBody User user) throws ValidationException {

        return new ApiResponse(true, "200", userService.addUser(user));
    }

    @DeleteMapping("/{userId}")
    public long deleteUser(@RequestBody long userId) {
        return userService.deleteUser(userId);
    }

    @PutMapping("/{userId}")
    public int updateUser(@RequestBody User user, @PathVariable int userId) {
        return userService.updateUser(user, userId);
    }
}
