package LEETCODE.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 539. Minimum Time Difference
 * Medium
 * Given a list of 24-hour clock time points in "HH:MM" format, return the minimum minutes difference between any two time-points in the list.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: timePoints = ["23:59","00:00"]
 * Output: 1
 * <p>
 * Example 2:
 * <p>
 * Input: timePoints = ["00:00","23:59","00:00"]
 * Output: 0
 */
public class MinimumTimeDifference {
    public static void main(String[] args) {

        List<String> list1 = new ArrayList<>(Arrays.asList("00:00", "23:59", "00:00"));
        List<String> list2 = new ArrayList<>(Arrays.asList("23:59", "00:00"));

        System.out.println(findMinDifference(list1));
        System.out.println(findMinDifference(list2));
    }

    public static int findMinDifference(List<String> timePoints) {

        List<Integer> minutes = new ArrayList<>();
        for (String time : timePoints) {
            int inMinute = toMinutes(time);

            minutes.add(inMinute);
        }

//        System.out.println(minutes);
        Collections.sort(minutes);

        int prev = minutes.get(0), minimum = Integer.MAX_VALUE;

        for (int i = 1; i < minutes.size(); i++) {
            minimum = Math.min(minimum, minutes.get(i) - prev);
            prev = minutes.get(i);

        }
//        NOTES
        //The difference btw the first and the last time has to be specially handles. Consider test case 1.
        //In 24 hrs we have 1440 mins hence 1440 has been used (24*60)
       // i Math.abs(24 * 60 - minutes.get(minutes.size() - 1) - minutes.get(0)));
        return Math.min(minimum, 24 * 60 - minutes.get(minutes.size() - 1) + minutes.get(0));
    }

    private static int toMinutes(String time) {
        String[] token = time.split(":");
        int hr = Integer.parseInt(token[0]);
        int mins = Integer.parseInt(token[1]);
        return (hr * 60) + mins;
    }
}
