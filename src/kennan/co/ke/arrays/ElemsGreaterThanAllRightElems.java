package kennan.co.ke.arrays;

import java.util.Stack;

/**
 * Given unsorted array, print all elements that are greater than all elements to its right.
 * <p>
 * Solution 1: Naive o(n^2) , use two loops to check if the right elems are less
 * <p>
 * Solution II:
 * Use stack,
 * Loop the elements
 * compare the peek of stack with the current elem, if less, peek is less, pop, and push the elem
 * <p>
 * in the end stack will only contain greater elems
 */
public class ElemsGreaterThanAllRightElems {
    public static void main(String[] args) {

        int[] items = {1, 8, 6, 1, 2, 4, 3};
        naive(items);
        efficient(items);
        efficientWithNoSpace(items);
    }


    //Naive
    private static void naive(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) continue;
                if (j == array.length - 1)
                    System.out.print(array[i] + ",");

            }
        }
        System.out.println();
    }

    /*
     * With extra space
     *
     */
    private static void efficient(int[] array) {
        Stack<Integer> stack = new Stack<>();

        for (int i : array) {
            while (!stack.isEmpty() && stack.peek() < i)
                stack.pop();
            stack.push(i);
        }

        while (!stack.isEmpty())
            System.out.print(stack.pop() + ", ");

        System.out.println();
    }

    /*
    We will use property that rightmost element is always a leader.

    We will start from rightmost element and track max.
    Whenever we get new max, that element is a leader.
     */
    private static void efficientWithNoSpace(int[] array){

        int leader = array[array.length-1]; //to track max elem

        System.out.println(leader);
        for (int i = array.length-1; i >= 0; i--) {
            if(array[i] > leader){
                leader = array[i];
                System.out.print(leader + ",");
            }
        }

        System.out.println();

    }
}
