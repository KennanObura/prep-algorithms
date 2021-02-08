package ANDELA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CompetativeGaming {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(100);
        System.out.println(numPlayers(4, list));

    }

    public static int numPlayers(int k, List<Integer> scores) {
        // Write your code here
        scores.sort(Collections.reverseOrder());
        List<Integer> ranks = new ArrayList<>();

        ranks.add(1);


        for (int i = 1; i < scores.size(); i++) {

            if (scores.get(i) == 0)
                break;


            if (scores.get(i).equals(scores.get(i - 1)))
                ranks.add(ranks.get(i - 1));
            else {
                int current = ranks.get(i - 1) + 1;
                if (current > k)
                    return ranks.size();
                else
                    ranks.add(current);
            }
        }
        System.out.println(ranks);

        return ranks.size();
    }
}
