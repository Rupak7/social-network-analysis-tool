package com.assignment.socialnetworktool.repository;

import com.assignment.socialnetworktool.model.User;

import java.util.Map;

public interface IUserRepository {
    void addUser(User user);
    void removeUser(String userId);
    User getUser(String userId);
    Map<String, User> getAllUsers();
}
