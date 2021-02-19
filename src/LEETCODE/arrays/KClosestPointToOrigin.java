package LEETCODE.arrays;

import java.util.*;

/**
 * 973. K Closest Points to Origin
 * Medium
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 * <p>
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 * <p>
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 * Example 2:
 * <p>
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 */
public class KClosestPointToOrigin {
    public static void main(String[] args) {

        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
        int[][] points2 = {{-5, 4}, {-6, -5}, {4, 6}};

        int[][] res = kClosest(points2, 2);

        for (int[] row : res)
            System.out.println(Arrays.toString(row));
    }

    private static int[][] kClosest(int[][] points, int K) {
        /*
        1.
        2. Create priority queue of size k
            maintain size while inserting
        3. empty priority queue to result array


         */

        Queue<int[]> pq = new PriorityQueue<>(
                (a, b) -> getEuclideanDistance(b) - getEuclideanDistance(a)
        );

        for (int[] point : points) {
            pq.add(point);
            if (pq.size() > K)
                pq.poll();
        }

        int[][] res = new int[K][2];

        int i = 0;
        for (int[] point : pq)
            res[i++] = point;
        return res;
    }

    private static Integer getEuclideanDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
