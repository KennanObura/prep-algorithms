package TUTORIALHORIZON.ARRAYS;

/*
The number of cycles in a given array of integers.
August 24, 2020 by Sumit Jain
Objective: Given an array of size N which contains integers from range 0 to N-1. (No duplicates).
 Write a program to find the number of cycles in the array.

Example:

Given Array : [3, 2, 1, 0]
Number of cycles: 2

Given Array : [2, 0, 1]
Number of cycles: 1

Given Array : [1, 3, 4, 0, 2, 6, 5]
Number of cycles: 3
 */

public class TheNumberOfCyclesInArrayOfIntegers {
    public static void main(String[] args) {

        System.out.println(numberOfCycles(new int[]{1, 3, 4, 0, 2, 6, 5}));

        System.out.println(numberOfCycles(new int[]{2, 0, 1}));
        System.out.println(numberOfCycles(new int[]{3, 2, 1, 0}));
    }

    private static int numberOfCycles(int[] nums) {
        /*
        Visualize as graph
        for positions 0 .. N, assumes are nodes, and elems are the adjacency nodes
        example {3,2,1,0}
        0 ->  3
        1 ->  2
        2 ->  1
        3 ->  0

        let visited be array to determine if node is visited

        from i = 0 ...N
            do dfs to nodes
            (mark position and elem as visited)

            if position is already marked visited
                count ++

         */

        int N = nums.length;

        boolean[] visited = new boolean[N];

        int count = 0;

        for (int i = 0; i < N; i++) {
            if (visited[i] && visited[nums[i]]) count++;

            visited[i] = true;
            visited[nums[i]] = true;

        }

        return count;

    }
}
