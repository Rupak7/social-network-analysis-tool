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

    /**
     * Creates a friendship between two users.
     *
     * @param userId1 The ID of the first user.
     * @param userId2 The ID of the second user.
     * @return        A success message indicating that the friendship was created successfully.
     */
    @PostMapping("/create")
    public String createFriendship(@RequestParam String userId1, @RequestParam String userId2) {
        friendshipService.createFriendship(userId1, userId2);
        return "Friendship created successfully";
    }

    /**
     * Removes a friendship between two users.
     *
     * @param userId1 The ID of the first user.
     * @param userId2 The ID of the second user.
     * @return        A success message indicating that the friendship was removed successfully.
     */
    @DeleteMapping("/remove")
    public String removeFriendship(@RequestParam String userId1, @RequestParam String userId2) {
        friendshipService.removeFriendship(userId1, userId2);
        return "Friendship removed successfully";
    }

    /**
     * Lists all friends of a user.
     *
     * @param userId The ID of the user whose friends are to be listed.
     * @return       A list of user IDs representing the friends of the specified user.
     */
    @GetMapping("/list")
    public List<String> listFriends(@RequestParam String userId) {
        return friendshipService.listFriends(userId);
    }

    /**
     * Retrieves all friendships in the social network.
     *
     * @return A map where the key is a user ID and the value is a list of friends' IDs.
     */
    @GetMapping("/all")
    public Map<String, List<String>> getAllFriendships() {
        return friendshipService.getAllFriendships();
    }
}


