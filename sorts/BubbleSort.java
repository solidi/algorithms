import java.io.*;
import java.util.*;

/*
  Write a solution to the Bubble Sort.
 */
class Solution {
    // 3, 2, 1, 10, 5, 8, 2, 1
    public static int[] bubbleSort(int values[]) {
        for (int i = 0; i < values.length; i++) {
            for (int j = i; j < values.length; j++) {
                if (values[i] > values[j]) {
                    int temp = values[i];
                    values[i] = values[j];
                    values[j] = temp;
                }
            }
        }
        return values;
    }

    public static void main(String args[]) {
        int result[] = bubbleSort(new int[] { 3, 2, 1, 10, 5, 8, 2, 1 });

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
