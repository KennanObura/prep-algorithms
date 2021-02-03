package TUTORIALHORIZON.ARRAYS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * You have one meeting room at your company. There are N meeting needs to take place. Every meeting has a start time and end time along with the meeting title. Your task is to schedule as many meetings as possible in that conference room with no conflicts.
 * <p>
 * Example:
 * <p>
 * Meetings:
 * A[ Start Time: 1, End Time: 3]
 * B[ Start Time: 4, End Time: 5]
 * C[ Start Time: 0, End Time: 7]
 * D[ Start Time: 6, End Time: 8]
 * F[ Start Time: 9, End Time: 11]
 * G[ Start Time: 10, End Time: 12]
 * Output: A B D F
 */
public class MaximumMeetingInOneRoom {
    public static void main(String[] args) {
        ArrayList<Meeting> meetings = new ArrayList<>();
        meetings.add(new Meeting(1, 3, "A"));
        meetings.add(new Meeting(4, 5, "B"));
        meetings.add(new Meeting(0, 7, "C"));
        meetings.add(new Meeting(6, 8, "D"));
        meetings.add(new Meeting(9, 11, "F"));
        meetings.add(new Meeting(10, 12, "G"));

        findMaxMeetings(meetings);
    }

    private static void findMaxMeetings(ArrayList<Meeting> meetings) {

        meetings.sort(Comparator.comparing(Meeting::getStart));


        ArrayList<String> scheduled = new ArrayList<>();

        for (int i = 0; i < meetings.size(); i++) {
            if (i + 1 < meetings.size() && meetings.get(i).getEnd() > meetings.get(i + 1).getStart())
                continue;
            scheduled.add(meetings.get(i).title);
        }

        for (String i : scheduled)
            System.out.print(i + " ");
    }


    private static class Meeting {
        final int start;
        final int end;
        final String title;

        Meeting(int start, int end, String title) {
            this.start = start;
            this.end = end;
            this.title = title;
        }

        public int getEnd() {
            return end;
        }

        public int getStart() {
            return start;
        }
    }


}
