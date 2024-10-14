package com.assignment.socialnetworktool.repository.impl;

import com.assignment.socialnetworktool.repository.IFriendshipRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class FriendshipRepositoryImpl implements IFriendshipRepository {
    private Map<String, List<String>> friendships = new HashMap<>();

    @Override
    public void addFriendship(String userId1, String userId2) {
        friendships.computeIfAbsent(userId1, k -> new ArrayList<>()).add(userId2);
        friendships.computeIfAbsent(userId2, k -> new ArrayList<>()).add(userId1);
    }

    @Override
    public void removeFriendship(String userId1, String userId2) {
        friendships.getOrDefault(userId1, new ArrayList<>()).remove(userId2);
        friendships.getOrDefault(userId2, new ArrayList<>()).remove(userId1);
    }

    @Override
    public List<String> getFriends(String userId) {
        return friendships.getOrDefault(userId, new ArrayList<>());
    }

    @Override
    public Map<String, List<String>> getAllFriendships() {
        return friendships;
    }
}

