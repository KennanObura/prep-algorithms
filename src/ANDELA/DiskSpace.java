package ANDELA;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DiskSpace {
    public static void main(String[] args) {
        List<Integer> items = Arrays.asList(2,5,4,6,8);

        System.out.println(spaceAvailable(3,items));
    }



    private static int spaceAvailable(int x, List<Integer> space) {

        int maxima = Integer.MIN_VALUE;

        for (int i = 0; i < space.size()-x; i++) {
            int minimumItem = Integer.MAX_VALUE;
            for (int j = i; j <= i+x ; j++) {
                minimumItem = Math.min(space.get(j), minimumItem);
            }
            maxima = Math.max(maxima, minimumItem);

        }
        return maxima;

    }
}
