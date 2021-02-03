package LEETCODE.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a list of words, list of  single letters (might be repeating) and score of every character.
 * <p>
 * Return the maximum score of any valid set of words formed by using the given letters (words[i] cannot be used two or more times).
 * <p>
 * It is not necessary to use all characters in letters and each letter can only be used once.
 * Score of letters 'a', 'b', 'c', ... ,'z' is given by score[0], score[1], ... , score[25] respectively.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["dog","cat","dad","good"], letters = ["a","a","c","d","d","d","g","o","o"],
 * score = [1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0]
 * Output: 23
 * Explanation:
 * Score  a=1, c=9, d=5, g=3, o=2
 * Given letters, we can form the words "dad" (5+1+5) and "good" (3+2+2+5) with a score of 23.
 * Words "dad" and "dog" only get a score of 21.
 */
public class MaxScoreOfWordFormed {
    public static void main(String[] args) {

        String[] words = {"dog", "cat", "dad", "good"};
        char[] letters = {'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'};
        int[] score = {1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        System.out.println(maxScoreWords(words, letters, score));
    }

    static private int maxScoreWords(String[] words, char[] letters, int[] score) {

        Map<Character, Integer> scoreOfChars = new HashMap<>();

        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : letters) {
            scoreOfChars.put(c, score[c - 'a']);
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        int result = solution(0, words, frequencyMap, scoreOfChars);

        System.out.println(result);
        return result;

    }

    private static int solution(int index, String[] words, Map<Character, Integer> frequencyMap, Map<Character, Integer> scoreOfLetters) {
        if (index == words.length) return 0;

        if (!isValidWord(words[index], scoreOfLetters))
            return solution(index+1, words, frequencyMap, scoreOfLetters);

        int includedScore = 0;

        boolean include = true;

        for (char c : words[index].toCharArray()) {
            if(!scoreOfLetters.containsKey(c))
                include = false;
            frequencyMap.put(c, frequencyMap.get(c) - 1);
            if (frequencyMap.get(c) < 0) include = false;
            includedScore += scoreOfLetters.get(c);
        }

        if (include)
            includedScore += solution(index + 1, words, frequencyMap, scoreOfLetters);
        else includedScore = 0;


        for (char c : words[index].toCharArray())
            frequencyMap.put(c, frequencyMap.get(c) + 1);

        int notIncludedScore  = solution(index + 1, words, frequencyMap, scoreOfLetters);


        return Math.max(includedScore, notIncludedScore);
    }


    private static boolean isValidWord(String word, Map<Character, Integer> lettersScore) {
        for (char c : word.toCharArray())
            if (!lettersScore.containsKey(c))
                return false;
        return true;
    }
}
