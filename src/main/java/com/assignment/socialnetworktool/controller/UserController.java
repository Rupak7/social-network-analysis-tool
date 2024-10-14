package com.assignment.socialnetworktool.controller;

import com.assignment.socialnetworktool.model.User;
import com.assignment.socialnetworktool.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * Adds a new user to the social network.
     *
     * @param user The user object to be added.
     * @return     A success message indicating that the user was added successfully.
     */
    @PostMapping
    public String addUser(@Valid @RequestBody User user) {
        userService.addUser(user);
        return "User added successfully";
    }

    /**
     * Retrieves a user by their ID.
     *
     * @param userId The ID of the user to be retrieved.
     * @return       The user object corresponding to the specified ID.
     */
    @GetMapping("/{userId}")
    public User getUser(@PathVariable String userId) {
        return userService.getUser(userId);
    }

    /**
     * Deletes a user by their ID.
     *
     * @param userId The ID of the user to be deleted.
     * @return       A success message indicating that the user was deleted successfully.
     */
    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId) {
        userService.removeUser(userId);
        return "User deleted successfully";
    }

    /**
     * Retrieves all users in the social network.
     *
     * @return A map containing all users, where the key is the user ID and the value is the user object.
     */
    @GetMapping
    public Map<String, User> getAllUsers() {
        return userService.listUsers();
    }
}


