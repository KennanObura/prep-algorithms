package TECHIEDELIGHT.dynamicAndRecusion;

public class MaxNumberOfJumpsToReachDestination {
    public static void main(String[] args) {
        int[] jump = {1, 3, 6, 1, 0, 9};

        int[] jump1 = {4, 2, 2, 1, 0, 8, 1};

        System.out.println(maxNumberOfJumps(jump));
        System.out.println(maxNumberOfJumps(jump1));
    }

    private static int maxNumberOfJumps(int[] jump) {
        return maxNumberOfJumps(jump, 0);
    }

    private static int maxNumberOfJumps(int[] maxJumps, int index) {
        if (index == maxJumps.length - 1)
            return 0;

        if (maxJumps[0] == 0 || index > maxJumps.length - 1) return Integer.MAX_VALUE;

        int currentMax = Integer.MAX_VALUE;

        for (int jump = 1; jump <= maxJumps[index]; jump++) {
            int currentJump = maxNumberOfJumps(maxJumps, index + jump);

            if (currentJump != Integer.MAX_VALUE)
                currentMax = Math.min(currentMax, currentJump + 1);

        }

        return currentMax;
    }
}
