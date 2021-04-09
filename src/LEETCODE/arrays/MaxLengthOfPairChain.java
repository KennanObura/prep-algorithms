package LEETCODE.arrays;

import java.util.*;

/**
 * 646. Maximum Length of Pair Chain
 * Medium
 * You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.
 * <p>
 * Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in this fashion.
 * <p>
 * Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs. You can select pairs in any order.
 * <p>
 * Example 1:
 * Input: [[1,2], [2,3], [3,4]]
 * Output: 2
 * Explanation: The longest chain is [1,2] -> [3,4]
 */
public class MaxLengthOfPairChain {
    public static void main(String[] args) {

        int[][] pair = {{1, 2}, {1, 2}, {2, 3}, {1, 2}, {3, 4}};
        System.out.println(findLongestChain(pair));

    }

    private static class Pair {
        private final int first;
        private final int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }


        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }
    }

    private static int findLongestChain(int[][] pairs) {

        List<Pair> arrayList = new ArrayList<>();
        for (int[] pair : pairs) {
            arrayList.add(new Pair(pair[0], pair[1]));
        }

        arrayList.sort(Comparator.comparingInt(Pair::getFirst));

        PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                return a.getFirst() - b.getFirst();
            }
        });

        for (Pair pair : arrayList) {
            if (queue.isEmpty())
                queue.add(pair);
            else {
                Pair temp = queue.peek();
                if (temp.getSecond() < pair.getFirst())
                    queue.add(pair);
            }
        }
        return queue.size();

    }
}
