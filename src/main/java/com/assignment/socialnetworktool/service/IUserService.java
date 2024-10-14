package com.assignment.socialnetworktool.service;

import com.assignment.socialnetworktool.model.User;

import java.util.Map;

public interface IUserService {
    void addUser(User user);

    void removeUser(String userId);

    User getUser(String userId);

    Map<String, User> listUsers();
}

