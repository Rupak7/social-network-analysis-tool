package com.assignment.socialnetworktool.service.impl;

import com.assignment.socialnetworktool.exception.FriendshipAlreadyExistsException;
import com.assignment.socialnetworktool.exception.UserAlreadyExistsException;
import com.assignment.socialnetworktool.exception.UserNotFoundException;
import com.assignment.socialnetworktool.model.User;
import com.assignment.socialnetworktool.repository.IUserRepository;
import com.assignment.socialnetworktool.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService implements IUserService {
    private final IUserRepository userRepository;

    @Autowired
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(User user) {
        if(userRepository.exists(user.getUserId())){
            throw new UserAlreadyExistsException("User already exists");
        }
        userRepository.addUser(user);
    }

    @Override
    public void removeUser(String userId) {
        if(!userRepository.exists(userId)){
            throw new UserNotFoundException("User doesn't exists");
        }
        userRepository.removeUser(userId);
    }

    @Override
    public User getUser(String userId) {
        return userRepository.getUser(userId);
    }

    @Override
    public Map<String, User> listUsers() {
        return userRepository.getAllUsers();
    }
}

