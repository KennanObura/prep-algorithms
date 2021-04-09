package LEETCODE.arrays;

import java.util.*;

/**
 * 692. Top K Frequent Words
 * Given a non-empty list of words, return the k most frequent elements.
 * <p>
 * Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.
 * <p>
 * Example 1:
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 * Note that "i" comes before "love" due to a lower alphabetical order.
 * Example 2:
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 * with the number of occurrence being 4, 3, 2 and 1 respectively.
 */
public class TopKFrequentWords {
    public static void main(String[] args) {
        String[] strings = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is", "dai", "sunny"};

        System.out.println(topKFrequent(strings, 4));

        String[] words = new String[]{"i", "love", "leetcode", "i", "love", "coding"};

        System.out.println(topKFrequent(words, 2));
    }

    private static class WordFrequency {
        String word;
        int count;

        WordFrequency(String word, int count) {
            this.count = count;
            this.word = word;
        }
    }

    public static List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();
        for (String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);

        PriorityQueue<WordFrequency> queue = new PriorityQueue<>(new Comparator<WordFrequency>() {
            @Override
            public int compare(WordFrequency A, WordFrequency B) {
                int countA = A.count;
                int countB = B.count;

                return countB == countA ? A.word.compareTo(B.word) : countB - countA;
            }
        });

        List<String> result = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : map.entrySet())
            queue.add(new WordFrequency(entry.getKey(), entry.getValue()));


        while (!queue.isEmpty() && k > 0) {
            result.add(queue.poll().word);
            k--;
        }

        return result;

    }
}
