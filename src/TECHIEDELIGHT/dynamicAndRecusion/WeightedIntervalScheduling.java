package TECHIEDELIGHT.dynamicAndRecusion;

import java.util.*;

/**
 * Given N jobs where every job is represented by following three elements of it.
 *
 * Start Time
 * Finish Time
 * Profit or Value Associated (>= 0)
 * Find the maximum profit subset of jobs such that no two jobs in the subset overlap.
 *
 * Example:
 *
 * Input: Number of Jobs n = 4
 *        Job Details {Start Time, Finish Time, Profit}
 *        Job 1:  {1, 2, 50}
 *        Job 2:  {3, 5, 20}
 *        Job 3:  {6, 19, 100}
 *        Job 4:  {2, 100, 200}
 * Output: The maximum profit is 250.
 * We can get the maximum profit by scheduling jobs 1 and 4.
 * Note that there is longer schedules possible Jobs 1, 2 and 3
 * but the profit with this schedule is 20+50+100 which is less than 250
 */
public class WeightedIntervalScheduling {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job(0, 6, 60),
                new Job(5, 9, 50),
//                new Job(1, 4, 30),
//                new Job(5, 7, 30),
//                new Job(3, 5, 10),
                new Job(7, 8, 10)
        );

        jobs.sort(Comparator.comparingInt(j -> j.start));

        System.out.println(intervalScheduling(jobs, null, 0));

    }

    private static int intervalScheduling(List<Job> jobs, Job prev, int index) {
        if (index > jobs.size()-1) return 0;

        Job currentJob = jobs.get(index);

        if (prev != null && currentJob.start < prev.finish) {
            return intervalScheduling(jobs, prev, index + 1);
        }

        int scheduleJob = intervalScheduling(jobs, currentJob, index + 1) + currentJob.profit;
        int unScheduleJob = intervalScheduling(jobs, prev, index + 1);

        return Math.max(scheduleJob, unScheduleJob);

    }


    private static class Job {
        int start, finish, profit;

        Job(int start, int finish, int profit) {
            this.start = start;
            this.finish = finish;
            this.profit = profit;
        }

        @Override
        public String toString() {
            return "Job{" +
                    "s=" + start +
                    ", f=" + finish +
                    ", p=" + profit +
                    '}';
        }
    }


}
