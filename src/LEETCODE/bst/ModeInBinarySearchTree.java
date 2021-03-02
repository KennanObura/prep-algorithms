package LEETCODE.bst;

import LEETCODE.tree.treeclass.TreeNode;

import java.util.*;

/*
501. Find Mode in Binary Search Tree
Easy

1232

401

Add to List

Share
Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.


For example:
Given BST [1,null,2,2],

   1
    \
     2
    /
   2


return [2].

Note: If a tree has more than one mode, you can return them in any order.
 */
public class ModeInBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(2);

        root.right = new TreeNode(2);
        root.right.right = new TreeNode(9);
        root.right.right.right = new TreeNode(10);
        root.right.right.left = new TreeNode(9);


        System.out.println(findMode(root));
    }


    public static List<Integer> findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();

        findMode(root, map);

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1).compareTo(map.get(o2))*-1;
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(entry.getKey());
            System.out.println(entry.getKey() + "|" + entry.getValue());
        }

        List<Integer> result = new ArrayList<>();

        System.out.println(queue);

        int first = queue.poll();
        result.add(first);

        while (!queue.isEmpty() && first == queue.peek())
            result.add(queue.poll());

        return result;
    }

    private static void findMode(TreeNode root, HashMap<Integer, Integer> map) {
        if (root == null) return;

        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        findMode(root.left, map);
        findMode(root.right, map);
    }
}
