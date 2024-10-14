package com.assignment.socialnetworktool.service.impl;

import com.assignment.socialnetworktool.service.IFriendshipService;
import com.assignment.socialnetworktool.service.IUserService;
import com.assignment.socialnetworktool.util.PathFinder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SocialNetworkServiceTest {

    @Mock
    private IUserService userService;

    @Mock
    private IFriendshipService friendshipService;

    @Mock
    private PathFinder pathFinder;

    @InjectMocks
    private SocialNetworkService socialNetworkService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindShortestPath() {
        String userId1 = "user1";
        String userId2 = "user2";
        List<String> expectedPath = Arrays.asList("user1", "user3", "user2");

        when(friendshipService.getAllFriendships()).thenReturn(Map.of(
                "user1", Arrays.asList("user3"),
                "user3", Arrays.asList("user1", "user2"),
                "user2", Arrays.asList("user3")
        ));
        when(pathFinder.findShortestPath(userId1, userId2, friendshipService.getAllFriendships())).thenReturn(expectedPath);

        List<String> result = socialNetworkService.findShortestPath(userId1, userId2);

        assertEquals(expectedPath, result);
    }

    @Test
    public void testCalculateDegreeCentrality() {
        Map<String, Integer> expectedCentrality = Map.of(
                "user1", 2,
                "user2", 3,
                "user3", 1
        );

        when(friendshipService.getAllFriendships()).thenReturn(Map.of(
                "user1", Arrays.asList("user2", "user3"),
                "user2", Arrays.asList("user1", "user3", "user4"),
                "user3", Arrays.asList("user1")
        ));
        when(pathFinder.calculateDegreeCentrality(friendshipService.getAllFriendships())).thenReturn(expectedCentrality);

        Map<String, Integer> result = socialNetworkService.calculateDegreeCentrality();

        assertEquals(expectedCentrality, result);
    }

}

