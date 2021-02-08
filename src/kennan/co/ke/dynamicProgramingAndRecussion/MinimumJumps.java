package kennan.co.ke.dynamicProgramingAndRecussion;

public class MinimumJumps {
    public static void main(String[] args) {
        int[] A = { 2, 3, 1, 1, 4 };
        System.out.println(minJumps(A));

    }

    private static int minJumps(int[] nums) {
        return minJumps(nums, 0, 0);
    }

    private static int minJumps(int[] nums, int index, int count) {
        int N = nums.length;
        if (index >= N || nums[index] == 0) return -1;

        if (index == N - 1) return count;

        int ways = Integer.MAX_VALUE;
        for (int i = 1; i <= nums[index]; i++) {
            int currentWays = minJumps(nums, index + i, count + 1);
            if (currentWays != -1)
                ways = Math.min(ways, currentWays);
        }
        return ways;
    }
}
