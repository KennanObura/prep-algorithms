package ONAINTERVIEW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WordChain {
    public static void main(String[] args) throws IOException {

//        String[] words = {"snakes", "seldom", "munch", "on", "north", "highland", "ducks",};
//        String[] word2 = {"the", "eagle", "eats", "snake"};

//        System.out.println(wordChain(word2));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine()); //Length of Array
        String s= br.readLine(); //Input the number seperated by space
//        String[] arr= new int[num];
        String[] s1 = s.split(" ");
//        for(int i=0;i<num;i++)
//        {
//            arr[i] = s1[i];
//        }

        System.out.println(wordChain(s1));
    }




    private static int wordChain(String[] words) {
        if (words.length < 2) return words.length;

        int max = Integer.MIN_VALUE;
        int maxSoFar = 1;

        /**
         *
         * In the last test example with words snakes
         * seldom
         * munch
         * on
         * north
         * highland
         * ducks
         *
         * The Out put as per example is 3, yet sequence on, north, highland, ducks form a valid sequence resulting to 4
         */

        for (int i = 1; i < words.length; i++) {
            if (words[i].charAt(0) == words[i - 1].charAt(words[i - 1].length() - 1)) {
                maxSoFar++;
                max = Math.max(max, maxSoFar);
            } else
                maxSoFar = 1;
        }

        return max;

    }
}
