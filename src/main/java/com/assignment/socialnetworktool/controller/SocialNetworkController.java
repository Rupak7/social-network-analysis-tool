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

    @GetMapping("/shortest-path")
    public List<String> findShortestPath(@RequestParam String userId1, @RequestParam String userId2) {
        return socialNetworkService.findShortestPath(userId1, userId2);
    }

    @GetMapping("/degree-centrality")
    public Map<String, Integer> calculateDegreeCentrality() {
        return socialNetworkService.calculateDegreeCentrality();
    }

//    @GetMapping("/communities")
//    public Map<String, Integer> identifyCommunities() {
//        return socialNetworkService.identifyCommunities();
//    }
}

