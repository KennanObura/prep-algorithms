package kennan.co.ke.trees;


import java.util.HashMap;
import java.util.Map;

public class Trie {
    private TrieNode root;

    Trie() {
        this.root = new TrieNode();
    }

    void put(String key) {
        if (key.isEmpty()) throw new RuntimeException("Key is empty");

        TrieNode crawler = root;
        for (char c : key.toCharArray()) {
            crawler.links.putIfAbsent(c, new TrieNode());
            crawler = crawler.links.get(c);
        }

        crawler.isEnd = true;
    }


    boolean contains(String key) {
        if (key.isEmpty()) throw new RuntimeException("Key is empty");

        TrieNode crawler = root;
        for (char c : key.toCharArray()) {
            if (!crawler.links.containsKey(c)) return false;
            crawler = crawler.links.get(c);
        }
        return (crawler != null && crawler.isEnd);
    }

    String longestPrefix() {
        TrieNode crawler = root;

        StringBuilder result = new StringBuilder();
        while (crawler != null && !crawler.isEnd && (crawler.links.size() == 1)) {

            for (Map.Entry<Character, TrieNode> entry : crawler.links.entrySet()) {
                result.append(entry.getKey());
                crawler = entry.getValue();
            }
        }
        return result.toString();
    }


    public static void main(String[] args) {
        String[] keys = {"moose", "moodle", "moon", "mood"};
        Trie trie = new Trie();
        for (String s : keys)
            trie.put(s);

        System.out.println(trie.contains("mood"));

        System.out.println(trie.longestPrefix());
    }
}

class TrieNode {
    boolean isEnd;
    Map<Character, TrieNode> links;

    TrieNode() {
        isEnd = false;
        links = new HashMap<>();
    }
}

