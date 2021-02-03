package TECHIEDELIGHT.dynamicAndRecusion;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a set of activities with starting & end time of each activity, find the max number of activities that can be performed
 */

public class ActivitySelection {
    public static void main(String[] args) {

        Activity[] activities = new Activity[]{
                new Activity(1, 4),
                new Activity(3, 5),
                new Activity(0, 6),
                new Activity(5, 7),
                new Activity(3, 8),
                new Activity(5, 9),
                new Activity(6, 10),
                new Activity(8, 11),
                new Activity(8, 12),
                new Activity(2, 13),
                new Activity(12, 14),
        };

        System.out.println(maximumNumberOfActivities(activities));

    }

    private static class Activity {
        int start;
        int end;

        Activity(int start, int end) {
            this.end = end;
            this.start = start;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }

    private static int maximumNumberOfActivities(Activity[] activities) {
        Arrays.sort(activities, Comparator.comparingInt(Activity::getStart));

        return maximumNumberOfActivities(activities, 0, null);
    }

    private static int maximumNumberOfActivities(Activity[] activities, int n, Activity prev) {
        if (n > activities.length - 1) return 0;



        Activity current = activities[n];



        if (prev != null && prev.end > current.start) {
           return maximumNumberOfActivities(activities, n + 1, prev);
        }


        int scheduled = maximumNumberOfActivities(activities, n + 1, current) + 1;
        int unScheduled = maximumNumberOfActivities(activities, n + 1, prev);
        
        return Math.max(scheduled, unScheduled);

    }
}
