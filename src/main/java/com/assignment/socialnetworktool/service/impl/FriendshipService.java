package com.assignment.socialnetworktool.service.impl;

import com.assignment.socialnetworktool.repository.IFriendshipRepository;
import com.assignment.socialnetworktool.service.IFriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FriendshipService implements IFriendshipService {
    private final IFriendshipRepository friendshipRepository;

    @Autowired
    public FriendshipService(IFriendshipRepository friendshipRepository) {
        this.friendshipRepository = friendshipRepository;
    }

    @Override
    public void createFriendship(String userId1, String userId2) {
        friendshipRepository.addFriendship(userId1, userId2);
    }

    @Override
    public void removeFriendship(String userId1, String userId2) {
        friendshipRepository.removeFriendship(userId1, userId2);
    }

    @Override
    public List<String> listFriends(String userId) {
        return friendshipRepository.getFriends(userId);
    }

    @Override
    public Map<String, List<String>> getAllFriendships() {
        return friendshipRepository.getAllFriendships();
    }


}

