package com.assignment.socialnetworktool.controller;

import com.assignment.socialnetworktool.model.User;
import com.assignment.socialnetworktool.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping
    public String addUser(@RequestBody User user) {
        userService.addUser(user);
        return "User added successfully";
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable String userId) {
        return userService.getUser(userId);
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId) {
        userService.removeUser(userId);
        return "User deleted successfully";
    }

    @GetMapping
    public Map<String, User> getAllUsers() {
        return userService.listUsers();
    }
}


