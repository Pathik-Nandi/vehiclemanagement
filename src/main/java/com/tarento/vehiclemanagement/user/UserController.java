package com.tarento.vehiclemanagement.user;

//import com.codahale.metrics.annotation.Timed;

import com.tarento.vehiclemanagement.user.dto.User;
import com.tarento.vehiclemanagement.user.service.UserService;
import com.tarento.vehiclemanagement.vehicle.dto.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tarento.vehiclemanagement.apiresponse.APIResponse;
import javax.validation.Valid;
import javax.xml.bind.ValidationException;
import java.util.List;

@RequestMapping("/User")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

//    @GetMapping("/{userId}")
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public User getUserById(@PathVariable int userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/getByName/{userName}")
    public List<User> getUserByName(@RequestParam(value="userName") String userName) {
        return userService.getUserByName(userName);
    }

    @GetMapping("/getByAadhar/{aadharNum}")
    public List<User> getUserByAadhar(@RequestParam(value="aadharNum") long aadharNum) {
        return userService.getUserByAadhar(aadharNum);
    }

    @PostMapping("/addUser")
//    @Timed(value = "add.user",description = "Time taken to add user")
    public APIResponse addUser(@Valid @RequestBody User user) throws ValidationException {
        return new APIResponse(true, "200", userService.addUser(user));
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
