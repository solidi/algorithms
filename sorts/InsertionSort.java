import java.io.*;
import java.util.*;

/*
  Write a solution to the Insertion Sort.
 */
class Solution {
    public static int[] insertionSort(int values[]) {
        for (int i = 1; i < values.length; i++) {
            int insert = values[i];
            int j = i;
            while ((j > 0) && values[j - 1] > insert) {
                values[j] = values[j - 1];
                j--;
            }
            values[j] = insert;
        }
        return values;
    }

    public static void main(String args[]) {
        int result[] = insertionSort(new int[] { 3, 2, 1, 10, 5, 8, 2, 1 });

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
