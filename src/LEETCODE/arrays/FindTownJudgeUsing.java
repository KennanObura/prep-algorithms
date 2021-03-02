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
public class FindTownJudgeUsing {
    public static void main(String[] args) {

        int[][] trust = {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};

        int[][] trust2 = {{1, 3}, {2, 3}, {3, 1}};

        int[][] trust3 = {{1, 2}};
        int[][] trust4 = {{1, 2}, {2, 3}};

//        System.out.println(findJudge(4, trust));
//        System.out.println(findJudge(3, trust2));
        System.out.println(findJudge(2, trust3));
//        System.out.println(findJudge(3, trust4));
    }

    public static int findJudge(int N, int[][] trust) {

        if(N == 1) return 1;
       /*
       - let Array inns to keep track of count of the incoming connection. a -> b  >> keep a
       - let Array outs to keep track of count of the outgoing connections . a -> b >> keep b

       traverse both arrays
            if(outs[i] == 0 && ins[i] == N-1) return i;
        */

        int[] inns = new int[N + 1];
        int[] outs = new int[N + 1];

        for (int[] people : trust) {
            inns[people[0]]++;
            outs[people[1]]++;
        }


        System.out.println(Arrays.toString(inns));
        System.out.println(Arrays.toString(outs));

        for (int i = 1; i <= N; i++)
            if (inns[i] == 0 && outs[i] == N - 1) return i;


        return -1;
    }
}
