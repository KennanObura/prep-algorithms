package kennan.co.ke.priorityQueue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a string, Find first K non repeating characters in it by doing only single traversal on string
 * <p>
 * String str = "ABCDBAGHCHFAC";
 * int k = 3;
 * Output : DGF
 */

/* Make an object representation with of string frequency {last index, char, frequency}
 *  Traverse string, make frequency map
 *  Traverse map, Keep in priority queue with ordering of indices
 */
public class FirstKNonRepeatingCharInString {
    public static void main(String[] args) {
        String str = "ABCDBAGHCHFAC";
        int k = 3;

        firstNonRepeatingCharacters(str, k);
    }

    private static class CharNode {
        int index;
        int frequency;
        char key;

        public int getFrequency() {
            return frequency;
        }

        public int getIndex() {
            return index;
        }
    }

    private static void firstNonRepeatingCharacters(String string, int k) {
        Map<Character, CharNode> map = new HashMap<>();

        for (char ch : string.toCharArray()) {
            CharNode node = map.getOrDefault(ch, new CharNode());
            node.index = string.indexOf(ch);
            node.frequency += 1;
            node.key = ch;
            map.put(ch, node);
        }

        PriorityQueue<CharNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(CharNode::getIndex));

        for (Map.Entry<Character, CharNode> entry : map.entrySet())
            priorityQueue.add(entry.getValue());


        int count = 0;
        while (!priorityQueue.isEmpty() && count <= k) {
            CharNode node = priorityQueue.remove();
            if (node.frequency == 1) {
                System.out.println(node.key);
                count++;
            }
        }
    }
}
