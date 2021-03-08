package CTCI.Moderate;

import java.util.Random;

/**
 * Rand7 from RandS: Implement a method rand7() given rand5 (). That is, given a method that
 * generates a random number between 0 and 4 (inclusive), write a method that generates a random
 * number between 0 and 6 (inclusive).
 */
public class Rand7 {
    public static void main(String[] args) {

        System.out.println(rand());
    }

    private static int rand(){
        Random random = new Random(4);
        int random5 = random.nextInt();
        while (true){
           int rand = 5 * random5 + random5;
            if (rand < 21){
                return rand % 7;
            }
        }
    }
}
