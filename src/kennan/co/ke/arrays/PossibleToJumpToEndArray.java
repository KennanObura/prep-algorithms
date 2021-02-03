package kennan.co.ke.arrays;

public class PossibleToJumpToEndArray {
    public static void main(String[] args) {
        int[] nums = {1, 5, 2, 1, 0, 2, 0};
        System.out.println(solve(nums, 0, nums.length) + " so");
    }

    private static boolean solve(int[] array, int i, int length) {
        if (i == length) return true;
        if (array[i] == 0) return false;

        boolean possible = false;
        for (int j = 1; j <= array[i]; j++)
            if (i+j <= length)
                possible = possible || solve(array, i+j, length);
        return possible;
    }
}
