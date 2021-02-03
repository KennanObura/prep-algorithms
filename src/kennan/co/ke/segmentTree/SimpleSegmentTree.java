package kennan.co.ke.segmentTree;

import java.util.Arrays;

public class SimpleSegmentTree {
    public static void main(String[] args) {
        int[] elements = {1, 3, 5, 7, 9, 11};
        int [] elements2 = {2, 6, 4, 3};

        Tree tree = new Tree(elements2.length);

        tree.build(elements2);
        tree.printTree();

    }

    private static class Tree {
        private int[] tree;
        private int maxSize;
        private int size;
        private int height;

        private Tree(int size) {
            this.size = size;
            this.height = (int) Math.ceil(Math.log(size) / Math.log(2));
            this.maxSize = 2 * (int) Math.pow(2, height) - 1;
            this.tree = new int[maxSize];
        }

        void build(int[] elements) {
            build(elements, 0, size - 1, 0);

        }

        private int build(int[] elements, int start, int end, int current) {
            if (start == end) {
                tree[current] = elements[start];
                return tree[current];
            }

            int mid = getMidOfElements(start, end);

            tree[current] = build(elements, start, mid, getLeftNode(current))
                    + build(elements, mid + 1, end, getRightNode(current));
            return tree[current];
        }

        private int getRightNode(int current) {
            return 2 * current + 2;
        }

        private int getLeftNode(int current) {
            return 2 * current + 1;
        }

        private int getMidOfElements(int start, int end) {
            return start + (end - start) / 2;
        }

        private void printTree() {
            System.out.println(Arrays.toString(tree));
        }
    }
}
