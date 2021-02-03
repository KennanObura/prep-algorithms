package LEETCODE.leetcode;

import java.util.*;

public class MinimumTreeHeightHashSet {
    public static void main(String[] args) {
        int[][] edges = {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
        Graph graph = new Graph();

    }

    private static class Graph {
        private ArrayList<Set<Integer>> nodes;


        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            List<Integer> result = new ArrayList<>();
            if (edges.length == 0) return result;

            this.nodes = new ArrayList<>(n);

            build(n, edges);
            print();


            return doBfsTopologicalSort(n, result);

        }

        private List<Integer> doBfsTopologicalSort(int n, List<Integer> result) {
            if (n > 2) {
                Queue<Integer> queue = new LinkedList<>();

                /*
                 *
                 * Consider leaves and add to Queue;
                 *  Will be detached from tree
                 *      Detaching
                 *          - remove link with neihbour
                 *          - remove from list nodes
                 *      repeat
                 */

                for (int i = 0; i < n; i++)
                    if (nodes.get(i).size() == 1)
                        queue.add(i);

                while (!queue.isEmpty()) {
                    int current = queue.remove();
//                    int nextFromCurrent = nodes.get(current);
                }


            }
            return result;
        }

        private void print() {
            for (Set<Integer> set : nodes)
                System.out.println(Arrays.toString(set.toArray()));
        }

        private void build(int n, int[][] edges) {
            for (int i = 0; i < n; i++)
                nodes.add(new HashSet<>());

            for (int[] edge : edges) {
                nodes.get(edge[0]).add(edge[1]);
                nodes.get(edge[1]).add(edge[0]);
            }
        }


    }
}
