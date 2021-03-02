package LEETCODE.arrays;

import java.util.HashSet;
import java.util.Set;

/*
211. Design Add and Search Words Data Structure
Medium

Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.


Example:

Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True
 */

public class DesignAddAndSearchWordsDataStructure {
    public static void main(String[] args) {

//        ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
//[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("mad");
        wordDictionary.addWord("pad");

        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));
        System.out.println(wordDictionary.search("be."));


    }


}

class WordDictionary {
    Set<String> set;
    String DOT = ".";

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        set = new HashSet<>();
    }

    public void addWord(String word) {
        set.add(word);
    }

    public boolean search(String word) {
        if (word.isEmpty()) return false;
        if (word.contains(DOT)) {
            char firstChar = word.charAt(0);
            //starts with dot
            if (String.valueOf(firstChar).equals(DOT))
                return isMatchStartingWithDot(word);
                //starts with char / dot
            else return isMatchEndingWithDot(word);
        } else
            return set.contains(word);

    }

    private boolean isMatchEndingWithDot(String word) {
        for (String dict : set) {
            int i = 0;
            int keyLength = word.length();
            while (dict.length() == keyLength && i < keyLength && word.charAt(i) == dict.charAt(i)) i++;
            if (word.charAt(i) == '.')
                return true;
        }
        return false;
    }

    private boolean isMatchStartingWithDot(String word) {
        for (String dict : set) {
            int i = dict.length()-1;
            int keyLength = word.length();
            while (dict.length() == keyLength && i > 0 && word.charAt(i) == dict.charAt(i)) i--;
            if (word.charAt(i) == '.')
                return true;
        }
        return false;
    }
}

