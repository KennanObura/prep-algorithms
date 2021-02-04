package GEEKFORGEEKS.dynamicPrograming;


import java.util.HashSet;

import java.util.Set;

public class WordBreakProblem {
    public static void main(String[] args) {
        String[] words = {"i", "like", "sam", "sung", "samsung", "mobile", "ice",
                "cream", "icecream", "man", "go", "mango"};
        System.out.println(canBeBroken("ilike", words));

    }


    private static boolean canBeBroken(String sentence, String[] words) {
        Set<String> dictionary = new HashSet<>();

        for (String i : words)
            dictionary.add(i);


        return canBeBroken(sentence, dictionary);
    }

    private static boolean canBeBroken(String sentence, Set<String> dictionary) {



        if (sentence.isEmpty()) {
            return true;
        }



        for (int i = 1; i <= sentence.length(); i++) {
            String sub = sentence.substring(0, i);
            if (dictionary.contains(sub)) {
                if(canBeBroken(sentence.substring(i), dictionary))
                    return true;
            }
        }
        return false;
    }
}
