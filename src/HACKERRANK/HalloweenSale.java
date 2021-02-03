package HACKERRANK;

public class HalloweenSale {
    public static void main(String[] args) {
        int p = 20;
        int d = 3;
        int m = 6;
        int s = 70;

        System.out.println(howManyGames(p, d, m, s));

    }

    static int howManyGames(int p, int d, int m, int s) {
        // Return the number of games you can buy
        int count = 0;

        while (s >= p){
            s -=p;
            p = Math.max(m, p-d);
            count++;
        }
        return count;
    }



    static int howManyGamesUtil(int p, int d, int m, int s) {


        if (s < p) return 0;



        System.out.println(p + " p-w " + s);

        s -= p;

        return howManyGamesUtil(p, d, m, s) + 1;
    }

}
