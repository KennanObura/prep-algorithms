package LEETCODE.arrays;

import java.util.*;

/**
 * 554. Brick Wall
 * Medium
 * There is a brick wall in front of you. The wall is rectangular and has several rows of bricks. The bricks have the same height but different width. You want to draw a vertical line from the top to the bottom and cross the least bricks.
 * <p>
 * The brick wall is represented by a list of rows. Each row is a list of integers representing the width of each brick in this row from left to right.
 * <p>
 * If your line go through the edge of a brick, then the brick is not considered as crossed. You need to find out how to draw the line to cross the least bricks and return the number of crossed bricks.
 * <p>
 * You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input: [[1,2,2,1],
 * [3,1,2],
 * [1,3,2],
 * [2,4],
 * [3,1,2],
 * [1,3,1,1]]
 * <p>
 * Output: 2
 */
public class BrickWall {

    public static void main(String[] args) {

        List<List<Integer>> wall = new ArrayList<>();
        wall.add(Arrays.asList(1, 2, 2, 1));
        wall.add(Arrays.asList(3, 1, 2));
        wall.add(Arrays.asList(1, 3, 2));
        wall.add(Arrays.asList(2, 4));
        wall.add(Arrays.asList(3, 1, 2));
        wall.add(Arrays.asList(1, 3, 1, 1));

        System.out.println(leastBricks(wall));
    }


    public static int leastBricks(List<List<Integer>> wall) {

        List<List<Integer>> summedWall = new ArrayList<>(wall.size());

        for (List<Integer> row : wall) {
            List<Integer> prefix = new ArrayList<>();
            prefix.add(row.get(0));
            for (int i = 1; i < row.size(); i++) {
                prefix.add(prefix.get(i - 1) + row.get(i));
            }

            summedWall.add(new ArrayList<>(prefix));
        }

        System.out.println(summedWall);

        Map<Integer, Integer> map = new HashMap<>();

        for (List<Integer> row : summedWall)
            for (Integer integer : row)
                map.put(integer, map.getOrDefault(integer, 0) + 1);


        int max = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == wall.size()) continue;
            max = Math.max(max, entry.getValue());
        }

        return wall.size() - max;

    }
}
