package com.assignment.socialnetworktool.service.impl;

import com.assignment.socialnetworktool.exception.FriendshipAlreadyExistsException;
import com.assignment.socialnetworktool.exception.FriendshipNotFoundException;
import com.assignment.socialnetworktool.exception.UserNotFoundException;
import com.assignment.socialnetworktool.repository.IFriendshipRepository;
import com.assignment.socialnetworktool.repository.IUserRepository;
import com.assignment.socialnetworktool.service.IFriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

import static com.assignment.socialnetworktool.constants.ExceptionConstants.*;

@Service
public class FriendshipService implements IFriendshipService {
    private final IFriendshipRepository friendshipRepository;

    private final IUserRepository userRepository;

    @Autowired
    public FriendshipService(IFriendshipRepository friendshipRepository, IUserRepository userRepository) {
        this.friendshipRepository = friendshipRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void createFriendship(String userId1, String userId2) {
        if (!userRepository.exists(userId1) || !userRepository.exists(userId2)) {
            throw new UserNotFoundException(USER_NOT_FOUND_EXCEPTION);
        }
        if (checkIfFriend(userId1, userId2)) {
            throw new FriendshipAlreadyExistsException(FRIENDSHIP_ALREADY_EXISTS_EXCEPTION);
        }
        friendshipRepository.addFriendship(userId1, userId2);
    }

    @Override
    public void removeFriendship(String userId1, String userId2) {
        if(!checkIfFriend(userId1, userId2)){
            throw new FriendshipNotFoundException(FRIENDSHIP_NOT_FOUND_EXCEPTION);
        }
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

    private boolean checkIfFriend(String userId1, String userId2){
        List<String> friends = friendshipRepository.getFriends(userId1);
        if(!CollectionUtils.isEmpty(friends)){
            for(String s: friends){
                if(s.equals(userId2)){
                    return true;
                }
            }
        }
        return false;
    }


}

