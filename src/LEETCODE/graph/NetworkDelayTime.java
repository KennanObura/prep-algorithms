package LEETCODE.graph;

import java.util.*;

/**
 * 743. Network Delay Time
 * Medium
 * You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.
 * <p>
 * We will send a signal from a given node k. Return the time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * Output: 2
 * Example 2:
 * <p>
 * Input: times = [[1,2,1]], n = 2, k = 1
 * Output: 1
 * Example 3:
 * <p>
 * Input: times = [[1,2,1]], n = 2, k = 2
 * Output: -1
 */

public class NetworkDelayTime {
    public static void main(String[] args) {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        System.out.println(networkDelayTime(times, 4, 2));


        int[][] times2 = {{1, 2, 1}};
        System.out.println(networkDelayTime(times2, 2, 1));


        int[][] times3 = {{1, 2, 1}};
        System.out.println(networkDelayTime(times3, 2, 2));

    }


    public static int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, ArrayList<int[]>> map = new HashMap<>();

        for (int[] edge : times) {
            int node = edge[0];
            int target = edge[1];
            int time = edge[2];
            map.putIfAbsent(node, new ArrayList<>());
            ArrayList<int[]> list = map.get(node);
            list.add(new int[]{target, time});
            map.put(node, list);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });


        Map<Integer, Integer> distance = new HashMap<>();

        queue.add(new int[]{k, 0});


        while (!queue.isEmpty()) {
            int[] time = queue.poll();
            int node = time[0];
            int timeTakenNode = time[1];

            if (distance.containsKey(node)) continue;
            ArrayList<int[]> edges = map.get(node);

            for (int[] edge : edges) {
                int target = edge[0];
                int timeToTarget = edge[1];
                System.out.println(timeToTarget + " --");
                if (map.containsKey(target)) {
                    distance.put(target, timeToTarget + timeTakenNode);
                    queue.add(new int[]{target, timeToTarget + timeTakenNode});
                }

            }


        }

        int maxTime = -1;

        for (Map.Entry<Integer, Integer> entry : distance.entrySet()) {
            if (entry.getValue() == Integer.MAX_VALUE) continue;
            maxTime = Math.max(maxTime, entry.getValue());
        }

        return maxTime;

    }


}
