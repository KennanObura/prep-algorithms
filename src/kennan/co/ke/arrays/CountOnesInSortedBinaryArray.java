package kennan.co.ke.arrays;

public class CountOnesInSortedBinaryArray {
    public static void main(String[] args) {
        int[] array = {0, 0, 0, 0, 0, 1};
        System.out.println(efficientSolution(array, 0, array.length-1));
    }

    private static int solve(int[] array) {
        if (array[0] == 1) return array.length;
        else if (array[array.length - 1] == 0) return 0;
        else {
            int end = array.length - 1;

            while (end > 0) {
                if (array[end] == 0) break;
                end--;
            }

            return array.length - end -1;
        }
    }


    private static int efficientSolution(int [] array, int start, int end){
        if(array[start] == 1) return end-start+1;
        if(array[end] == 0) return 0;

        int mid = getMidIndex(start, end);
        return efficientSolution(array, start, mid) + efficientSolution(array, mid+1, end);
    }

    private static int getMidIndex(int start, int end) {
        return start + (end-start)/2;
    }
}
