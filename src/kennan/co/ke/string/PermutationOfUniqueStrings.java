package kennan.co.ke.string;

import java.util.HashSet;
import java.util.Set;

public class PermutationOfUniqueStrings {
    public static void main(String[] args) {
        String string = "HEL";
        Set<String> permutations = permute(string, "", new HashSet<>());

        for(String i : permutations)
            System.out.println(i);
    }

    private static Set<String> permute(String string, String result, HashSet<String> resultSet) {
        if (string.length() == 0) {
            if (!resultSet.contains(result))
                resultSet.add(result);
            return resultSet;
        }

        for (int i = 0; i < string.length(); i++) {
            String before = string.substring(0, i);
            String after = string.substring(i + 1);

            permute(before + after, result + string.charAt(i), resultSet);

        }
        return resultSet;
    }
}
