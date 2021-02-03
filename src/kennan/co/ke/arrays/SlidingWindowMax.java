package kennan.co.ke.arrays;

import java.util.Arrays;

public class SlidingWindowMax {
    public static void main(String[] args) {

        int[] arr = {2, 6, -1, 2, 4, 1, -6, 5};

        SegmentTree segmentTree = new SegmentTree(arr.length);

        segmentTree.build(arr);
        segmentTree.query(arr, 3);
        segmentTree.printTree();
    }

    private static class SegmentTree {
        final int size;
        final int[] tree;
        final int height;
        final int maxSize;
        final int START = 0;
        final int END;


        SegmentTree(int size) {
            this.size = size;
            this.height = (int) Math.ceil(Math.log(size) / Math.log(2));
            this.maxSize = 2 * (int) Math.pow(2, height) - 1;
            this.tree = new int[maxSize];
            this.END = size - 1;
        }


        void build(int[] elements) {
            build(elements, START, END, 0);
        }

        void query(int[] elements, int k) {
            for (int i = 0; i < elements.length - k; i++)
                System.out.println(query(i, START, END, 0, i + k - 1));
        }

        private int build(int[] elements, int start, int end, int current) {

            if (start == end) {
                tree[current] = elements[end];
                return tree[current];
            }
            int mid = getMidElement(start, end);
            tree[current] = Math.max(build(elements, start, mid, getLeftChild(current)),
                    build(elements, mid + 1, end, getRightChild(current)));
            return tree[current];
        }

        private int getLeftChild(int current) {
            return 2 * current + 1;
        }

        private int getRightChild(int current) {
            return 2 * current + 2;
        }

        private int getMidElement(int start, int end) {
            return start + (end - start) / 2;
        }


        private int query(int index, int start, int end, int queryStart, int queryEnd) {
            if (start > queryEnd || end < queryStart) return Integer.MIN_VALUE;

            else if (start >= queryStart && end <= queryEnd) return tree[index];

            else {
                int mid = getMidElement(start, end);
                return Math.max(query(getLeftChild(index), start, mid, queryStart, queryEnd),
                        query(getRightChild(index), start, mid + 1, queryStart, queryEnd));
            }
        }

        private void printTree() {
            System.out.println(Arrays.toString(tree));
        }
    }
}
