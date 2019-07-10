import java.io.*;
import java.util.*;

/**
 * Rotate Matrix: Given an image represented by an NxN matrix, where each pixel
 * in the image is 4 bytes, write a method to rotate the image by 90 degrees.
 * Can you do it in place?
 * 
 * {0, 0, 0} -> {0, 1, 0}
 * {1, 1, 1} -> {0, 1, 0}
 * {0, 0, 0} -> {0, 1, 0}
 * 
 * Incomplete.
 **/
class Solution {

    public static int[][] rotate90(int[][] imageMatrix) {
        int newMatrix[][] = new int[imageMatrix.length][imageMatrix.length];
        int length = imageMatrix.length - 1;
        int temp[] = new int[length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                temp[j] = imageMatrix[i][j];
            }

            if (i == 0) {
                for (int j = 0; j < length; j++) {
                    newMatrix[j][2] = temp[j];
                }
            }

            if (i == 1) {
                for (int j = 0; j < length; j++) {
                    newMatrix[j][2] = temp[j];
                }
            }
        }

        return newMatrix;
    }

    public static int[][] rotateTheirs(int[][] imageMatrix) {
        int length = imageMatrix.length;
        for (int layer = 0; layer < length / 2; layer++) {
            int first = layer;
            int last = length - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = imageMatrix[first][i];
                // left -> top
                imageMatrix[first][i] = imageMatrix[last - offset][first];
                // bottom -> left
                imageMatrix[last - offset][first] = imageMatrix[last][last - offset];
                // right -> bottom
                imageMatrix[last][last - offset] = imageMatrix[i][last];
                // top -> right
                imageMatrix[i][last] = top;
            }
        }

        return imageMatrix;
    }

    public static void printResult(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int matrix[][] = { { 0, 0, 0 }, { 1, 1, 1 }, { 0, 0, 0 } };

        printResult(matrix);
        int result[][] = rotateTheirs(matrix);
        printResult(result);
    }
}
