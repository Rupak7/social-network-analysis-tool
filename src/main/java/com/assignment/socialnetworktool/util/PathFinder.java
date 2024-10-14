package com.assignment.socialnetworktool.util;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PathFinder {

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

    private List<String> constructPath(String start, String end, Map<String, String> previous) {
        List<String> path = new LinkedList<>();
        for (String at = end; at != null; at = previous.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }

    public Map<String, Integer> calculateDegreeCentrality(Map<String, List<String>> friendships) {
        Map<String, Integer> centrality = new HashMap<>();
        for (String userId : friendships.keySet()) {
            centrality.put(userId, friendships.get(userId).size());
        }
        return centrality;
    }
}
