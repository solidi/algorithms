import java.io.*;
import java.util.*;

class Solution {

    public static void mergeSort(int array[], int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return;
        }

        int middleIndex = (leftIndex + rightIndex) / 2;
        mergeSort(array, leftIndex, middleIndex);
        mergeSort(array, middleIndex + 1, rightIndex);

        int rightStartIndex = middleIndex + 1;
        int rightEndIndex = rightIndex;

        while (leftIndex <= rightStartIndex && leftIndex <= rightEndIndex && rightStartIndex <= rightEndIndex) {
            if (array[leftIndex] < array[rightStartIndex]) {
                leftIndex++;
            } else {
                int temp = array[rightStartIndex];

                for (int k = rightStartIndex; k > leftIndex; k--) {
                    array[k] = array[k - 1];
                }

                array[leftIndex] = temp;
                leftIndex++;
                rightStartIndex++;
            }
        }
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
        mergeSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

}
