import java.io.*;
import java.util.*;

public class Solution {
    public static void radixSort(int array[]) {
        final int divisor = 10;

        // declare and initialize bucket[]
        List<Integer>[] bucket = new ArrayList[divisor];

        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        // sort
        boolean maxLength = false;
        int temp, placement = 1;

        while (!maxLength) {
            maxLength = true;

            // split input between lists
            for (int i : array) {
                temp = i / placement;
                bucket[temp % divisor].add(i);
                if (maxLength && temp > 0) {
                    maxLength = false;
                }
            }

            // empty lists into input array
            int sortedIndex = 0;

            for (int b = 0; b < divisor; b++) {
                for (int i : bucket[b]) {
                    array[sortedIndex++] = i;
                }
                bucket[b].clear();
            }

            // move to next digit
            placement *= divisor;
        }
    }

    public static int[] generateArray(int size) {
        int array[] = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 90) + 10;
        }
        return array;
    }

    public static void main(String[] args) {
        int array[] = generateArray(20);
        radixSort(array);
        for (int number : array) {
            System.out.print(number + " ");
        }
    }
}
