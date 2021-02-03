package kennan.co.ke.arrays;

import java.util.Arrays;

/**
 * Sort both arrival(arr) and departure(dep) arrays.
 * Compare current element in arrival and departure array and pick smaller one among both.
 * If element is pick up from arrival array then increment platform_needed.
 * If element is pick up from departure array then decrement platform_needed.
 * While performing above steps, we need track count of maximum value reached for platform_needed.
 * In the end, we will return maximum value reached for platform_needed.
 */
public class MinNumberOfPlatformsInRailwayStationII {
    public static void main(String[] args) {

        int[] arr = {100, 140, 150, 200, 215, 400};
        int[] dep = {110, 300, 210, 230, 315, 600};

        Arrays.sort(arr);
        Arrays.sort(dep);
        System.out.println(platforms(arr, dep));
    }


    private static int platforms(int[] arrival, int[] departure) {


        int i = 0;
        int j = 0;
        int count = 0;
        int minimumPlatforms = Integer.MIN_VALUE;
        while (i < arrival.length && j < departure.length) {
            if (arrival[i] < departure[j]) {
                count++;
                i++;
            } else {
                count--;
                j++;
            }
            minimumPlatforms = Math.max(count, minimumPlatforms);
        }
        return minimumPlatforms;
    }
}
