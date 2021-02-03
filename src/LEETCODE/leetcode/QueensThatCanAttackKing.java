package LEETCODE.leetcode;

import java.util.*;

public class QueensThatCanAttackKing {
    public static void main(String[] args) {

        int[][] queens = {{0, 1}, {1, 0}, {4, 0}, {0, 4}, {3, 3}, {2, 4}};
        int[] king = {0, 0};


        int[][] queens2 = {{0, 0}, {1, 1}, {2, 2}, {3, 4}, {3, 5}, {4, 4}, {4, 5}};
        int[] king2 = {3, 3};


        int[][] queens3 = {{5, 6}, {7, 7}, {2, 1}, {0, 7}, {1, 6}, {5, 1}, {3, 7}, {0, 3}, {4, 0}, {1, 2}, {6, 3}, {5, 0}, {0, 4}, {2, 2}, {1, 1}, {6, 4},
                {5, 4}, {0, 0}, {2, 6}, {4, 5}, {5, 2}, {1, 4}, {7, 5}, {2, 3}, {0, 5}, {4, 2}, {1, 0}, {2, 7}, {0, 1}, {4, 6}, {6, 1}, {0, 6}, {4, 3}, {1, 7}};
        int[] king3 = {3, 4};
        Solution solution = new Solution();
//        List<List<Integer>> result = solution.queensAttacktheKing(queens, king);
//        List<List<Integer>> result = solution.queensAttacktheKing(queens2, king2);
        List<List<Integer>> result = solution.queensAttacktheKing(queens3, king3);

        for (List<Integer> array : result)
            System.out.println(Arrays.toString(array.toArray()));
    }


    private static class Solution {
        private final int LENGTH = 8;
        HashMap<Integer, LinkedList<Integer>> rowPositions = new HashMap<>();
        HashMap<Integer, LinkedList<Integer>> colPositions = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {

            for (int[] queen : queens) {


                if (!rowPositions.containsKey(queen[0])) {
                    LinkedList<Integer> set = new LinkedList<>();
                    set.add(queen[1]);
                    rowPositions.put(queen[0], set);
                } else {

                    LinkedList<Integer> list = rowPositions.get(queen[0]);
                    list.addLast(queen[1]);
                    rowPositions.put(queen[0], list);
                }


                if (!colPositions.containsKey(queen[1])) {
                    LinkedList<Integer> set = new LinkedList<>();
                    set.add(queen[0]);
                    colPositions.put(queen[1], set);
                } else {

                    LinkedList<Integer> list = colPositions.get(queen[1]);
                    list.addLast(queen[0]);
                    colPositions.put(queen[1], list);
                }
            }


            attackOnRow(king);


            attackOnCol(king);


            attackOnDiagonals(king);


            return result;

        }

        private void attackOnRow(int[] king) {
            int row = king[0];
            int col = king[1];



            while (col > -1) {
                if (rowPositions.containsKey(row)) {
                    LinkedList<Integer> setCol = rowPositions.get(row);
                    if (setCol.contains(col)) {
                        List<Integer> list = new ArrayList<>();
                        list.add(row);
                        list.add(col);
                        if (!result.contains(list))
                            result.add(list);
                        break;
                    }
                }
                col--;
            }


            col = king[1];
            while (col < LENGTH) {
                if (rowPositions.containsKey(row)) {
                    System.out.println(col);
                    LinkedList<Integer> setCol = rowPositions.get(row);
                    if (setCol.contains(col)) {
                        List<Integer> list = new ArrayList<>();
                        list.add(row);
                        list.add(col);
                        if (!result.contains(list))
                            result.add(list);
                        break;
                    }
                }
                col++;
            }

        }


        private void attackOnCol(int[] king) {
            int row = king[0];
            int col = king[1];



            while (row > -1) {
                if (colPositions.containsKey(col)) {
                    LinkedList<Integer> setCol = colPositions.get(col);
                    if (setCol.contains(row)) {
                        List<Integer> list = new ArrayList<>();
                        list.add(row);
                        list.add(col);
                        if (!result.contains(list))
                            result.add(list);
                        break;
                    }
                }
                row--;
            }


            row = king[0];
            while (row < LENGTH) {
                if (colPositions.containsKey(col)) {
                    LinkedList<Integer> setCol = colPositions.get(col);
                    if (setCol.contains(row)) {
                        List<Integer> list = new ArrayList<>();
                        list.add(row);
                        list.add(col);
                        if (!result.contains(list))
                            result.add(list);
                        break;
                    }
                }
                row++;
            }

        }


        private void attackOnDiagonals(int[] king) {
            int row = king[0];
            int col = king[1];



            // move towards left top
            while (row > -1 && col > -1) {
                if (colPositions.containsKey(col)) {
                    LinkedList<Integer> setCol = colPositions.get(col);
                    if (setCol.contains(row)) {
                        List<Integer> list = new ArrayList<>();
                        list.add(row);
                        list.add(col);
                        if (!result.contains(list))
                            result.add(list);
                        break;
                    }
                }
                row--;
                col--;
            }


            // move towards right top
            row = king[0];
            col = king[1];
            while (row > -1 && col < LENGTH) {
                if (colPositions.containsKey(col)) {
                    LinkedList<Integer> setCol = colPositions.get(col);
                    if (setCol.contains(row)) {
                        List<Integer> list = new ArrayList<>();
                        list.add(row);
                        list.add(col);
                        if (!result.contains(list))
                            result.add(list);
                        break;
                    }
                }
                row--;
                col++;
            }


            // move towards left down
            row = king[0];
            col = king[1];
            while (row < LENGTH && col > -1) {
                if (colPositions.containsKey(col)) {
                    LinkedList<Integer> setCol = colPositions.get(col);
                    if (setCol.contains(row)) {
                        List<Integer> list = new ArrayList<>();
                        list.add(row);
                        list.add(col);
                        if (!result.contains(list))
                            result.add(list);
                        break;
                    }
                }
                row++;
                col--;
            }


            // move towards left down
            row = king[0];
            col = king[1];
            while (row < LENGTH && col < LENGTH) {
                if (colPositions.containsKey(col)) {
                    LinkedList<Integer> setCol = colPositions.get(col);
                    if (setCol.contains(row)) {
                        List<Integer> list = new ArrayList<>();
                        list.add(row);
                        list.add(col);
                        if (!result.contains(list))
                            result.add(list);
                        break;
                    }
                }
                row++;
                col++;
            }
        }
    }
}

