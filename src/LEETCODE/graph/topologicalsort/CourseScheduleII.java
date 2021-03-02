package LEETCODE.graph.topologicalsort;

import java.util.*;

/**
 * 210. Course Schedule II
 * Medium
 * <p>
 * There are a total of n courses you have to take labelled from 0 to n - 1.
 * <p>
 * Some courses may have prerequisites, for example, if prerequisites[i] = [ai, bi] this means you must take the course bi before the course ai.
 * <p>
 * Given the total number of courses numCourses and a list of the prerequisite pairs, return the ordering of courses you should take to finish all courses.
 * <p>
 * If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
 * Example 2:
 * <p>
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 * Example 3:
 * <p>
 * Input: numCourses = 1, prerequisites = []
 * Output: [0]
 */

public class CourseScheduleII {
    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[][] prerequisites2 = {{1, 0}};

        System.out.println(Arrays.toString(findOrder(4, prerequisites)));
        System.out.println(Arrays.toString(findOrder(2, prerequisites2)));

    }


    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        /*
        - Create graph

         */

        List<List<Integer>> courses = new ArrayList<>();

        for (int i = 0; i < numCourses; i++)
            courses.add(new ArrayList<>());

        for (int[] prereq : prerequisites)
            courses.get(prereq[0]).add(prereq[1]);

        boolean[] visited = new boolean[numCourses];
        ArrayList<Integer> stack = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                findOrder(courses, i, visited, stack);
            }
        }

        /*
        pop off from stack
         */

        int[] result = new int[numCourses];
        int i = 0;

        for (int item: stack)
            result[i++] = item;

        return result;
    }

    private static void findOrder(List<List<Integer>> courses, int course, boolean[] visited, ArrayList<Integer> stack) {
        visited[course] = true;

        List<Integer> prereqs = courses.get(course);
        for (int prereq : prereqs) {
            if (!visited[prereq])
                findOrder(courses, course, visited, stack);
        }
        stack.add(course);
    }
}
