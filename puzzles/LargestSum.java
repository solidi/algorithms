import java.io.*;
import java.util.*;

/*
You are given an array of integers (both positive and negative). Find the continuous sequence with the largest sum. Return the sum.

Example:
Input: {2, -8, 3, -2, 4, -10} Output: 5 (i.e., {3, -2, 4} )
 */
class Solution {
    public static void main(String args[]) {
        int givenArray[] = { 2, -8, 3, -2, 4, -10 };
        System.out.println(kadanesAlgo(givenArray, givenArray.length));
    }

    public static int kadanesAlgo(int array[], int size) {
        int current_sum = 0, ending = 0;

        for (int i = 0; i < size; i++) {
            ending += array[i];

            if (ending < 0) {
                ending = 0;
            } else if (current_sum < ending) {
                current_sum = ending;
            }
        }

        return current_sum;
    }
}
