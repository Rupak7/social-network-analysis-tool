package com.assignment.socialnetworktool.service.impl;

import com.assignment.socialnetworktool.exception.UserAlreadyExistsException;
import com.assignment.socialnetworktool.exception.UserNotFoundException;
import com.assignment.socialnetworktool.model.User;
import com.assignment.socialnetworktool.repository.IUserRepository;
import com.assignment.socialnetworktool.service.impl.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddUser_Success() {
        User user = new User("user1", "John Doe", "jon12@gmail.com");

        when(userRepository.exists(user.getUserId())).thenReturn(false);

        userService.addUser(user);

        verify(userRepository, times(1)).addUser(user);
    }

    @Test
    public void testAddUser_UserAlreadyExists() {
        User user = new User("user1", "John Doe", "jon12@gmail.com");

        when(userRepository.exists(user.getUserId())).thenReturn(true);

        assertThrows(UserAlreadyExistsException.class, () -> {
            userService.addUser(user);
        });

        verify(userRepository, never()).addUser(any(User.class));
    }

    @Test
    public void testRemoveUser_Success() {
        String userId = "user1";

        when(userRepository.exists(userId)).thenReturn(true);

        userService.removeUser(userId);

        verify(userRepository, times(1)).removeUser(userId);
    }

    @Test
    public void testRemoveUser_UserNotFound() {
        String userId = "user1";

        when(userRepository.exists(userId)).thenReturn(false);

        assertThrows(UserNotFoundException.class, () -> {
            userService.removeUser(userId);
        });

        verify(userRepository, never()).removeUser(anyString());
    }

    @Test
    public void testGetUser() {
        String userId = "user1";
        User user = new User(userId, "John Doe", "jon12@gmail.com");

        when(userRepository.getUser(userId)).thenReturn(user);

        User result = userService.getUser(userId);

        assertEquals(user, result);
    }

    @Test
    public void testListUsers() {
        Map<String, User> users = Map.of(
                "user1", new User("user1", "John Doe", "jon12@gmail.com"),
                "user2", new User("user2", "Jane Doe", "jane12@gmail.com")
        );

        when(userRepository.getAllUsers()).thenReturn(users);

        Map<String, User> result = userService.listUsers();

        assertEquals(users, result);
    }
}

