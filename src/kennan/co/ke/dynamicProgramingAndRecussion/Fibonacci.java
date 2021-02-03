package kennan.co.ke.dynamicProgramingAndRecussion;

public class Fibonacci {
    public static void main(String[] args) {
        int num = 6;
        int[] store = new int[num + 1];
        store[0] = 0;
        store[1] = 1;
        store[2] = 1;

        System.out.println(fibonacci(num, store));
    }

    private static int fibonacci(int num, int[] dict) {
        if (num > 2) {
//            if (dict[num] == 0)
                dict[num] = fibonacci(num - 1, dict) + fibonacci(num - 2, dict);
        }
        return dict[num];
    }
}
