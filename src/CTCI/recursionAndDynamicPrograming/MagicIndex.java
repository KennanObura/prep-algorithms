package CTCI.recursionAndDynamicPrograming;

/**
 * Objective: Given a sorted array of distinct integers, Find the Magic index or Fixed point in the array.
 * <p>
 * Magic Index or Fixed Point: Magic index or a Fixed point in an array is an index i in the array such that A[i] = i.
 * <p>
 * Example :
 * <p>
 * int[] A = { -1, 0, 1, 2, 4, 10 };
 * <p>
 * Magic index or fixed point is : 4
 * <p>
 * SOLUTION
 * NAIVE
 * scan from 0 ...N to find A[i] == i element
 * Complexity O(N)
 * <p>
 * <p>
 * BINARY SEARCH SOLUTION
 * Since items are sorted,
 * Find mid of the array, mid
 * CASE 1: mid == A[mid], return mid
 * CASE 2: mid > A[mid] recur to the right, since A[mid+1] must increase with at least 1
 * CASE 3: mid <[mid] recur to left
 */
public class MagicIndex {
    public static void main(String[] args) {
        int [] nums = {-1, 0, 1, 2, 4, 10};
        System.out.println(magicIndex(nums));

    }

    private static int magicIndex(int[] nums) {
        return magicIndex(nums, 0, nums.length - 1);
    }

    private static int magicIndex(int[] nums, int start, int end) {
        if (start > end) return -1;
        int mid = start + (end - start) / 2;
        if(mid == nums[mid]) return mid;

        if(mid > nums[mid]) return magicIndex(nums, mid+1, end);
        else return magicIndex(nums, start, mid-1);
    }
}
