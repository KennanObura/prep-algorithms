package kennan.co.ke.priorityQueue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a huge set of strings with duplicates strings present in it, find the first K-maximum words occurring in it.
 * <p>
 * Example
 * keys = ["code", "coder", "coding", "codable", "codec", "codecs", "coded",
 * "codeless", "codec", "codecs", "codependence", "codex", "codify",
 * "codependents", "codes", "code", "coder", "codesign", "codec",
 * "codeveloper", "codrive", "codec", "codecs", "codiscovered"]
 * <p>
 * K =4
 * <p>
 * Output
 * Codec (4)
 * codecs (3)
 * code(2)
 * coder(2)
 */


/*
 * We start by representing our String by creating an Object class to store frequency and key
 * We iterate through array of string, create a representation object and keep in a map with string as key and Node as value
 *
 * once done, create a priority queue, Iterate through map and store Nodes to Queue in reverse ordering using Comparator
 *
 * Just pop K elements from priority Queue
 *
 */
public class MaximumOccurringWords {
    public static void main(String[] args) {
        String[] keys = {"code", "coder", "coding", "codable", "codec", "codecs", "coded",
                "codeless", "codec", "codecs", "codependence", "codex", "codify",
                "codependents", "codes", "code", "coder", "codesign", "codec",
                "codeveloper", "codrive", "codec", "codecs", "codiscovered"};

        MaximumOccurringWords maximumOccurringWords = new MaximumOccurringWords();
        maximumOccurringWords.get(keys, 4);
    }

    private  class Node  {
        private String key;
        private int frequency;

        Node() {
        }

        public int getFrequency() {
            return frequency;
        }

        public String getKey() {
            return key;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key='" + key + '\'' +
                    ", frequency=" + frequency +
                    '}';
        }

    }



    private
    void get(String[] keys, int k) {
        Map<String, Node> map = new HashMap<>();

        for (String key : keys) {
            Node node = map.getOrDefault(key, new Node());
            node.key = key;
            node.frequency = node.frequency + 1;
            map.put(key, node);
        }

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Node::getFrequency).reversed());

        for (Map.Entry<String, Node> entry : map.entrySet())
            priorityQueue.add(entry.getValue());

        for(int i = 0; i < k ; i++)
            System.out.println(priorityQueue.poll());


    }
}
