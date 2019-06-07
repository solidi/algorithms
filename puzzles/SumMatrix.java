import java.io.*;
import java.util.*;

/**
 * Given the following matrix, sum up the value of the entire array. int
 * matrix[][][] = new int[][][] { {{1,0,0,0,0}, {1,0,0,0,0}}, {{1,0,0,0,0},
 * {1,0,0,0,1}, {1,0,0,0,1}} };
 *
 * Sum = 7
 */
class Solution {
    public static int sumMatrix(int matrix[][][]) {
        int sum = 0;

        for (int page = 0; page < matrix.length; page++) {
            for (int row = 0; row < matrix[page].length; row++) {
                for (int col = 0; col < matrix[page][row].length; col++) {
                    if (matrix[page][row][col] > 0) {
                        sum++;
                    }
                }
            }
        }

        return sum;
    }

    public static void main(String args[]) {
        int matrix[][][] = new int[][][] { { { 1, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0 } },
                { { 1, 0, 0, 0, 0 }, { 1, 0, 0, 0, 1 }, { 1, 0, 0, 0, 1 } } };

        System.out.println(sumMatrix(matrix));
    }
}
