package kennan.co.ke.dynamicProgramingAndRecussion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * : Write a method to return all subsets of a set.
 * <p>
 * The power set of a given set S is the set of all subsets of S, including S itself and the empty set.
 * <p>
 * For example, for a given set:
 * <p>
 * {"APPLE", "ORANGE", "MANGO"}
 * the power set is:
 * <p>
 * {
 * {},
 * {"APPLE"},
 * {"ORANGE"},
 * {"APPLE", "ORANGE"},
 * {"MANGO"},
 * {"APPLE", "MANGO"},
 * {"ORANGE", "MANGO"},
 * {"APPLE", "ORANGE", "MANGO"}
 * }
 */
public class PowerSet {


    public static void main(String[] args) {
        String[] items = {"APPLE", "ORANGE", "MANGO"};
        ArrayList<ArrayList<String>> powerSet = generatePowerSet(Arrays.asList(items), 0);

        for (ArrayList<String> list : powerSet)
            System.out.println(Arrays.toString(list.toArray()));
    }


    private static ArrayList<ArrayList<String>> generatePowerSet(List<String> items, int index) {
        ArrayList<ArrayList<String>> result;
        if (items.size() == index) {
            result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }

        result = generatePowerSet(items, index + 1);
        String current = items.get(index);

        ArrayList<ArrayList<String>> others = new ArrayList<>();
        for (ArrayList<String> item : result) {
            ArrayList<String> newList = new ArrayList<>(item);
            newList.add(current);
            others.add(newList);
        }
        result.addAll(others);
        return result;
    }
}
