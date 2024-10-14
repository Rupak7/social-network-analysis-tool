package com.assignment.socialnetworktool.service.impl;

import com.assignment.socialnetworktool.exception.FriendshipAlreadyExistsException;
import com.assignment.socialnetworktool.exception.UserNotFoundException;
import com.assignment.socialnetworktool.repository.IFriendshipRepository;
import com.assignment.socialnetworktool.repository.IUserRepository;
import com.assignment.socialnetworktool.service.impl.FriendshipService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FriendshipServiceTest {

    @Mock
    private IFriendshipRepository friendshipRepository;

    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private FriendshipService friendshipService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateFriendship_Success() {
        String userId1 = "user1";
        String userId2 = "user2";

        when(userRepository.exists(userId1)).thenReturn(true);
        when(userRepository.exists(userId2)).thenReturn(true);
        when(friendshipRepository.getFriends(userId1)).thenReturn(Collections.emptyList());

        friendshipService.createFriendship(userId1, userId2);

        verify(friendshipRepository, times(1)).addFriendship(userId1, userId2);
    }

    @Test
    public void testCreateFriendship_UserNotFound() {
        String userId1 = "user1";
        String userId2 = "user2";

        when(userRepository.exists(userId1)).thenReturn(false);

        assertThrows(UserNotFoundException.class, () -> {
            friendshipService.createFriendship(userId1, userId2);
        });

        verify(friendshipRepository, never()).addFriendship(anyString(), anyString());
    }

    @Test
    public void testCreateFriendship_FriendshipAlreadyExists() {
        String userId1 = "user1";
        String userId2 = "user2";

        when(userRepository.exists(userId1)).thenReturn(true);
        when(userRepository.exists(userId2)).thenReturn(true);
        when(friendshipRepository.getFriends(userId1)).thenReturn(Arrays.asList(userId2));

        assertThrows(FriendshipAlreadyExistsException.class, () -> {
            friendshipService.createFriendship(userId1, userId2);
        });

        verify(friendshipRepository, never()).addFriendship(anyString(), anyString());
    }

    @Test
    public void testListFriends() {
        String userId = "user1";
        List<String> friends = Arrays.asList("user2", "user3");

        when(friendshipRepository.getFriends(userId)).thenReturn(friends);

        List<String> result = friendshipService.listFriends(userId);

        assertEquals(friends, result);
    }

    @Test
    public void testGetAllFriendships() {
        Map<String, List<String>> friendships = Map.of(
                "user1", Arrays.asList("user2", "user3"),
                "user2", Arrays.asList("user1")
        );

        when(friendshipRepository.getAllFriendships()).thenReturn(friendships);

        Map<String, List<String>> result = friendshipService.getAllFriendships();

        assertEquals(friendships, result);
    }
}

