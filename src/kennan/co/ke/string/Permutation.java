
package kennan.co.ke.string;

public class Permutation {
    public static void main(String[] args) {
        String string = "ICO";

        permuteString(string, "");
//        StringBuilder stringBuilder = new StringBuilder()
        System.out.println("========================");
        permuteStringWithSwap(new StringBuilder(string), 0);
    }

    private static void permuteStringWithSwap(StringBuilder string, int i) {
        if (string.length() - 1 == i) {
            System.out.println(string);
            return;
        }

        for (int j = 0; j < string.length(); j++) {
            swap(string, i, j);
            permuteStringWithSwap(string, i+1);
            swap(string, i, j);
        }
    }

    private static void swap(StringBuilder string, int i, int j) {
        char temp = string.charAt(i);
        string.setCharAt(i, string.charAt(j));
        string.setCharAt(j, temp);
    }

    private static void permuteString(String string, String result) {
        if (string.length() == 0) {
            System.out.println(result);
            return;
        }

        for (int i = 0; i < string.length(); i++) {
            String temp = string.substring(0, i) + string.substring(i + 1);
            permuteString(temp, result + string.charAt(i));
        }

    }

}
