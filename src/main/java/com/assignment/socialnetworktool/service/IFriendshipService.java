package com.assignment.socialnetworktool.service;

import java.util.List;
import java.util.Map;

public interface IFriendshipService {
    void createFriendship(String userId1, String userId2);
    void removeFriendship(String userId1, String userId2);
    List<String> listFriends(String userId);
    Map<String, List<String>> getAllFriendships();
}

