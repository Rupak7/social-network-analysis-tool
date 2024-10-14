package com.assignment.socialnetworktool.service;

import java.util.List;
import java.util.Map;

public interface ISocialNetworkService {
    List<String> findShortestPath(String userId1, String userId2);
    Map<String, Integer> calculateDegreeCentrality();
    Map<Integer, Integer> identifyCommunities();
}

