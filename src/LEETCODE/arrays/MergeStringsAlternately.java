package LEETCODE.arrays;

public class MergeStringsAlternately {
    public static void main(String[] args) {

        System.out.print(mergeAlternately("acef", "")); // abcdegfm

    }


    public static String mergeAlternately(String word1, String word2) {
        int N = word1.length(); //acef
        int M = word2.length();//bdgm

        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < N && j < M) {
            sb.append(word1.charAt(i++));
            sb.append(word2.charAt(j++));
        }

        if (i < N)
            sb.append(word1.substring(i));

        if (j < M)
            sb.append(word2.substring(j));

        return String.valueOf(sb);

    }
}
