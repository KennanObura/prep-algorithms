package ANDELA;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PackingDilemma {
    public static void main(String[] args) {
        List<Integer> items = Arrays.asList(2, 4, 5, 10);

        System.out.println(minCars(items, 3));
    }

    private static int minCars(List<Integer> cars, int k) {

        if(cars.size() == 1) return cars.get(0);

        Collections.sort(cars);

        int start = 0;
        if(cars.size() <= k)
            return cars.get(cars.size()-1) - cars.get(start)+1;

        int distance = Integer.MAX_VALUE;

        for (int i = k - 1; i < cars.size(); i++) {
            long current = cars.get(i) - cars.get(start)+1;
            distance = Math.min((int) current, distance);
            start++;
        }
        return distance;

    }
}
