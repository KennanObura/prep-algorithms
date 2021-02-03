package kennan.co.ke.graphs;

import java.util.*;

/**
 * There are a total of n courses you have to take labelled from 0 to n - 1.
 * <p>
 * Some courses may have prerequisites, for example, if prerequisites[i] = [ai, bi]
 * this means you must take the course bi before the course ai.
 * <p>
 * Given the total number of courses numCourses and a list of the prerequisite pairs,
 * return the ordering of courses you should take to finish all courses.
 * <p>
 * If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 * <p>
 * Example 2:
 * <p>
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 */
public class TopologicalSortNoDS {

    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int numCourses = 4;

        LinkedList<Integer> courseOrder = courseOrder(numCourses, prerequisites);
        for (Integer integer : courseOrder) System.out.println(integer);

    }

    private static Map<Integer, LinkedList<Integer>> courseMap;
    private static LinkedList<Integer> result;

    private static LinkedList<Integer> courseOrder(int numCourses, int[][] prerequisites) {
        courseMap = new HashMap<>();

        for (int[] items : prerequisites) {
            if (!courseMap.containsKey(items[0]))
                courseMap.put(items[0], new LinkedList<>());
            if (!courseMap.containsKey(items[1]))
                courseMap.put(items[1], new LinkedList<>());
        }

        for (int[] items : prerequisites) {
            courseMap.get(items[1]).addFirst(items[0]);
        }
        boolean[] taken = new boolean[numCourses];

        result = new LinkedList<>();
        generateCourseOrder(0, taken);
        return result;

    }

    private static void generateCourseOrder(int i, boolean[] taken) {
        for (int item : courseMap.get(i)) {
            if (!taken[item]) {
                taken[item] = true;
                generateCourseOrder(item, taken);
            }
        }
        result.addFirst(i);
    }
}

