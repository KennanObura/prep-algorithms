package TUTORIALHORIZON.backtracking;

import java.util.*;

/**
 * Objective : Given an string and a dictionary of words, find out if the input string can be broken into a space-separated sequence of one or more dictionary words.
 *
 * Example:
 *
 * dictionary = ["I" , "have", "Jain", "Sumit", "am", "this", "dog"]
 *
 * String = "IamSumit"
 *
 * Output: "I am Sumit"
 *
 * String ="thisisadog"
 *
 * Output : String can't be broken
 */

public class WordBreak {
    public static void main(String[] args) {

        String [] dictionary = new String[]{"this", "is", "sumit", "jain", "the", "problem"};
        String input = "thisissumitjain";

        List<String> list = new ArrayList<>(Arrays.asList(dictionary));

        System.out.println(canBeBroken(list, input));

    }

    private static boolean canBeBroken(List<String> dictionary, String input){
        Set<String> setDictionary = new HashSet<>(dictionary);
         canBeBroken(setDictionary, input);
         return false;
    }

    private static void canBeBroken(Set<String> dictionary, String input) {
        if(input.isEmpty()) return;


        for (int i = 1; i < input.length() ; i++) {
            String prefix = input.substring(0, i);
            if(dictionary.contains(prefix)){
                String suffix = input.substring(i);
                canBeBroken(dictionary, suffix);

            }
        }
    }
}
