package kennan.co.ke.DSImplementations.priorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueWithComparator {
    public static void main(String[] args) {
        int [] items = {46,15,80};
        orderItems(items);
    }


    private static void orderItems(int[] items) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new CharComparator().reversed());

        for (int c : items)
            priorityQueue.add(c);

        for (int c : priorityQueue)
            System.out.print(c + " ,");
        System.out.println();
        System.out.print(priorityQueue.peek());
    }

    private static class CharComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    }
}
