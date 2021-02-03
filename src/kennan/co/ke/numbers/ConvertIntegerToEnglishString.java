package kennan.co.ke.numbers;

import java.util.LinkedList;

public class ConvertIntegerToEnglishString {
    static String[] belowTwenty = {
            "zero ", "one ", "two ", "three ", "four ", "five ", "six ", "seven ", "eight ", "nine ", "ten ",
            "eleven ", "twelve ", "thirteen ", "fourteen ", "fifteen ", "sixteen ", "seventeen ", "eighteen ", "nineteen "
    };

    static String[] tens = {" ", " ", "twenty ", "thirty ", "forty ", "fifty ", "sixty ", "seventy ", "eighty ", "ninety "};

    static String[] bigs = {" ", "thousand ", "billion "};

    static String hundred = "hundred ";
    static String negative = "negative ";

    public static void main(String[] args) {

        System.out.println(numberConverter(4538989));
    }

    private static String numberConverter(int number) {

        if (number == 0) return belowTwenty[number];

        boolean isNegative = false;
        if (number < 0) {
            isNegative = true;
            return numberConverter(number * -1);
        }


        LinkedList<String> parts = new LinkedList<>();

        int chunkCounter = 0;

        while (number > 0) {
            if (number % 1000 != 0) {
                String temp = convertToString(number % 1000)  + bigs[chunkCounter];
                parts.addFirst(temp);
            }
            number /= 1000;
            chunkCounter++;
        }
        return listToString(parts);
    }

    private static String listToString(LinkedList<String> parts) {
        StringBuilder result = new StringBuilder();
        for (String part : parts)
            result.append(part);
        return result.toString();
    }

    private static String convertToString(int number) {
        LinkedList<String> parts = new LinkedList<>();
        if (number >= 100) {
            parts.addLast(belowTwenty[number / 100]  + hundred); //eg 324 = 3 => three + hundred(bigs[0])
            number %= 100;
        }

        if (number >= 20) {
            parts.addLast(tens[number / 10]);
            number %= 10;
        }

        if (number > 0) {
            parts.addLast(belowTwenty[number]);
        }

        return listToString(parts);
    }
}
