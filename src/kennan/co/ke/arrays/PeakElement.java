package kennan.co.ke.arrays;

public class PeakElement {
    public static void main(String[] args) {
        int[] arr = { 10, 20, 40, 15 };
        int[] arr1 = { 40, 15 };
        int[] arr2 = { 20, 40 };
        int[] arr3 = { 10, 20, 40, 15 };
        solve(arr2);
    }

    private static void solve(int[] array) {
        System.out.println(solve(array, 0, array.length));
    }

    private static int solve(int[] array, int start, int end) {
        int mid = getMidOfArray(start, end);
        if (mid == 0 && array[mid] >= array[mid + 1]) return mid;
        else if (mid == array.length - 1 && array[mid] >= array[mid - 1]) return mid;
        else if (mid > 0 && mid < array.length - 1 && array[mid] >= array[mid - 1] && array[mid] >= array[mid + 1])
            return mid;
        else {
            if (array[mid] < array[mid - 1]) return solve(array, start, mid - 1);
            else return solve(array, mid + 1, end);
        }
    }

    private static int getMidOfArray(int start, int end) {
        return start + (end - start) / 2;
    }
}
