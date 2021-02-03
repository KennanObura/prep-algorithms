package HACKERRANK;

public class BeautifulBinaryString {
    public static void main(String[] args) {

        System.out.println(beautifulBinaryString("01100"));
    }

    static int beautifulBinaryString(String b) {
        if(b.length() < 3) return 0;
        StringBuilder B = new StringBuilder(b);
        String substr = "010";
        int count = 0;

        for (int i = 0; i < B.length() - substr.length()+1; i++) {
            String current = B.substring(i, i + substr.length());

            if (current.equals(substr)) {
                B.replace(i + substr.length() - 1, i + substr.length(), "1");
                count++;
            }
        }
        return count;
    }


}
