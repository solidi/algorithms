import java.io.*;
import java.util.*;

/*
  Write a solution to the Quick Sort.
*/
class Solution {
    public static void quickSort(int array[], int leftIndex, int rightIndex) {
        if (leftIndex > rightIndex) {
            return;
        }

        int pivotIndex = partitionArray(array, leftIndex, rightIndex);

        quickSort(array, leftIndex, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, rightIndex);
    }

    public static int partitionArray(int array[], int leftIndex, int rightIndex) {
        int pivotValue = array[rightIndex];
        int pivotIndex = rightIndex;

        leftIndex--;

        while (leftIndex < rightIndex) {
            while (leftIndex < rightIndex && array[++leftIndex] < pivotValue);

            while (rightIndex > leftIndex && array[--rightIndex] > pivotValue);

            if (leftIndex >= rightIndex) {
                break;
            }

            int temp = array[leftIndex];
            array[leftIndex] = array[rightIndex];
            array[rightIndex] = temp;
        }

        array[pivotIndex] = array[leftIndex];
        array[leftIndex] = pivotValue;

        return leftIndex;
    }

    public static int[] generateArray(int size) {
        int array[] = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 90) + 10;
        }
        return array;
    }

    public static void main(String args[]) {
        int array[] = generateArray(20);
        quickSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
