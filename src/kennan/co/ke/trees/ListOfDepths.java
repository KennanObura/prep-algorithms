package kennan.co.ke.trees;

import kennan.co.ke.trees.base.BinaryTree;
import kennan.co.ke.trees.base.BinaryTreeNode;

import java.util.*;

/**
 * Objective: Given a Binary tree create Linked Lists of all the nodes at each depth ,
 * say if the tree has height k then create k linked lists.
 */

public class ListOfDepths {


    public static void main(String[] args) {
        Integer[] items = {2, 3, 5, 6, 8, 10, 33, 89, 100};
        BinaryTree<Integer> binaryTree = new BinaryTree<>(items);

        BinaryTreeNode<Integer> root = binaryTree.getRoot();
        breadthFirstSearch(root);
        depthFirstSearch(root);
    }

    private static void depthFirstSearch(BinaryTreeNode<Integer> root) {
        depthFirstSearch(root, 0, new LinkedList<>());

        System.out.println("DFS AND Using map" + mapOfDepth.size());

        for (Map.Entry<Integer, LinkedList<BinaryTreeNode<Integer>>> entry : mapOfDepth.entrySet()) {
            for (BinaryTreeNode<Integer> item : entry.getValue())
                System.out.print(item.value + "->");
            System.out.println();
        }
    }

    private static final Map<Integer, LinkedList<BinaryTreeNode<Integer>>> mapOfDepth = new HashMap<>();

    private static void depthFirstSearch(BinaryTreeNode<Integer> root, int level, LinkedList<BinaryTreeNode<Integer>> list) {
        if (root == null) {
            if (!mapOfDepth.containsKey(level)) mapOfDepth.put(level, list);

            for(BinaryTreeNode<Integer> item: list)
                System.out.print(item.value + "-");
            System.out.println();
            return;
        }


        list.addFirst(root);
        level++;
        depthFirstSearch(root.left, level, list);

        depthFirstSearch(root.right, level, list);

        list.remove(list.size() - 1);

    }


    private static void breadthFirstSearch(BinaryTreeNode<Integer> root) {
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();

        List<LinkedList<BinaryTreeNode<Integer>>> result = new ArrayList<>();
        Map<Integer, LinkedList<BinaryTreeNode<Integer>>> map = new HashMap<>();

        queue.add(root);

        LinkedList<BinaryTreeNode<Integer>> list;

        int level = 1;
        while (!queue.isEmpty()) {
            int currentQueueCount = queue.size();
            list = new LinkedList<>();


            for (int i = 0; i < currentQueueCount; i++) {

                BinaryTreeNode<Integer> temp = queue.remove();
//                System.out.println(temp.value + "is at Level " + level);
                list.add(temp);

                if (temp.left != null)
                    queue.add(temp.left);


                if (temp.right != null)
                    queue.add(temp.right);

            }
            result.add(list);
            if (!map.containsKey(level)) map.put(level, list);
            level++;

        }

        System.out.println(result.size() + " size");

        for (LinkedList<BinaryTreeNode<Integer>> res : result) {
            for (BinaryTreeNode<Integer> item : res)
                System.out.print(item.value + "->");
            System.out.println();
        }

        System.out.println("Using map");
        for (Map.Entry<Integer, LinkedList<BinaryTreeNode<Integer>>> entry : map.entrySet()) {
            for (BinaryTreeNode<Integer> item : entry.getValue())
                System.out.print(item.value + "->");
            System.out.println();
        }


    }

}
