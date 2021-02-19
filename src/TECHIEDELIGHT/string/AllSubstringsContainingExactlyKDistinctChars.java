package TECHIEDELIGHT.string;

import java.util.*;

/**
 * https://www.techiedelight.com/find-all-substrings-containing-exactly-k-distinct-characters/
 */
public class AllSubstringsContainingExactlyKDistinctChars {

    public static void main(String[] args) {

        System.out.println(substringsContainingKDistinctChars("abcbd", 3));
    }

    private static List<String> substringsContainingKDistinctChars(String input, int K) {

        int N = input.length();
        List<String> resultList = new ArrayList<>();

        for (int i = 0; i < N - K + 1; i++) {

            Set<Character> innerSet = new HashSet<>();
            for (int j = i; j < N && innerSet.size() <= K; j++) {
                char ch = input.charAt(j);
                innerSet.add(ch);

                if (innerSet.size() == K) {
                    resultList.add(input.substring(i, j + 1));

                }
            }
        }

//        while (map.size() > )

        return resultList;
    }
}
