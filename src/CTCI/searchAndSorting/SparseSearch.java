package CTCI.searchAndSorting;

/**
 * Given a sorted array of strings that is interspersed with empty strings, write a
 * method to find the location of a given string.
 * <p>
 * Example :
 * input: ball
 * {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
 */

public class SparseSearch {
    public static void main(String[] args) {
        String input = "ball";
        String[] sparse = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};

        System.out.print(sparseSearch(input, sparse));

    }

    private static int sparseSearch(String input, String[] sparse) {

        int N = sparse.length;

        int start = 0, end = N - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            int closerIndex = getCloserIndex(mid, sparse, start, end);
            if (closerIndex == -1) return -1;
            else mid = closerIndex;

            int compares = input.compareTo(sparse[mid]);

            if (compares == 0) return mid;
            if (compares > 0) end = mid - 1;
            else start = mid + 1;

        }
        return -1;
    }

    private static int getCloserIndex(int mid, String[] sparse, int start, int end) {

        int i = mid;
        int j = mid;
        int result = -1;

        while (i > start && j <= end) {
            if (!sparse[i].isEmpty()) {
                result = i;
                break;
            }
//            if (!sparse[j].isEmpty()) {
//                result = j;
//                break;
//            }

            j++;
            i--;

        }
        return result;
    }
}
