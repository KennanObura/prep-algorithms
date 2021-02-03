package LEETCODE.leetcode;

import java.util.*;

/**
 * A tree is an undirected graph in which any two vertices are connected by exactly one path.
 * In other words, any connected graph without simple cycles is a tree.
 * <p>
 * Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi]
 * indicates that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree as the root.
 * When you select a node x as the root, the result tree has height h. Among all possible rooted trees,
 * those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).
 * <p>
 * Return a list of all MHTs' root labels. You can return the answer in any order.
 */
public class MinimumTreeHeight {
    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{1, 0}, {1, 2}, {1, 3}};

        int n2 = 6;
        int[][] edges2 = {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}, {5, 6}};

        int n3 = 2;
        int[][] edges3 = {{0, 1}};

        int n4 = 1;
        int[][] edges4 = {};

        Solution solution = new Solution();
        List<Integer> result = solution.findMinHeightTrees(n4, edges4);
        System.out.println(Arrays.toString(result.toArray()));
    }
}

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();


        createGraph(n, edges);
        bfsTopologicalSort(n);


        for (Map.Entry<Integer, LinkedList<Integer>> node : map.entrySet())
            result.add(node.getKey());
        return result;
    }


    private static void bfsTopologicalSort(int n) {
        if (n > 2) {
            Queue<Integer> queueOfLeaveNodes = new LinkedList<>();


            /*
             * remove all the leave nodes (Nodes with 1 edge), and enqueue
             */
            for (Map.Entry<Integer, LinkedList<Integer>> node : map.entrySet())
                if (node.getValue().size() == 1)
                    queueOfLeaveNodes.add(node.getKey());


            /*
             * poll from queue one by one and update leave
             */

            while (!queueOfLeaveNodes.isEmpty()) {

                int current = queueOfLeaveNodes.remove();

                if (!map.get(current).isEmpty()) {
                    int neigbourOfCurrent = map.get(current).getFirst();

                    //updating leaves now
                    map.get(neigbourOfCurrent).removeFirstOccurrence(current);
                    map.remove(current);

                }

            }

            bfsTopologicalSort(map.size());

        }
    }


    private static final Map<Integer, LinkedList<Integer>> map = new HashMap<>();


    private void createGraph(int n, int[][] edges) {
        for (int i = 0; i < n; i++)
            map.put(i, new LinkedList<>());



        addEdges(edges);
    }

    private void addEdges(int[][] edges) {
        for (int[] edge : edges) {
            map.get(edge[0]).addFirst(edge[1]);
            map.get(edge[1]).addFirst(edge[0]);
        }

        for (Map.Entry<Integer, LinkedList<Integer>> node : map.entrySet())
            System.out.println(Arrays.toString(node.getValue().toArray(new Integer[0])));
    }
}