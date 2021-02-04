package GEEKFORGEEKS.dynamicPrograming;

public class HighwayBillboardProblem {
    public static void main(String[] args) {

        int M = 20;
        int[] x = {6, 7, 12, 13, 14};
        int[] revenue = {5, 6, 5, 3, 1};
        int t = 5;


        int M1 = 15;
        int x1[] = {6, 9, 12, 14};
        int revenue1[] = {5, 6, 3, 7};
        int t1 = 2;

        System.out.println(maximizeRevenue(M, x, revenue, t));
        System.out.println(maximizeRevenue(M1, x1, revenue1, t1));

    }

    private static int maximizeRevenue(int m, int[] x, int[] revenue, int t) {
        int N = revenue.length - 1;
        return maximizeRevenue(m, x, revenue, t, 0, 0);
    }

    private static int maximizeRevenue(int m, int[] x, int[] revenue, int t, int index, int prev) {

        if (index >= x.length || x[index] > m) return 0;

        if (t + prev >= x[index])
            return maximizeRevenue(m, x, revenue, t, index + 1, prev);

        int include = maximizeRevenue(m, x, revenue, t, index + 1, x[index]) + revenue[index];

        int notInclude = maximizeRevenue(m, x, revenue, t, index + 1, prev);

        return Math.max(include, notInclude);
    }
}
