package CTCI.Moderate;

import java.util.ArrayList;

public class DivingBoard {
    public static void main(String[] args) {
        possibleLengths(new int []{2,1}, 3, 0);
    }

    private static void possibleLengths(int [] plunks, int k, int length){

        if(k < 0) return;

        if(k == 0){
            System.out.println(length);
            return;
        }

        possibleLengths(plunks, k-1, length+plunks[0]);

        possibleLengths(plunks, k-1, length+plunks[1]);

    }
}
