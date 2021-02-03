package kennan.co.ke.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * There are a total of n tasks you have to pick, labeled from 0 to n-1. Some tasks may have prerequisites tasks,
 * for example to pick task 0 you have to first finish tasks 1, which is expressed as a pair: [0, 1]
 * <p>
 * Given the total number of tasks and a list of prerequisite pairs, return the ordering of
 * tasks you should pick to finish all tasks.
 * <p>
 * There may be multiple correct orders, you just need to return one of them.
 * If it is impossible to finish all tasks, return an empty array.
 * <p>
 * Input: 4, [[1, 0], [2, 0], [3, 1], [3, 2]]
 * Output: [0, 1, 2, 3] or [0, 2, 1, 3]
 * Explanation: There are a total of 4 tasks to pick. To pick task 3 you should have finished both tasks 1 and 2.
 * Both tasks 1 and 2 should be pick after you finished task 0.
 * So one correct task order is [0, 1, 2, 3]. Another correct ordering is [0, 2, 1, 3].
 */
public class TasksAndPrerequisites {
    public static void main(String[] args) {
        int n = 4;
        int[][] tasks = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};

        LinkedList<Integer> ordering = orderTasks(n, tasks);

        System.out.println(ordering);
    }

    static LinkedList<Integer> ordering = new LinkedList<>();
    static boolean[] taken;

    private static LinkedList<Integer> orderTasks(int n, int[][] tasks) {
        List<LinkedList<Integer>> taskGraph = new ArrayList<>();
        taken = new boolean[n];

        for (int i = 0; i < n; i++)
            taskGraph.add(new LinkedList<>());

        for (int[] task : tasks)
            taskGraph.get(task[1]).addFirst(task[0]);

        int withZeroDeg = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
            if (taskGraph.get(i).isEmpty())
                withZeroDeg = i;


        if (withZeroDeg == Integer.MIN_VALUE)  //sort not possible, there's a cycle:: No node with outgoing edges(deg zero)
            return ordering;
//        System.out.println(withZeroDeg);
//

        return tasksInOrder(0, taskGraph);
    }

    private static LinkedList<Integer> tasksInOrder(int node, List<LinkedList<Integer>> taskGraph) {
        for (int item : taskGraph.get(node))
            if (!taken[item]) {
                taken[item] = true;
                tasksInOrder(item, taskGraph);
            }
        ordering.addFirst(node);
        return ordering;
    }
}
