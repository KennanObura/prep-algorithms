package kennan.co.ke.arrays;

import java.util.Arrays;

public class AddToArray {
    public static void main(String[] args) {

        Object[] arr = {1, 2, 3};
        Object[] arrToBeAdded = {4, 5};

        Object[] newArray = Utils.append(arr, arrToBeAdded);
        System.out.println(Arrays.toString(newArray));

    }
}

class Utils {

    static Object[] append(Object[] array, Object... elements) {
        int N = array.length;

        Object[] temp = Arrays.copyOf(array, N + elements.length);
        System.arraycopy(elements, 0, temp, N, elements.length);

        return temp;

    }
}
