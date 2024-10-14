package com.assignment.socialnetworktool.repository;

import java.util.List;
import java.util.Map;

public interface IFriendshipRepository {
    void addFriendship(String userId1, String userId2);
    void removeFriendship(String userId1, String userId2);
    List<String> getFriends(String userId);
    Map<String, List<String>> getAllFriendships();
}
