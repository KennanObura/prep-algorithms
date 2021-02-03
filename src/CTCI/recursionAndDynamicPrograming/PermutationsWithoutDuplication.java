package CTCI.recursionAndDynamicPrograming;

/**
 *
 * Permutation of a string without Duplicates
 *
 */

public class PermutationsWithoutDuplication {
    public static void main(String[] args) {

        String string = "ABC";
        permutations(string);

    }

    private static void permutations(String string) {

        permutations(string.toCharArray(), 0);
        System.out.println("-----------------------------------------");

//        for (String i : set)
//            System.out.println(i);
    }

//    private static Set<String> set = new HashSet<>();

    private static void permutations(char[] string, int index) {
        if (index >= string.length) {
//            set.add(String.valueOf(string));
            System.out.println(String.valueOf(string));
            return;
        }

        for (int i = index; i < string.length; i++) {

            string[i] = swap(string[index], string[index] = string[i]);
            permutations(string, index + 1);
            string[i] = swap(string[index], string[index] = string[i]);

        }
    }

    private static char swap(char c, char c1) {
        return c;
    }


}
