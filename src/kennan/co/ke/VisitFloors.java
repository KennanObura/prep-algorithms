package kennan.co.ke;

import java.util.Arrays;

public class VisitFloors {
    public static void main(String[] args) {

        System.out.println(play(30, 5));

    }


    private static int play(int classrooms, int rounds) {
        if (rounds < 1) return 0; // move not possible
        
        /*
        Create two boolean arrays of size classroom to represent classes
        
        for round = 1 ... rounds
            if round is odd
                visit floorOne
            otherwise
                visit floortwo
        */
        boolean[] floorOne = new boolean[classrooms];
        boolean[] floorTwo = new boolean[classrooms];
        closeAllDoors(floorOne); // close all doors by setting entries false. Not necessary in java if using primitive bool
        closeAllDoors(floorTwo);

        for (int i = 1; i <= rounds; i++) {
            if ((i & 1) == 1)
                visitFloor(floorOne, i);
            else
                visitFloor(floorTwo, i);

        }

        return getNumberOfDoorsOpen(floorOne, floorTwo);
    }


    private static void closeAllDoors(boolean[] floor) {
        Arrays.fill(floor, false);
    }

    /*
    Return the sum  of doors open in floor1 and doors open in floor2
     */
    private static int getNumberOfDoorsOpen(boolean[] floorOne, boolean[] floorTwo) {

        return getNumberOfDoorsOpenUtil(floorOne, "First floor")
                + getNumberOfDoorsOpenUtil(floorTwo, "First floor");
    }


    /**
     *
     * This method takes in
     *
     * @param floor boolean array representing a floor
     * @param skip the number of skips in that particular round
     *             Actually, Skip equals to round
     *             For example
     *             in round one, skip every one door
     *             in round two, skip every two doors
     *             in round three, skip every three doors
     */

    private static void visitFloor(boolean[] floor, int skip) {
        int N = floor.length;
        int i = skip; // he skips the first (skip) doors

        while (i < N) {
            floor[i] = !floor[i]; //close if open, and open if closed
            i += (skip + 1); //skip every skip times eg 2
        }
    }

    /**
     *
     * @param floor boolean array representing floor
     * @param name String name of floor eg First floor
     * @return no of doors open in that @floor
     * Also prints down the floors that remain open (open = true)
     */
    private static int getNumberOfDoorsOpenUtil(boolean[] floor, String name) {
        int count = 0;
        /*
        Run through a given floor and count where value is true;
         */
        System.out.print(name + ":");

        for (int i = 0; i < floor.length; i++)
            if (floor[i]) {
                count++;
                System.out.print("Door" + (i + 1) + " ");
            }


        System.out.println();
        return count;
    }
}

