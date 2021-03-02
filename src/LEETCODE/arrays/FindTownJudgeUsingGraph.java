package LEETCODE.arrays;

import java.util.*;

/*
997. Find the Town Judge
 * In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.

Example 1:

Input: N = 2, trust = [[1,2]]
Output: 2
Example 2:

Input: N = 3, trust = [[1,3],[2,3]]
Output: 3
Example 3:

Input: N = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1
Example 4:

Input: N = 3, trust = [[1,2],[2,3]]
Output: -1
Example 5:

Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
Output: 3
 */
public class FindTownJudgeUsingGraph {
    public static void main(String[] args) {

        int[][] trust = {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};

        int[][] trust2 = {{1, 3}, {2, 3}, {3, 1}};

        int[][] trust3 = {{2, 3}};
        int[][] trust4 = {{1, 2}, {2, 3}};

        System.out.println(findJudge(trust.length, trust));
        System.out.println(findJudge(trust2.length, trust2));
        System.out.println(findJudge(trust3.length, trust3));
        System.out.println(findJudge(trust4.length, trust4));
    }

    public static int findJudge(int N, int[][] trust) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] people : trust) {
            map.putIfAbsent(people[0], new HashSet<>());
            map.putIfAbsent(people[1], new HashSet<>());
        }

        for (int[] people : trust) {
            Set<Integer> list = map.get(people[0]);
            list.add(people[1]);
            map.put(people[0], list);
        }

        int judge = -1;
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet())
            if (entry.getValue().isEmpty()) {
                judge = entry.getKey();
                break;
            }

//        System.out.println(judge);
        if (judge == -1)
            return -1;
        else {
            map.remove(judge);
            for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet())
                if (!entry.getValue().contains(judge)) return -1;
            return judge;
        }
    }
}
