package java2blog.bst;


public class SortedArrayToBST {
    public static void main(String[] args) {

    }

    private static class Node {
        Node left;
        Node right;
        int value;

        Node(int value) {
            this.value = value;
        }
    }

    private static Node sortedToBinary(int[] nums) {
        return sortedToBinary(nums, 0, nums.length - 1);
    }

    private static Node sortedToBinary(int[] nums, int start, int end) {
        if (start <= end) {
            int mid = start + (end - start) / 2;

            Node head = new Node(nums[mid]);
            Node left = sortedToBinary(nums, start, mid-1);
            Node right = sortedToBinary(nums, mid+1, end);
            head.left = left;
            head.right = right;
            return head;
        }
        return null;
    }
}
