package LEETCODE.arrays;

public class DecreaseElementsToMakeArrayZigzag {
    public static void main(String[] args) {

        System.out.println(movesToMakeZigzag(new int[]{1, 2, 3, 3}));
        System.out.println(movesToMakeZigzag(new int[]{9, 6, 1, 6, 2}));
    }

    public static int movesToMakeZigzag(int[] nums) {
        int N = nums.length;
        /*
        - We can try leave odds fixed on how they appear, and decrement even if needed
        - Also leave even as they are and decrement odd if needed
        - compare the cost

        From i =1 ... N
            compare neighbours
                if condition not met
                    item - math.min(i+1,i-1) +1
            i =i+2;

        From i =0 ... N
            compare neighbours
                if condition not met
                    item - math.min(i+1,i-1) +1
            i =i+2;

         */

        int i = 1;
        int cost = 0;

        while (i < N - 1) {
            int temp = Math.min(nums[i - 1], nums[i + 1]);
            if (temp < nums[i])
                cost += nums[i] - temp + 1;

            i += 2;
        }


        if (i == N-1 && nums[N - 2] <= nums[N - 1])
            cost += nums[N - 1] - nums[N - 2] + 1;

        int costB = 0;
        i = 2;

        if (nums[0] > nums[1])
            costB += nums[0] - nums[1] + 1;

        while (i < N - 1) {
            int temp = Math.min(nums[i - 1], nums[i + 1]);
            if (temp < nums[i])
                costB += nums[i] - temp + 1;
            i += 2;
        }
        if (cost == 0) return costB;
        else if (costB == 0) return cost;
        else
            return Math.min(cost, costB);
    }
}
