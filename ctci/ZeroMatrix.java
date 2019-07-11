import java.io.*;
import java.util.*;

/**
 * Zero Matrix: Write an algorithm such that if an element in an MxN matrix is
 * 0, its enitre row and column are set to zero.
 **/
class Solution {

    public static class Pair {
        public int row;
        public int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static ArrayList<Pair> search(int matrix[][]) {
        ArrayList<Pair> pair = new ArrayList<Pair>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    pair.add(new Pair(row, col));
                }
            }
        }

        return pair;
    }

    public static int[][] zeroOut(int matrix[][], int rowZ, int colZ) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (rowZ == row || colZ == col) {
                    matrix[row][col] = 0;
                }
            }
        }

        return matrix;
    }

    public static void print(int matrix[][]) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int matrix[][] = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 1 }, { 1, 1, 1, 1 },
                { 1, 1, 1, 1 }, };
        print(matrix);
        ArrayList<Pair> pair = search(matrix);
        for (Pair p : pair) {
            zeroOut(matrix, p.row, p.col);
        }
        print(matrix);
    }
}
