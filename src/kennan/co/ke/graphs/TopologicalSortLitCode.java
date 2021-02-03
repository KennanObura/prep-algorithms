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
public class TopologicalSortLitCode {

    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int numCourses = 4;
        CourseGraph courseGraph = new CourseGraph(numCourses, prerequisites);
        Map<Integer, Course> courseMap = courseGraph.getCourseMap();

        Stack<Course> courseStack = topologicalSort(courseMap.get(0), new Stack<>());

        System.out.println(courseStack.size());
        while (!courseStack.isEmpty())
            System.out.println(courseStack.pop().value);
    }

    private static Stack<Course> topologicalSort(Course course, Stack<Course> courseStack) {
        if (course == null) return courseStack;
        course.taken = true;

        for (Course item : course.getPrerequisites())
            if (item != null && !item.taken) {
                System.out.println(course.taken);
                topologicalSort(item, courseStack);
            }

        courseStack.push(course);
        return courseStack;
    }
}

class CourseGraph {
    final int numCourses;
    final int[][] prerequisites;
    final Map<Integer, Course> courseMap;

    CourseGraph(int numCourses, int[][] prerequisites) {
        this.courseMap = new HashMap<>();
        this.numCourses = numCourses;
        this.prerequisites = prerequisites;
        this.create();
    }

    private void create() {
        for (int[] pairs : prerequisites) {
            Course prereqCourse = new Course(pairs[1]), course = new Course(pairs[0]);

            if (!courseMap.containsKey(pairs[0])) {
                courseMap.put(pairs[0], course);
            }
            if (!courseMap.containsKey(pairs[1])) {
                courseMap.put(pairs[1], prereqCourse);
            }
            createOrAddEdge(course, prereqCourse);
        }
    }

    private void createOrAddEdge(Course course, Course prereq) {
        courseMap.get(prereq.value).addPrerequisite(course);
    }

    public Map<Integer, Course> getCourseMap() {
        return this.courseMap;
    }
}

class Course {
    final int value;
    boolean taken;
    final LinkedList<Course> prerequisites;

    Course(int value) {
        this.value = value;
        this.prerequisites = new LinkedList<>();
    }

    void addPrerequisite(Course prerequisite) {
        prerequisites.addFirst(prerequisite);
    }

    public LinkedList<Course> getPrerequisites() {
        return this.prerequisites;
    }

}