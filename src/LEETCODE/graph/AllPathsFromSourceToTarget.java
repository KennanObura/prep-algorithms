package LEETCODE.graph;

/*
797. All Paths From Source to Target
Medium

Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1, and return them in any order.

The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).

Example 1:


Input: graph = [[1,2],[3],[3],[]]
Output: [[0,1,3],[0,2,3]]
Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
Example 2:


Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
Example 3:

Input: graph = [[1],[]]
Output: [[0,1]]
Example 4:

Input: graph = [[1,2,3],[2],[3],[]]
Output: [[0,1,2,3],[0,2,3],[0,3]]
Example 5:

Input: graph = [[1,3],[2],[3],[]]
Output: [[0,1,2,3],[0,3]]
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPathsFromSourceToTarget {
    public static void main(String[] args) {

        int[][] graph = {{1, 3}, {2}, {3}, {}};

        System.out.print(allPathsSourceTarget(graph));
    }

    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        Map<Integer, List<Integer>> map = new HashMap<>();


        for (int i = 0; i < graph.length; i++) {
            List<Integer> neigbours = new ArrayList<>();
            for (int node : graph[i])
                neigbours.add(node);

            map.put(i, neigbours);

        }


        boolean[] visited = new boolean[graph.length];

        List<Integer> internal = new ArrayList<>();

        doDFS(0, map, visited, internal);

        result.add(new ArrayList<>(internal));

        return result;
    }

    private static boolean doDFS(int i, Map<Integer, List<Integer>> map, boolean[] visited, List<Integer> internal) {

        List<Integer> neighbours = map.get(i);

        if (visited[i]) return false;
        visited[i] = true;
        internal.add(i);

        for (int neibour : neighbours) {
            if (!visited[neibour] & doDFS(neibour, map, visited, internal))
                return true;
        }


//        visited[i] = false;
//        internal.remove(internal.size() - 1);
        return false;

    }
}
