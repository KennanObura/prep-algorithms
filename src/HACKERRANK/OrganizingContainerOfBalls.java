package HACKERRANK;

import java.util.Arrays;

/**
 * David has several containers, each with a number of balls in it. He has just enough containers to sort each
 * type of ball he has into its own container.
 * David wants to sort the balls using his sort method.
 */
public class OrganizingContainerOfBalls {
    public static void main(String[] args) {
        int[][] container = {
                {0, 2, 1},
                {1, 1, 1},
                {2, 0, 0}
        };


        int[][] container2 = {
                {1, 3, 1},
                {2, 1, 2},
                {3, 3, 3}
        };

        System.out.println(organizingContainers(container));
        System.out.println(organizingContainers(container2));

    }

    private static String organizingContainers(int[][] container) {

        int[] containerCapacity = new int[container.length];
        int[] totalBallType = new int[container[0].length];

        for (int i = 0; i < container.length; i++)
            for (int j = 0; j < container[0].length; j++) {
                containerCapacity[i] += container[i][j];
                totalBallType[i] += container[j][i];
            }


        Arrays.sort(containerCapacity);
        Arrays.sort(totalBallType);

        System.out.println(Arrays.toString(containerCapacity));
        System.out.println(Arrays.toString(totalBallType));


        for (int i = 0; i < containerCapacity.length; i++)
            if (containerCapacity[i] != totalBallType[i])
                return "Impossible";


        return "Possible";


    }

}
