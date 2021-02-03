package kennan.co.ke.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a linked list with extra pointer, random which may point to any random node, clone list and return head
 * <p>
 * Solution
 * Maintain hash table
 * for nodes != null, put to map , node, and random as value
 * also connect node next nodes are they are
 * <p>
 * Traverse map, and update randoms
 */
public class CloneLinkedWithWithRandomPointers {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node1.random = node3;
        node2.random = node1;
        node3.random = node4;
        node4.random = node1;
        node5.random = node4;
        node6.random = node2;

        Node cloned = cloneList(node1);

//        printNode(cloned);

    }

    private static void printNode(Node cloned) {
        while (cloned != null) {
            System.out.println(cloned.value + " - " + cloned.random.value);
            cloned = cloned.next;
        }
    }

    private static Node cloneList(Node head) {
        if (head == null) return null;

        Map<Node, Node> map = new HashMap<>();
        Node current = head;
        Node cloneHead = null;
        Node cloneTail = null;


        while (current != null) {
            map.putIfAbsent(new Node(current.value), current.random);
            current = current.next;
        }





        for (Map.Entry<Node, Node> entry : map.entrySet()) {
            System.out.println(map.get(entry.getValue()).value);
            if (cloneHead == null) {
                cloneHead = entry.getKey();
                cloneTail = entry.getKey();
                cloneHead.random = map.get(entry.getValue());
            } else {
                cloneTail.next = entry.getKey();
                cloneTail.random = map.get(entry.getValue());
                cloneTail = cloneTail.next;
            }
//            cloneTail = cloneTail.next;
        }

        return cloneHead;
    }

    private static class Node {
        Node next, random;
        final int value;

        Node(int value) {
            this.value = value;
        }
    }


}
