package kennan.co.ke.DSImplementations;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SortHashMapByValues {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        // enter data into hashmap
        map.put("Math", 98);
        map.put("Data Structure", 85);
        map.put("Database", 91);
        map.put("Java", 95);
        map.put("Operating System", 79);
        map.put("Networking", 80);

        HashMap<String, Integer> sortedMap = sortMap(map, new HashMap<>());

        for (Map.Entry<String, Integer> entry: sortedMap.entrySet())
            System.out.println(entry.getKey() +" , "+ entry.getValue());
    }

    private static HashMap<String, Integer> sortMap(HashMap<String, Integer> map, HashMap<String, Integer> result) {
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>(map);

//        result = linkedHashMap.entrySet().stream().sorted(new ValueComparator())
//                .collect(Collectors.toMap();

//        result.putAll(linkedHashMap);
        return result;
    }
}

class ValueComparator implements Comparator<Map.Entry<String, Integer>> {
    @Override
    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        return o1.getValue().compareTo(o2.getValue());
    }
}
