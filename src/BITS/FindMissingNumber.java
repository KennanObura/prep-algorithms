package BITS;

public class FindMissingNumber {
    public static void main(String[] args) {

        System.out.println(findMissingNumber(new int[]{1,2,3,5}));

        System.out.println(findMissingNumber(new int[]{9,6,4,2,3,5,7,0,1}));

        System.out.println(findMissingNumber(new int[]{3,0,1}));

        System.out.println(findMissingNumber(new int[]{9,6,4,2,3,5,7,0,1}));

        System.out.println(findMissingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }


    private static int findMissingNumber(int[] nums) {
        int N = nums.length;
        int A = 1;
        int B = nums[0];

        for (int i = 1; i < N; i++)
            B ^= nums[i];

        for (int i = 2; i <= N + 1; i++)
            A ^= i;

        return A ^ B;
    }
}
