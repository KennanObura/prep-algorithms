package LEETCODE.graph.topologicalsort;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 207. Course Schedule
 * Medium
 * <p>
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 * <p>
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 * <p>
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 */
public class CourseSchedule {
    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}, {0, 1}};
        int[][] prerequisites2 = {{1, 0}};
        System.out.println(canFinish(2, prerequisites));
        System.out.println(canFinish(2, prerequisites2));

    }


    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> courses = new ArrayList<>(numCourses);

        for (int i = 0; i < numCourses; i++)
            courses.add(new ArrayList<>());

        for (int[] preq : prerequisites)
            courses.get(preq[0]).add(preq[1]);

        int[] visited = new int[numCourses]; // 0 -> not taken, 1 -> taken, -> 2 finished

        for (int i = 0; i < numCourses; i++) {
            if (!canFinish(courses, i, visited))
                return false;

        }

        return true;

    }

    private static boolean canFinish(ArrayList<ArrayList<Integer>> courses, int i, int[] visited) {

        visited[i] = 1;

        ArrayList<Integer> prereqs = courses.get(i);
        for (int prereq : prereqs) {
            if (visited[prereq] == 1) return false;


            if (visited[prereq] == 0 && !canFinish(courses, prereq, visited))
                return false;

        }
        visited[i] = 2;
        return true;
    }
}
