package HACKERRANK;

public class HackerrankInString {
    public static void main(String[] args) {
        System.out.println(hackerrankInString("hackerworld"));
    }

    static String hackerrankInString(String s) {

        String ref = "hackerrank";

        int i = 0;
        for (char c : s.toCharArray())
            if (c == ref.charAt(i))
                i++;

        if (i == ref.length())
            return "YES";
        return "NO";


    }
}
