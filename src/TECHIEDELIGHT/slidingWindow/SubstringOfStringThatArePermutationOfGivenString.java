package TECHIEDELIGHT.slidingWindow;

import java.util.*;

/**
 * https://www.techiedelight.com/find-substrings-string-permutation-given-string/
 */

public class SubstringOfStringThatArePermutationOfGivenString {
    public static void main(String[] args) {
//        System.out.println(getSubstrings("ABCADACBA", "BAC"));

        System.out.println(getSubstringsEfficient("ABCADACBA", "BAC"));


    }

    private static List<String> getSubstrings(String A, String B) {
        /*
        A -> ABCADACBA
        B -> BCA
         */
        int N = A.length();
        int K = B.length(); // 3

        if (A.isEmpty() || B.isEmpty() || K > N)
            return new ArrayList<>();


        String sorted = sortString(B);
        List<String> resultList = new ArrayList<>();

        for (int i = 0; i < N - K + 1; i++) {
            String sb = A.substring(i, i + K);
            String sortedSb = sortString(sb); //klogk
            if (sortedSb.equals(sorted)) // k^2
                resultList.add(sb);
        }
        return resultList;
    }


    private static List<String> getSubstringsEfficient(String A, String B) {
        /*
        A -> ABCADACBA
        B -> BCA
         */
        int N = A.length();
        int K = B.length(); // 3

        if (A.isEmpty() || B.isEmpty() || K > N)
            return new ArrayList<>();


        List<String> resultList = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();

        for (char b : B.toCharArray())
            map.put(b, map.getOrDefault(b, 0) + 1);


        int start = 0;
        int match = 0;
        for (int end = 0; end < N; end++) {
            char endWinChar = A.charAt(end);
            if (map.containsKey(endWinChar)) {
                map.put(endWinChar, map.get(endWinChar) - 1);
                if (map.get(endWinChar) == 0) match++;
            }

            if (map.size() == match) {
                resultList.add(A.substring(start, end + 1));
            }


            if ((end - start) + 1 > K) {
                char startWinChar = A.charAt(start);
                if (map.containsKey(startWinChar)) {
                    if (map.get(startWinChar) == 0) match--;
                    map.put(startWinChar, map.get(startWinChar) + 1);
                }
                start++;
            }
        }


        return resultList;
    }

    private static String sortString(String input) {
        char[] ch = input.toCharArray();
        Arrays.sort(ch);
        return String.valueOf(ch);
    }
}
