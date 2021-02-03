package kennan.co.ke.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the
 * "compressed" string would not become smaller than the original string, your method should return
 * the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 */
public class StringCompression {
    public static void main(String[] args) {
        System.out.println(compress("abcdd"));
    }

    private static String compress(String sentence) {
        StringBuilder stringBuilder = new StringBuilder();

        int count = 1;
        boolean canCompress = false;
        for (int i = 0; i < sentence.length(); i++) {
            if (i < sentence.length() - 1 && sentence.charAt(i) == sentence.charAt(i + 1)) {
                canCompress = true;
                count++;
            } else {
                String temp = sentence.charAt(i)+"";
                stringBuilder.append(temp);
                stringBuilder.append(count);
                count = 1;
            }
        }
        if (!canCompress) return sentence;
        return stringBuilder.toString();
    }
}
