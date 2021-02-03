package HACKERRANK;

import java.util.Arrays;

public class FlatSpaceStations {
    public static void main(String[] args) {

        int[] c = {0, 1, 2, 4, 3, 5};
        int n = 6;

        System.out.println(flatlandSpaceStations(n, c));

    }

    static int flatlandSpaceStations(int n, int[] c) {

        Arrays.sort(c);
        //find the max distance between the edges
        int maxDistance = Math.max((c[0]), ((n - 1) - c[c.length - 1]));

        for (int i = 1; i < c.length; i++) {
            int distanceBetween = Math.abs(c[i] - c[i - 1]) < 2 ? 0 : Math.abs(c[i] - c[i - 1]) / 2;
            maxDistance = Math.max(distanceBetween, maxDistance);
        }

        return maxDistance;
    }
}
