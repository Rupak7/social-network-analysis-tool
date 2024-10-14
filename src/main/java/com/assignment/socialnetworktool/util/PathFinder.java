package com.assignment.socialnetworktool.util;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PathFinder {

    /**
     * Finds the shortest path between two users in the social network.
     *
     * @param userId1      The ID of the starting user.
     * @param userId2      The ID of the target user.
     * @param friendships  A map representing the friendships in the social network, where the key is a user ID and the value is a list of friends' IDs.
     * @return             A list of user IDs representing the shortest path from userId1 to userId2. Returns an empty list if no path is found.
     */
    public List<String> findShortestPath(String userId1, String userId2, Map<String, List<String>> friendships) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Map<String, String> previous = new HashMap<>();

        queue.add(userId1);
        visited.add(userId1);

        while (!queue.isEmpty()) {
            String current = queue.poll();

            if (current.equals(userId2)) {
                return constructPath(userId1, userId2, previous);
            }

            for (String neighbor : friendships.getOrDefault(current, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                    previous.put(neighbor, current);
                }
            }
        }

        return Collections.emptyList(); // No path found
    }

    /**
     * Constructs the path from the start user to the end user using the previous map.
     *
     * @param start     The ID of the starting user.
     * @param end       The ID of the target user.
     * @param previous  A map where the key is a user ID and the value is the previous user ID in the path.
     * @return          A list of user IDs representing the path from start to end.
     */
    private List<String> constructPath(String start, String end, Map<String, String> previous) {
        List<String> path = new LinkedList<>();
        for (String at = end; at != null; at = previous.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }

    /**
     * Calculates the degree centrality for each user in the social network.
     *
     * @param friendships  A map representing the friendships in the social network, where the key is a user ID and the value is a list of friends' IDs.
     * @return             A map where the key is a user ID and the value is the degree centrality of that user.
     */
    public Map<String, Integer> calculateDegreeCentrality(Map<String, List<String>> friendships) {
        Map<String, Integer> centrality = new HashMap<>();
        for (String userId : friendships.keySet()) {
            centrality.put(userId, friendships.get(userId).size());
        }
        return centrality;
    }
}
