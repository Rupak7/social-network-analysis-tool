package com.assignment.socialnetworktool.controller;

import com.assignment.socialnetworktool.service.ISocialNetworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/social-network")
public class SocialNetworkController {

    @Autowired
    private ISocialNetworkService socialNetworkService;

    /**
     * Finds the shortest path between two users in the social network.
     *
     * @param userId1 The ID of the starting user.
     * @param userId2 The ID of the target user.
     * @return        A list of user IDs representing the shortest path from userId1 to userId2. Returns an empty list if no path is found.
     */
    @GetMapping("/shortest-path")
    public List<String> findShortestPath(@RequestParam String userId1, @RequestParam String userId2) {
        return socialNetworkService.findShortestPath(userId1, userId2);
    }

    /**
     * Calculates the degree centrality for each user in the social network.
     *
     * @return A map where the key is a user ID and the value is the degree centrality of that user.
     */
    @GetMapping("/degree-centrality")
    public Map<String, Integer> calculateDegreeCentrality() {
        return socialNetworkService.calculateDegreeCentrality();
    }

//    @GetMapping("/communities")
//    public Map<String, Integer> identifyCommunities() {
//        return socialNetworkService.identifyCommunities();
//    }
}

