package LEETCODE.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.
 * <p>
 * Example 1:
 * <p>
 * Input: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * Output: 16
 * Explanation: The two words can be "abcw", "xtfn".
 * Example 2:
 * <p>
 * Input: ["a","ab","abc","d","cd","bcd","abcd"]
 * Output: 4
 * Explanation: The two words can be "ab", "cd".
 * Example 3:
 * <p>
 * Input: ["a","aa","aaa","aaaa"]
 * Output: 0
 * Explanation: No such pair of words.
 */
public class MaxProductOfWordLength {
    public static void main(String[] args) {
        String[] words = {"a","ab","abc","d","cd","bcd","abcd"};

        System.out.println(maxProduct(words));
    }


    static private int maxProduct(String[] words) {

        Set<Character>[] setOfWords = new Set[words.length];

        for (int i = 0; i < setOfWords.length; i++)
            setOfWords[i] = new HashSet<>();



        int maxProd = Integer.MIN_VALUE;

        for (int i = 0; i < words.length; i++)
            for (char c : words[i].toCharArray())
                setOfWords[i].add(c);




        for (String word : words) {
            for (int j = 0; j < words.length; j++) {
                if (!containsSameChar(word, setOfWords[j]))
                    maxProd = Math.max(word.length() * words[j].length(), maxProd);

            }
        }

        return maxProd == Integer.MIN_VALUE ? 0 : maxProd;
    }

    static private boolean containsSameChar(String word, Set<Character> characterSet) {
        for (char c : word.toCharArray())
            if (characterSet.contains(c))
                return true;
        return false;
    }

}
