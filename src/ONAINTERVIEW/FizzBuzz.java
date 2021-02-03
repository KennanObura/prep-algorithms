package ONAINTERVIEW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * You are given an integer N, followed by N lines of input (1 <= N <= 100). Each line of input contains one number M.
 * <p>
 * Write a program that goes through the numbers from 1 to M (1 <= M <= 100) and prints out the following:
 * <p>
 * For numbers which are multiples of three print "Ona".
 * For numbers which are the multiples of five print "Data".
 * For numbers which are multiples of both three and five print "OnaData".
 * If the conditions above fail for all numbers, print "N/A".
 * Example
 */
public class FizzBuzz {
    public static void main(String[] args) throws IOException {
//        fizzBuzz(4);
//        fizzBuzz(10);
//        fizzBuzz(15);
//        fizzBuzz(15);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String input = br.readLine();
//        int num = Integer.parseInt(input);
//        String s = br.readLine(); //Input the number seperated by space
//        int[] arr = new int[num];
//        String[] s1 = s.split(" ");
//        for (int i = 0; i < num; i++) {
//            arr[i] = Integer.parseInt(s1[i]);
//        }


        System.out.println(timeTaken(1000, 60, 20));
    }

//    private static void fizzBuzz(int[] nums) {
//        for (int n : nums) {
//            if (n < 2) System.out.print("N/A");
//            for (int i = 2; i <= n; i++) {
//
//                if (i % 5 == 0 && i % 3 == 0)
//                    System.out.print("OnaData ");
//                else if (i % 3 == 0)
//                    System.out.print("Ona ");
//                else if (i % 5 == 0)
//                    System.out.print("Data ");
//
//            }
//            System.out.println();
//        }
//    }


    private static double timeTaken(int size, int speed, int rate){
        return (int) size/speed + (size*(rate/100))/10 + (size*(rate/100))/speed;
//        return 1000/60 + 1000*0.2/10 + 1000*0.2/60;
    }
}
