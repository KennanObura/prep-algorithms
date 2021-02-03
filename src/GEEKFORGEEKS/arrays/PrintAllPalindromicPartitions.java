package GEEKFORGEEKS.arrays;

/**
 * Given a string, find all possible palindromic partitions of given string.
 * <p>
 * Example
 * Input: nitin
 * output {
 * n i t i n
 * n iti n
 * nitin
 * <p>
 * <p>
 * <p>
 * }
 * <p>
 * Example
 * Input : geeks
 * Output {
 * g e e k s
 * <p>
 * g ee k s
 * }
 */
public class PrintAllPalindromicPartitions {
    public static void main(String[] args) {
        String word = "nitin";
//        palindromicPartitions(word);
        palindromicPartitionRecur(word, 0);
    }

    private static void palindromicPartitions(String word) {

        for (int i = 0; i < word.length(); i++) {

            int back = i;
            int front = i;
            while (back >= 0 && front < word.length() && word.charAt(back) == word.charAt(front)) {
                System.out.println(word.substring(back, front + 1));
                back--;
                front++;
            }
        }
    }


    private static void palindromicPartitionRecur(String word, int index) {

        if (index >= word.length()) return;

        palindromicPartitionRecur(word, index + 1);

        int back = index;
        int front = index;
        String part = word.substring(back, front + 1);
        if(isPalindrome(part, back, front))
            System.out.println(part);


    }


    private static boolean isPalindrome(String word, int back, int front) {
        while (back < front && word.charAt(back++) == word.charAt(front--))
            if (front == back) return true;
        return false;
    }
}
