package LEETCODE.arrays;

public class ConsecutiveCharacters {
    public static void main(String[] args) {

        System.out.println(maxPower("leetcode"));

        System.out.println(maxPower("l"));
        System.out.println(maxPower(""));
        System.out.println(maxPower("abbcccddddeeeeedcba"));
        System.out.println(maxPower("triplepillooooow"));
        System.out.println(maxPower("hooraaaaaaaaaaay"));
        System.out.println(maxPower("tourist"));

    }

    public static int maxPower(String s) {
        if(s.isEmpty()) return 0;
        int N = s.length();
        int count = 1, prev = s.charAt(0), maxLength = 1;

        for (int i = 1; i < N; i++) {
            if (prev == s.charAt(i)) {
                count++;
                maxLength = Math.max(maxLength, count);
            } else
                count = 1;
            prev = s.charAt(i);
        }
        return maxLength;
    }
}
