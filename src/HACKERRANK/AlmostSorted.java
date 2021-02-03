package HACKERRANK;

public class AlmostSorted {
    public static void main(String[] args) {

    }

    static void almostSorted(int[] arr) {

        int start = 1;
        int end = 0;
        int n = arr.length;

        while (start < n && arr[start - 1] <= arr[start]) // scan for start index of ireg
            start++;

        if (start == n) {
            System.out.println("No");
            return;
        }

        end = start;
        start -= 1;


        while (end < n && arr[end - 1] >= arr[end]) // scan for 2nd index, if decreasing
            end++;

        if (end == n) {
            System.out.println("Reverse " + start + " " + end);
            return;
        }

        if (arr[end] >= arr[start]) {
            if (end - start == 2) {
                System.out.println("Swap " + start + " " + end);
                return;
            }
        }


        end -= 1;
        while (end < n && arr[end - 1] <= arr[end]) { //scan for 2nd index if increasing
            end++;
        }


//        if(end < arr.length && arr[start] > arr[end] && arr[start-1] <= arr[end]){
//            System.out.println("Swap " + start + " " + end);
//            return;
//        }else if(end == arr.length && arr[start] > arr[end-1] && arr[start-1] <= arr[end-1])





    }

}
