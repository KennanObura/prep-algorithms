package kennan.co.ke.dynamicProgramingAndRecussion;

public class ReverseStringStack {
    public static void main(String[] args) {
        String word = "ABCEF";
        reverse(word);
    }

    private static void reverse(String word) {
        reverse(word, 0);
    }

    private static void reverse(String word, int index) {
        if (index >= word.length()) return;
        reverse(word, index + 1);
        System.out.print(word.charAt(index));
    }
}
