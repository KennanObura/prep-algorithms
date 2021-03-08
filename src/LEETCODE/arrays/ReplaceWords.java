package LEETCODE.arrays;

import java.util.*;

/**
 * 648. Replace Words
 * Medium
 * <p>
 * In English, we have a concept called root, which can be followed by some other word to form another longer word - let's call this word successor. For example, when the root "an" is followed by the successor word "other", we can form a new word "another".
 * <p>
 * Given a dictionary consisting of many roots and a sentence consisting of words separated by spaces, replace all the successors in the sentence with the root forming it. If a successor can be replaced by more than one root, replace it with the root that has the shortest length.
 * <p>
 * Return the sentence after the replacement.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * Output: "the cat was rat by the bat"
 * Example 2:
 * <p>
 * Input: dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
 * Output: "a a b c"
 * Example 3:
 * <p>
 * Input: dictionary = ["a", "aa", "aaa", "aaaa"], sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"
 * Output: "a a a a a a a a bbb baba a"
 */

public class ReplaceWords {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(replaceWords(list, sentence));


        List<String> list2 = Arrays.asList("a", "aa", "aaa", "aaaa");
        String sentence2 = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa";
        System.out.println(replaceWords(list2, sentence2));
    }


    public static String replaceWords(List<String> dictionary, String sentence) {
        Set<String> set = new HashSet<>(dictionary);
        List<String> stringList = new ArrayList<>(Arrays.asList(sentence.split(" ")));


        for (int k = 0; k < stringList.size(); k++) {
            String word = stringList.get(k);
            int N = word.length();

            for (int i = 1; i <= N; i++) {
                String subStr = word.substring(0, i);
                if (set.contains(subStr)) {
                    stringList.remove(k);
                    stringList.add(k, subStr);
                    break;
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (String string : stringList) {
            stringBuilder.append(string);
            if (i < stringList.size() - 1)
                stringBuilder.append(" ");
            i++;
        }

        System.out.println(stringList);
        return String.valueOf(stringBuilder);

    }
}
