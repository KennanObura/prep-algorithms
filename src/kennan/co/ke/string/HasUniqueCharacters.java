package kennan.co.ke.string;

public class HasUniqueCharacters {
    public static void main(String[] args) {

        System.out.println(solve("solveo"));
    }

    private static boolean solve(String word) {
        if(word.length() > 128) return false;
        if(word.length() == 1) return true;

        boolean[] seen = new boolean[128];

        for (char w : word.toCharArray()) {
            if (seen[w]) return false;
            seen[w] = true;
        }
        return true;
    }
}
