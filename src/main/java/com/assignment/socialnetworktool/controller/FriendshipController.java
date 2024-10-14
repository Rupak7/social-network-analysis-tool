package com.assignment.socialnetworktool.controller;

import com.assignment.socialnetworktool.service.IFriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/friendships")
public class FriendshipController {

    @Autowired
    private IFriendshipService friendshipService;

    @Autowired
    public FriendshipController(IFriendshipService friendshipService) {
        this.friendshipService = friendshipService;
    }

    @PostMapping("/create")
    public String createFriendship(@RequestParam String userId1, @RequestParam String userId2) {
        friendshipService.createFriendship(userId1, userId2);
        return "Friendship created successfully";
    }

    @DeleteMapping("/remove")
    public String removeFriendship(@RequestParam String userId1, @RequestParam String userId2) {
        friendshipService.removeFriendship(userId1, userId2);
        return "Friendship removed successfully";
    }

    @GetMapping("/list")
    public List<String> listFriends(@RequestParam String userId) {
        return friendshipService.listFriends(userId);
    }

    @GetMapping("/all")
    public Map<String, List<String>> getAllFriendships() {
        return friendshipService.getAllFriendships();
    }
}


