package kennan.co.ke.arrays;

public class LocalMinima {
    public static void main(String[] args) {
        int[] arr = {10, 5, 3, 6, 13, 16, 7};
        System.out.println(minima(arr));
    }

    private static int minima(int[] arr) {
        return minima(arr, 0, arr.length - 1);
    }

    private static int minima(int[] arr, int start, int end) {
        int mid = start + (end - start) / 2;

        if ((mid == 0 || arr[mid - 1] > arr[mid]) && (mid == arr.length - 1 || arr[mid + 1] > arr[mid]))
            return arr[mid];


        else if (arr[mid] > arr[mid - 1]) return minima(arr, start, mid);
        else
            return minima(arr, mid + 1, end);

    }
}
