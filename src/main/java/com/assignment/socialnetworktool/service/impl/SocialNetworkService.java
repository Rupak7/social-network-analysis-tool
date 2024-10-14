package com.assignment.socialnetworktool.service.impl;

import com.assignment.socialnetworktool.service.IFriendshipService;
import com.assignment.socialnetworktool.service.ISocialNetworkService;
import com.assignment.socialnetworktool.service.IUserService;
import com.assignment.socialnetworktool.util.PathFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SocialNetworkService implements ISocialNetworkService {
    private final IUserService userService;
    private final IFriendshipService friendshipService;
    private final PathFinder pathFinder;

    //private final CommunityDetectionService communityDetectionService;

    @Autowired
    public SocialNetworkService(IUserService userService, IFriendshipService friendshipService, PathFinder pathFinder) {
        this.userService = userService;
        this.friendshipService = friendshipService;
        this.pathFinder = pathFinder;
        //this.communityDetectionService = communityDetectionService;
    }

    @Override
    public List<String> findShortestPath(String userId1, String userId2) {
        return pathFinder.findShortestPath(userId1, userId2, friendshipService.getAllFriendships());
    }

    @Override
    public Map<String, Integer> calculateDegreeCentrality() {
        return pathFinder.calculateDegreeCentrality(friendshipService.getAllFriendships());
    }

    @Override
    public Map<Integer, Integer> identifyCommunities() {
        //return communityDetectionService.detectCommunities(friendshipService.getAllFriendships());
        return null;
    }
}

