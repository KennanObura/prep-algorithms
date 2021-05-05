package java2blog.string;

public class ReverseString {
    public static void main(String[] args) {

        System.out.println(reverse("ABCDEFGH"));
    }

    private static String reverse(String word) {

        int j = word.length() - 1;
        int i = 0;
        char[] wordChars = word.toCharArray();

        while (i < j) {
            wordChars[i] = swap(wordChars[j], wordChars[j--] = wordChars[i++]);
        }

        return String.valueOf(wordChars);
    }

    private static char swap(char i, char c) {
        return i;
    }

}
