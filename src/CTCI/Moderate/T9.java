package CTCI.Moderate;

import java.util.*;

/**
 * T9: On old cell phones, users typed on a numeric keypad and the phone would provide a list of
 * words that matched these numbers. Each digit mapped to a set of 0 - 4 letters. Implement an algo-
 * rithm to return a list of matching words, given a sequence of digits. You are provided a list of valid
 * words (provided in whatever data structure you'd like). The mapping is shown in the diagram below:
 */
public class T9 {
    public static void main(String[] args) {
        List<String> phoneDigits = Arrays.asList(
                "",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"

        );

        Set<String> set = new HashSet<>(Arrays.asList("mum", "tree", "lee", "used"));

        System.out.println(findWords(set, phoneDigits, 8733));
    }


    private static List<String> findWords(Set<String> dictionary, List<String> phoneDigits, int digit) {
        Map<String, String> map = new HashMap<>();

        for (String st : phoneDigits)
            if (!st.isEmpty())
                map.put(String.valueOf(phoneDigits.indexOf(st)), st);

        String number = String.valueOf(digit);
        List<String> mappedString = new ArrayList<>();

        for (char d : number.toCharArray())
            mappedString.add(map.get(String.valueOf(d)));

        System.out.println(mappedString);


        return mappedString;
    }


    private static void generateCombinations(List<String> mappedString, Set<String> dictionary, int index){


        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < mappedString.size(); i++) {


        }
    }
}
