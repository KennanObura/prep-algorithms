package LEETCODE.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 676. Implement Magic Dictionary
 * Medium
 * Design a data structure that is initialized with a list of different words. Provided a string, you should determine if you can change exactly one character in this string to match any word in the data structure.
 * <p>
 * Implement the MagicDictionary class:
 * <p>
 * MagicDictionary() Initializes the object.
 * void buildDict(String[] dictionary) Sets the data structure with an array of distinct strings dictionary.
 * bool search(String searchWord) Returns true if you can change exactly one character in searchWord to match any string in the data structure, otherwise returns false.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["MagicDictionary", "buildDict", "search", "search", "search", "search"]
 * [[], [["hello", "leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
 * Output
 * [null, null, false, true, false, false]
 */
public class ImplementMagicDictionary {
    public static void main(String[] args) {

        MagicDictionary dictionary = new MagicDictionary();
        dictionary.buildDict(new String[]{"hello", "leetcode"});
        System.out.println(dictionary.search("hello"));
        System.out.println(dictionary.search("hell"));
        System.out.println(dictionary.search("leetcoded"));

        System.out.println(dictionary.search("hhllo"));

    }
}


class MagicDictionary {

    private final List<String> dictionary;

    /**
     * Initialize your data structure here.
     */
    public MagicDictionary() {
        this.dictionary = new ArrayList<>();
    }

    public void buildDict(String[] dictionary) {
        this.dictionary.addAll(Arrays.asList(dictionary));
    }

    public boolean search(String searchWord) {
        int wordDiff = searchUtil(searchWord);
        return wordDiff == 1;
    }

    private int searchUtil(String candidate) {
        for (String word : dictionary) {
            if (word.length() != candidate.length())
                continue;
            if (searchUtil(word, candidate))
                return 1;
        }
        return -1;
    }

    private boolean searchUtil(String word, String candidate) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != candidate.charAt(i))
                count++;
            if (count > 1) return false;
        }

        return count == 1;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
