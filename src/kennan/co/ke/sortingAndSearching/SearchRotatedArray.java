package kennan.co.ke.sortingAndSearching;

public class SearchRotatedArray {
    public static void main(String[] args) {
        int[] elements = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
        int item = 5;
        int index = search(elements, item);
        System.out.println(index);
    }


    private static int search(int[] elements, int item) {
        return search(elements, item, 0, elements.length - 1);
    }

    /*
     * Perform a normal binary search
     * Case 1
     *  if item at start is less than item at mid, :: means the left side has a natural ordering
     *      figure out where item is from left side
     *          check range
     * Case II
     *  if item at mid is less that item at start :: right side has natural ordering
     *      figure out from right
     * Case III
     *  if item at left/right is equal to item at mid(all repeats) :: example[2,2,2,2,6,8,1]
     *      compare the mid item with the right most item and search to right
     *      otherwise search both sides;
     *
     */

    private static int search(int[] elements, int item, int start, int end) {
        if (start >= end) return -1;
        int mid = getMidIndex(start, end);
        if (elements[mid] == item) return mid;

        if (elements[start] < elements[mid]) { //left has natural ordering
            if (elements[start] < item && item <= elements[mid]) //check for range
                return search(elements, item, start, mid);
            else return search(elements, item, mid + 1, end);
        } else if (elements[start] > elements[mid]) { //right has natural ordering
            if (elements[mid] < item && item < elements[end])
                return search(elements, item, mid + 1, end);
            else return search(elements, item, start, mid);
        } else if (elements[start] == elements[mid]) { //all repeats
            if (elements[mid] != elements[end]) {
                return search(elements, item, mid + 1, end);
            } else {
                int result = search(elements, item, start, mid);
                if (result != -1)
                    return search(elements, item, mid + 1, end);
                return result;
            }

        }
        return -1;
    }

    private static int getMidIndex(int start, int end) {
        return start + (end - start) / 2;
    }

}
