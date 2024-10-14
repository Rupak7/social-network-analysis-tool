package com.assignment.socialnetworktool.repository.impl;

import com.assignment.socialnetworktool.model.User;
import com.assignment.socialnetworktool.repository.IUserRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements IUserRepository {
    private Map<String, User> users = new HashMap<>();

    @Override
    public void addUser(User user) {
        users.put(user.getUserId(), user);
    }

    @Override
    public void removeUser(String userId) {
        users.remove(userId);
    }

    @Override
    public User getUser(String userId) {
        return users.get(userId);
    }

    @Override
    public Map<String, User> getAllUsers() {
        return users;
    }
}

