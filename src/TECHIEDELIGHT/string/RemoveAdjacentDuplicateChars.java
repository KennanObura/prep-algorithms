package TECHIEDELIGHT.string;

public class RemoveAdjacentDuplicateChars {
    public static void main(String[] args) {
        String word = "AAABBBCDDDF";
        removeDuplicate(word);

        System.out.println("=================");
        StringBuilder builder = new StringBuilder();
        builder.append(word.charAt(0));

        removeDuplicateRecur(word, builder, word.charAt(0), 1);

        System.out.println(builder.toString());
    }




    private static void removeDuplicate(String word){
        char CURRENT = word.charAt(0);
        StringBuilder builder = new StringBuilder();
        builder.append(CURRENT);

        for (int i = 1; i < word.length() ; i++) {

            if(word.charAt(i) == CURRENT) continue;

            CURRENT = word.charAt(i);
            builder.append(CURRENT);
        }

        System.out.println(builder.toString());
    }






    private static void removeDuplicateRecur(String word, StringBuilder result, char current, int index){
        if(index >= word.length()) return;

        if(current != word.charAt(index)) {
            current = word.charAt(index);
            result.append(current);
        }
        removeDuplicateRecur(word, result, current, index+1);
    }

}
