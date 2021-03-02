package LEETCODE.bst;
/*
501. Find Mode in Binary Search Tree
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
 */

import LEETCODE.tree.treeclass.TreeNode;

import java.util.*;

public class FindModeInBinarySearchTree {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.right.right = new TreeNode(2);
        root.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(6);

       System.out.println(Arrays.toString(findMode(root)));

    }

    private static int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();

        doInOrderTraversal(root, map);

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2) - map.get(o1);
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            queue.add(entry.getKey());

        ArrayList<Integer> arrayList = new ArrayList<>();

        if (queue.isEmpty()) return new int[0];

        int peek = queue.poll();
        arrayList.add(peek);

        while (!queue.isEmpty() && map.get(peek).equals(map.get(queue.peek())))
            arrayList.add(queue.poll());

        int[] result = new int[arrayList.size()];
        int i = 0;
        for (int k : arrayList)
            result[i++] = k;
        return result;

    }

    private static void doInOrderTraversal(TreeNode root, Map<Integer, Integer> result) {
        if (root == null) return;

        doInOrderTraversal(root.left, result);
        result.put(root.val, result.getOrDefault(root.val, 0) + 1);
        doInOrderTraversal(root.right, result);
    }
}
