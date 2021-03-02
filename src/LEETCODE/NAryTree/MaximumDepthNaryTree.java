package LEETCODE.NAryTree;

import LEETCODE.NAryTree.treeclass.Node;

import java.util.Arrays;
import java.util.List;

/**
 * 559. Maximum Depth of N-ary Tree
 * Easy
 * <p>
 * Given a n-ary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p>
 * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: 3
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: 5
 */
public class MaximumDepthNaryTree {
    public static void main(String[] args) {

        Node two = new Node(2);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node three = new Node(3, Arrays.asList(five, six));
        Node root = new Node(1, Arrays.asList(three, two, four));

        System.out.println(maxDepth(root));
    }

    private static int maxDepth(Node root) {
        if (root == null) return 0;

        int height = 0;


        for (Node child : root.children) {
            height = Math.max(maxDepth(child), height);
        }

        return height + 1;

    }
}
