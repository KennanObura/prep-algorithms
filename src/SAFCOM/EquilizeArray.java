package SAFCOM;

public class EquilizeArray {

    public static void main(String[] args) {
        int[] num = {2, 1, 2, 4};
        int[] num2 = {3, 1, 4, 2};
        int[] num3 = {0, 2};
        int[] num4 = {3, 3, 3, 3, 5};
        System.out.println(minOperations(num));
        System.out.println(minOperations(num2));
        System.out.println(minOperations(num3));
        System.out.println(minOperations(num4));
    }

    static int minOperations(int arr[]) {

        int sum = 0;

        for (int i : arr)
            sum += i;

        int average = sum / arr.length;

        if (sum % 2 != 0) average++;

        int minOps = 0;
        for (int i : arr) {
            int op = average - i;
            if (op > 0)
                minOps += op;
        }

        return minOps;

    }
}
