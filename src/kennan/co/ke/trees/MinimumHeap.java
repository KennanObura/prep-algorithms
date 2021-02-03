package kennan.co.ke.trees;

public class MinimumHeap {
    private final Heap heap;
    private int size;

    MinimumHeap(Heap heap) {
        this.heap = heap;
        this.size = 0;
    }

    void add(int value) {
        if (isCapacityReached()) throw new RuntimeException("Capacity reached");
        //add to last
        heap.nodes[size] = value;
        size++;
        heapifyUp(size - 1);

    }

    private void heapifyUp(int i) {
        int parentIndex = getParentIndex(i);

        while (parentIndex > -1 && heap.nodes[parentIndex] > heap.nodes[i]) {
            heap.nodes[parentIndex] = swap(heap.nodes[i], heap.nodes[i] = heap.nodes[parentIndex]);
            i = parentIndex;
            parentIndex = getParentIndex(parentIndex);
        }
    }

    private int getParentIndex(int i) {
        return (i - 1) / 2;
    }

    private int swap(int node, int i) {
        return node;
    }

    private boolean isCapacityReached() {
        return size == heap.CAPACITY;
    }

    int remove() {
        if (size < 1) throw new RuntimeException("No element to remove");
        int value = heap.nodes[size - 1];
        heap.nodes[0] = value;
        size--;
        heapifyDown(0);
        return value;
    }

    private void heapifyDown(int i) {
        int minChildIndex = getMinimumChild(i);
        while (minChildIndex < size && heap.nodes[minChildIndex] < heap.nodes[i]) {
            heap.nodes[i] = swap(heap.nodes[minChildIndex], heap.nodes[minChildIndex] = heap.nodes[i]);
            i = minChildIndex;
            minChildIndex = getMinimumChild(i);
        }

    }

    private int getMinimumChild(int i) {
        return Math.min(getLeftChild(i), getRightChild(i));
    }

    private int getLeftChild(int i) {
        return 2 * i + 1;
    }

    private int getRightChild(int i) {
        return 2 * i + 2;
    }
}

class Heap {
    final int CAPACITY;
    final int[] nodes;

    Heap(int capacity) {
        this.CAPACITY = capacity;
        this.nodes = new int[CAPACITY];
    }
}
