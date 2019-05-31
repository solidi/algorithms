import java.io.*;
import java.util.*;

/*
 Find the number of islands, not diangles.

 Input : mat[][] = {{1, 1, 0, 0, 0},
                   {0, 1, 0, 0, 1},
                   {1, 0, 0, 1, 1},
                   {0, 0, 0, 0, 0},
                   {1, 0, 1, 0, 1}}
  Output : 6
 */
class Solution {

    // check point
    // check point left and right
    // mark visited spot
    public static boolean checkIsland(int mat[][], int row, int col) {
        boolean island = false;

        if (mat[row][col] == 1) {
            mat[row][col] = 2;
            island = true;

            // check right
            if (col + 1 < mat[row].length && mat[row][col + 1] == 1) {
                checkIsland(mat, row, col + 1);
            }

            // check left
            if (col - 1 >= 0 && mat[row][col - 1] == 1) {
                checkIsland(mat, row, col - 1);
            }

            // check up
            if (row - 1 >= 0 && mat[row - 1][col] == 1) {
                checkIsland(mat, row - 1, col);
            }

            // check down
            if (row + 1 < mat.length && mat[row + 1][col] == 1) {
                checkIsland(mat, row + 1, col);
            }
        }

        return island;
    }

    public static int countIslands(int mat[][]) {
        int islandCount = 0;

        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[row].length; col++) {
                if (checkIsland(mat, row, col)) {
                    islandCount++;
                }
            }
        }

        return islandCount;
    }

    public static void main(String args[]) {
        int mat[][] = { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 }, { 1, 0, 1, 0, 1 } };
        System.out.println(countIslands(mat));
    }
}
