package GEEKFORGEEKS.dynamicPrograming;

/**
 * Given n friends, each one can remain single or can be paired up with some other friend.
 * Each friend can be paired only once. Find out the total number of ways in which friends can remain single or can be paired up.
 * <p>
 * Examples :
 * <p>
 * Input  : n = 3
 * Output : 4
 * <p>
 * Explanation
 * {1}, {2}, {3} : all single
 * {1}, {2, 3} : 2 and 3 paired but 1 is single.
 * {1, 2}, {3} : 1 and 2 are paired but 3 is single.
 * {1, 3}, {2} : 1 and 3 are paired but 2 is single.
 * Note that {1, 2} and {2, 1} are considered same.
 * <p>
 * <p>
 * SOLUTION
 * <p>
 * Consider Combination in the following relationship
 * <p>
 * Cn,1 + Cn-1,2 + Cn-2, 3 ....+ C1, n
 * <p>
 * All are single. {x1, x2, ... , xn}
 * x1 is single , others are paired contiguously(if n is odd). {x1, (x2, x3), ...}
 * So on. So if we try to figure out a formula then to observe that.
 * For any xi
 * xi can be kept single
 * xi can be paired with any other xj provided i≠j
 * Let f(n)= number of ways to pair for input N
 * <p>
 * Considering the above two facts about xi
 * <p>
 * If xn is kept single then f(n) = f(n-1) (same as number of ways excluding xn)
 * If xn is paired with any other friend then f(n)=(n-1)*f(n-2) (number of ways xn can be paired * sub-problem excluding xn and the paired one with it)
 */
public class FriendsParing {
    public static void main(String[] args) {
        System.out.println(countFriendsPairings(3));

    }

//    private static int countFriendsPairings(int N) {
//        if (N < 2) return 1;
//        return countFriendsPairings(N);
//    }

    private static int countFriendsPairings(int N) {
        if (N < 2) return 1;

        int count = 0;

        count = countFriendsPairings(N - 1) + (N - 1) * countFriendsPairings(N - 2);
        return count;
    }
}
