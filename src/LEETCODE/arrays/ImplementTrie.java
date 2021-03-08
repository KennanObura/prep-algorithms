package LEETCODE.arrays;


import java.util.Arrays;

/**
 * 208. Implement Trie (Prefix Tree)
 * Medium
 * Trie (we pronounce "try") or prefix tree is a tree data structure used to retrieve a key in a strings dataset. There are various applications of this very efficient data structure, such as autocomplete and spellchecker.
 * <p>
 * Implement the Trie class:
 * <p>
 * Trie() initializes the trie object.
 * void insert(String word) inserts the string word to the trie.
 * boolean search(String word) returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
 * boolean startsWith(String prefix) returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * Output
 * [null, null, true, false, true, null, true]
 */
public class ImplementTrie {
    public static void main(String[] args) {

        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));

    }
}

class TrieNode {
    boolean endOfWord;
    TrieNode[] links;

    TrieNode() {
        endOfWord = false;
        links = new TrieNode[26];
    }

    @Override
    public String toString() {
        return "TrieNode{" +
                "endOfWord=" + endOfWord +
                ", links=" + Arrays.toString(links) +
                '}';
    }
}

class Trie {

    /**
     * Initialize your data structure here.
     */
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {

        TrieNode crawler = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (crawler.links[index] == null)
                crawler.links[index] = new TrieNode();
            crawler = crawler.links[index];
        }
        crawler.endOfWord = true;

    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode crawler = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (crawler.links[index] == null)
                return false;
            crawler = crawler.links[index];
        }


        return crawler != null && crawler.endOfWord;

    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode crawler = root;

        int count = 0;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (crawler.links[index] == null)
                return false;

            count++;
            crawler = crawler.links[index];

        }
        return crawler != null && count == prefix.length();

    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
