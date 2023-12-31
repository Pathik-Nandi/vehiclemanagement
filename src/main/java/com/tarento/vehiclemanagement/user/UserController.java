package com.tarento.vehiclemanagement.user;


import com.tarento.vehiclemanagement.user.dto.User;
import com.tarento.vehiclemanagement.user.service.UserService;
import io.micrometer.core.annotation.Timed;
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

    @GetMapping("/{userId}")
    @Timed(value = "get_user",description = "user displayed")
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
    @Timed(value = "add_user",description = "Adding user")
    public APIResponse addUser(@Valid @RequestBody User user) throws ValidationException {
        return new APIResponse(true, "200", userService.addUser(user));
    }

    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public void deleteUser(@PathVariable Long userId) {
         userService.deleteUser(userId);
    }

}

