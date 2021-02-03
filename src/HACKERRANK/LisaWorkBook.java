package HACKERRANK;

import java.util.*;

public class LisaWorkBook {
    public static void main(String[] args) {
        int k = 3;
        int[] chapters = {4, 2, 6, 1, 11};

        System.out.println(workbook(chapters.length, k, chapters));

    }

    static int workbook(int n, int k, int[] arr) {

        Map<Integer, HashSet<Integer>> pages = new HashMap<>();

        int page = 0;
        for (int chapter : arr) {

            if (chapter <= k) {
                pages.put(++page, new HashSet<>());
                Set<Integer> set = pages.get(page);
                int j = 1;

                while (j <= chapter)
                    set.add(j++);
            } else {
                int lastProblem = chapter % k;
                int j = 0;

                while (j < chapter - lastProblem) {
                    pages.put(++page, new HashSet<>());
                    Set<Integer> set = pages.get(page);

                    for (int i = j+1; i <= j+k; i++)
                        set.add(i);
                    j += k;
                }
                j++;

                if (lastProblem > 0) {
                    pages.put(++page, new HashSet<>());
                    Set<Integer> set = pages.get(page);
                    while (lastProblem-- > 0)
                        set.add(j++);
                }
            }
        }

        int count = 0;

        for (Map.Entry<Integer, HashSet<Integer>> entry : pages.entrySet()) {
//            System.out.println(entry.getKey() + ", " + entry.getValue());
            if(entry.getValue().contains(entry.getKey()))
                count++;
        }


        return count;
    }
}
