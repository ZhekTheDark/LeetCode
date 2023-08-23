package com.medium;

import java.util.*;

public class _841_KeysAndRooms {

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visitedRooms = new HashSet<>();
        Queue<Integer> roomsToOpen = new LinkedList<>(rooms.get(0));
        visitedRooms.add(0);
        while (!roomsToOpen.isEmpty()) {
            Integer roomToOpen = roomsToOpen.poll();
            if (!visitedRooms.contains(roomToOpen)) {
                roomsToOpen.addAll(rooms.get(roomToOpen));
            }
            visitedRooms.add(roomToOpen);
        }

        return visitedRooms.size() == rooms.size();
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(3),
                Collections.emptyList()
        );
        System.out.println(canVisitAllRooms(rooms));
    }
}
