import java.io.*;
import java.util.*;

/*
  Write a solution to the Selection Sort.
 */
class Solution {
    // 3, 2, 1, 10, 5, 8, 2, 1
    public static int[] selectionSort(int values[]) {
        for (int i = 0; i < values.length; i++) {
            int lowestIndex = i;
            for (int j = i; j < values.length; j++) {
                if (values[lowestIndex] > values[j]) {
                    lowestIndex = j;
                }
            }
            int temp = values[i];
            values[i] = values[lowestIndex];
            values[lowestIndex] = temp;
        }
        return values;
    }

    public static void main(String args[]) {
        int result[] = selectionSort(new int[] { 3, 2, 1, 10, 5, 8, 2, 1 });

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
