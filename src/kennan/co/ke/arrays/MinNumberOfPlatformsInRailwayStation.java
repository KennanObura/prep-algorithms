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
public class MinNumberOfPlatformsInRailwayStation {
    public static void main(String[] args) {

        int[] arr = {100, 140, 150, 200, 215, 400};
        int[] dep = {110, 300, 210, 230, 315, 600};

        System.out.println(platforms(arr, dep));
    }


    private static int platforms(int[] arrival, int[] departure) {
        int minPlatforms = 0;
        int count = 0;

        Arrays.sort(arrival);
        Arrays.sort(departure);

        int i = 0;
        int j = 0;

        while (i < arrival.length && j < departure.length) {
            if (arrival[i] <= departure[j]) {
                minPlatforms = Math.max(minPlatforms, ++count);
                i++;
            } else {
                count--;
                j++;
            }
        }
        return minPlatforms;
    }
}
