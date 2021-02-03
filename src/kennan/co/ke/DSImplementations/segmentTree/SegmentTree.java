package kennan.co.ke.DSImplementations.segmentTree;



public class SegmentTree<T> {

    private final T[] actualElements;
    private final SegmentTreeNode<T>[] heap;
    private final int END_INDEX;

    public SegmentTree(T[] elements) {
        this.actualElements = elements;

        this.END_INDEX = elements.length - 1;
        int LENGTH = elements.length;

        int height = (int) Math.ceil(Math.log(LENGTH) / Math.log(2));
        int maxSize = 2 * (int) Math.pow(2, height) - 1;
        this.heap = new SegmentTreeNode[maxSize];

        build();
    }

    private void build() {
        /*
         * - Build tree recursively starting from the root down to leaves
         * - Divide /Reduce length/size by dividing the array by half on each call
         * - Process for both , left and right subtrees, inserting on current position @current
         * - @current : calculated by i*2 +1 for left child, i*2+2 for right child
         * - baseCase : when we reach a single node, start == end
         */
        int currentIndex = 0;
        int START_INDEX = 0;
        build(START_INDEX, END_INDEX, currentIndex);

    }

    private SegmentTreeNode<T> build(int start_index, int end_index, int currentIndex) {
        if (start_index > end_index) return null;
        if (start_index == end_index) {
            heap[currentIndex] = assignInitialNode(new SegmentTreeNode<>(), start_index);
            return heap[currentIndex];
        }


        int mid = getMidOfList(start_index, end_index);
        int leftIndex = getLeftIndex(currentIndex);
        int rightIndex = getRightIndex(currentIndex);


        SegmentTreeNode<T> leftSubTree = build(start_index, mid, leftIndex);
        SegmentTreeNode<T> rightSubTree = build(mid + 1, end_index, rightIndex);
        heap[currentIndex] = processNode(leftSubTree, rightSubTree);
        return heap[currentIndex];
    }

    private SegmentTreeNode<T> processNode(SegmentTreeNode<T> leftSubTree, SegmentTreeNode<T> rightSubTree) {
        SegmentTreeNode<T> temp = new SegmentTreeNode<>();
        temp.setSum(leftSubTree.getSum() + rightSubTree.getSum());
        temp.setMinimum(Math.min(leftSubTree.getMinimum(), rightSubTree.getMinimum()));
        temp.setMaximum(Math.max(leftSubTree.getMaximum(), rightSubTree.getMaximum()));
        return temp;
    }

    private int getRightIndex(int currentIndex) {
        return 2 * currentIndex + 2;
    }

    private int getLeftIndex(int currentIndex) {
        return 2 * currentIndex + 1;
    }

    private int getMidOfList(int start_index, int end_index) {
        return start_index + (end_index - start_index) / 2;
    }

    private SegmentTreeNode<T> assignInitialNode(SegmentTreeNode<T> node, int start_index) {
        node.setSum((Integer) actualElements[start_index]);
        node.setMinimum((Integer) actualElements[start_index]);
        node.setMaximum((Integer) actualElements[start_index]);
        return node;
    }

    private void print() {
        for (SegmentTreeNode<T> item : heap)
            System.out.println(item);
    }


    public static void main(String[] args) {
        Integer[] elements = {1, 3, 5, 7, 9, 11};
        Integer [] elements2 = {2, 6, 4, 3, 5, -1, 6, 10};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(elements2);
        segmentTree.print();

    }
}

