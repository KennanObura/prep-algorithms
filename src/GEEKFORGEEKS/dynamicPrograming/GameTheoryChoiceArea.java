package GEEKFORGEEKS.dynamicPrograming;

import java.lang.reflect.Array;
import java.util.Arrays;

public class GameTheoryChoiceArea {
    public static void main(String[] args) {
        Area[] areas = {
                new Area(3, 2),
                new Area(-5, -10),
                new Area(-20, 5),
        };

        int powerA = 20;
        int powerB = 8;
//        System.out.println(areas.length);
        System.out.println(maxSurvivalTime(powerA, powerB, areas));

    }

    private static int maxSurvivalTime(int powerA, int powerB, Area[] areas) {
        if (powerA <= 0 || powerB <= 0) return 0;


        System.out.println(powerA + " "+ powerB);
        int choosingX = maxSurvivalTime(powerA + 2, powerB + 3, areas) + 1;
//        int choosingY = maxSurvivalTime(powerA -5, powerB -5, areas) + 1;
//        int choosingZ = maxSurvivalTime(powerA -20, powerB + 5, areas) + 1;

//        return Math.max(choosingX, Math.max(choosingY, choosingZ));
        return 1;
    }


    private static class Area {
        int pointA = 0;
        int pointB = 0;

        Area(int pointA, int pointB) {
            this.pointA = pointA;
            this.pointB = pointB;
        }
    }
}
