package HACKERRANK;

import java.util.*;

public class ManasaAndStones {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(stones(3, 1, 2)));
        System.out.println(Arrays.toString(stonesII(3, 1, 2)));

    }

    static int[] stones(int n, int a, int b) {

        int dif = b-a;

        int min = a*(n-1);
        int max = b*(n-1);
        ArrayList<Integer> resultSet = new ArrayList<>();
        while (min <= max){
            resultSet.add(min);
            min+=dif;
        }

        int [] result = resultSet.stream().mapToInt(Integer::intValue).toArray();

        return result;
    }

    static int[] stonesII(int n, int a, int b) {
        ArrayList<Integer> ar = new ArrayList();
        HashSet<Integer> hs = new HashSet();
        for(int i=0; i<n; i++){
            int temp = (n-1-i)*a + i*b;
            if(!hs.contains(temp)) ar.add(temp); // to avoid duplicates
            hs.add(temp);
        }
        int res[]= new int[ar.size()];
        Collections.sort(ar);
        int i = 0;
        for(int val: ar) res[i++] = val;
        return res;
    }


}
