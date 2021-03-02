package LEETCODE.arrays;

/**
 * 657. Robot Return to Origin
 * Easy
 * <p>
 * 1217
 * <p>
 * 689
 * <p>
 * Add to List
 * <p>
 * Share
 * There is a robot starting at position (0, 0), the origin, on a 2D plane. Given a sequence of its moves, judge if this robot ends up at (0, 0) after it completes its moves.
 * <p>
 * The move sequence is represented by a string, and the character moves[i] represents its ith move. Valid moves are R (right), L (left), U (up), and D (down). If the robot returns to the origin after it finishes all of its moves, return true. Otherwise, return false.
 * <p>
 * Note: The way that the robot is "facing" is irrelevant. "R" will always make the robot move to the right once, "L" will always make it move left, etc. Also, assume that the magnitude of the robot's movement is the same for each move.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: moves = "UD"
 * Output: true
 * Explanation: The robot moves up once, and then down once. All moves have the same magnitude, so it ended up at the origin where it started. Therefore, we return true.
 * Example 2:
 * <p>
 * Input: moves = "LL"
 * Output: false
 * Explanation: The robot moves left twice. It ends up two "moves" to the left of the origin. We return false because it is not at the origin at the end of its moves.
 * Example 3:
 * <p>
 * Input: moves = "RRDD"
 * Output: false
 * Example 4:
 * <p>
 * Input: moves = "LDRRLRUULR"
 * Output: false
 */
public class RobotReturnsToOrigin {
    public static void main(String[] args) {

        System.out.println(judgeCircle("UD"));
        System.out.println(judgeCircle("RRDD"));
        System.out.println(judgeCircle("LDLDRRUU"));
        System.out.println(judgeCircle("LDRRLRUULR"));
    }

    private static boolean judgeCircle(String moves) {
        int N = moves.length();
        if (N == 0) return true;
        if (N == 1) return false;

        int left = 0, up = 0, down = 0, right = 0;

        for (char move : moves.toCharArray()) {
            if (move == 'U') up++;
            else if (move == 'D') down++;
            else if (move == 'L') left++;
            else right++;
        }

        return (left == right && up == down);
    }
}
