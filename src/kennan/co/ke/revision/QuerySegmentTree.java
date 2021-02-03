package kennan.co.ke.revision;

/**
 * Consider an Array of Integers,
 * int[] arr = {a1, a2, a3, a4, a5,….., an};
 * <p>
 * Given two types of queries,
 * (i) In the first type of query, given two integers, L & R, Output the sum of the elements in the
 * given range.
 * (ii) In the second type of query, given an Index and a value, update the value in array at the
 * given index to the given value.
 */
public class QuerySegmentTree {
    static int[] numbers = {3, -2, 4, 2, 6, -1, 8};
    static int[] sums;

    public static void main(String[] args) {

        int height = (int) Math.ceil(Math.log(numbers.length) / Math.log(2));
        int sumsSize = 2 * (int) Math.pow(2, height) - 1;

        sums = new int[sumsSize];

        buildSegmentSumTree(0, numbers.length - 1, 0);
        int sum = querySum(0, numbers.length-1, 1, 2, 0);
        System.out.println(sum);

        runUpdate(6, 2, 0, numbers.length-1, 0);

        sum = querySum(0, numbers.length-1, 1, 4, 0);
        System.out.println(sum);
    }

    private static void runUpdate(int value, int updateIndex, int start, int end, int sumIndex) {
        if (updateIndex < start || updateIndex > end) return;
        if (updateIndex == start && updateIndex == end) {
            numbers[start] = value;
            sums[start] = value;
            return;
        }

        int mid = getMidIndex(start, end);
        int leftIndex = getLeftIndex(sumIndex);
        int rightIndex = getRightIndex(sumIndex);

        runUpdate(value, updateIndex, start, mid, leftIndex);
        runUpdate(value, updateIndex, mid + 1, end, rightIndex);
        sums[sumIndex] = sums[leftIndex] + sums[rightIndex];
    }

    private static int querySum(int start, int end, int qStart, int qEnd, int sumIndex) {

        if (qEnd < start || end < qStart) // range fall outside
            return 0;

        if (qStart <= start && end <= qEnd) //if range is completely same
            return sums[sumIndex];


        int mid = getMidIndex(start, end);
        int leftIndex = getLeftIndex(sumIndex);
        int rightIndex = getRightIndex(sumIndex);

        int leftSum = querySum(start, mid, qStart, qEnd, leftIndex);
        int rightSum = querySum(mid + 1, end, qStart, qEnd, rightIndex);

        return leftSum + rightSum;

    }

    private static int buildSegmentSumTree(int start, int end, int sumsIndex) {
        if (start >= end) {
            sums[sumsIndex] = numbers[start];
            return sums[sumsIndex];
        }

        int mid = getMidIndex(start, end);

        int leftIndex = getLeftIndex(sumsIndex);
        int rightIndex = getRightIndex(sumsIndex);

        int leftSum = buildSegmentSumTree(start, mid, leftIndex);
        int rightSum = buildSegmentSumTree(mid + 1, end, rightIndex);

        sums[sumsIndex] = leftSum + rightSum;

        return sums[sumsIndex];
    }

    private static int getRightIndex(int sumsIndex) {
        return 2 * sumsIndex + 2;
    }

    private static int getLeftIndex(int sumsIndex) {
        return 2 * sumsIndex + 1;
    }

    private static int getMidIndex(int start, int end) {
        return start + (end - start) / 2;
    }
}
