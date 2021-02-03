package GEEKFORGEEKS.dynamicPrograming;

public class CountAllPalindromicSubsequenceInString {
    public static void main(String[] args) {

        System.out.println(countPalindromicSubSequence("abcd", 0, 2));
    }

    static int countPalindromicSubSequence(String str, int i, int j) {
        if (i > j) return 0;
        if (i == j) return 1;

        if (str.charAt(i) == str.charAt(j))
            return countPalindromicSubSequence(str, i + 1, j) +
                    countPalindromicSubSequence(str, i, j - 1)+1;

        return countPalindromicSubSequence(str, i + 1, j) +
                countPalindromicSubSequence(str, i, j - 1) -
                countPalindromicSubSequence(str, i+1, j - 1);
    }
}
