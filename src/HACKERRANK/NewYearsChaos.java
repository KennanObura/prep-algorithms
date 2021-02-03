package HACKERRANK;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NewYearsChaos {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 1, 3, 2, 4, 5, 6};
        int[] arr2 = {2, 5, 1, 3, 4};
        int[] arr3 = {3, 2, 1};
        minimumBribes(arr);
    }

    static void minimumBribes(int[] q) {

        Map<Integer, Integer> map = new ConcurrentHashMap<>();

        for (int i = 0; i < q.length; i++)
            map.put(q[i], i + 1);


//        for (Map.Entry<Integer, Integer> entry : map.entrySet())
//            if (Math.abs(entry.getKey() - entry.getValue()) > 2) {
//                System.out.println("chaotic");
//                return;
//            }

        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            int value = entry.getKey();
            int position = entry.getValue();

            int pairValue = map.get(value);
            int pairPosition = map.get(pairValue);


            if (value == position) continue;

            if (pairValue == position) {

                map.put(value, pairPosition);
                map.put(pairValue, position);

                count++;
            }

        }

        for (Map.Entry entry : map.entrySet())
            System.out.println(entry.getKey() + "|" + entry.getValue());

        System.out.println(count);
    }
}
