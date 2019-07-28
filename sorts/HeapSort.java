import java.io.*;
import java.util.*;

/*
  Write a solution to the Heap Sort.
*/
class Solution {
    public static void heapArrayAtIndex(int array[], int index, int itemsInArray) {
        if (index > itemsInArray / 2) {
            return;
        }

        int rootValue = array[index];

        while (index < itemsInArray / 2) {
            int leftChild = index * 2 + 1;
            int rightChild = leftChild + 1;
            int largestChild = leftChild;

            if (rightChild < itemsInArray && array[rightChild] > array[largestChild]) {
                largestChild = rightChild;
            }

            if (rootValue > array[largestChild]) {
                break;
            }

            array[index] = array[largestChild];
            index = largestChild;
        }

        array[index] = rootValue;
    }

    public static void heapSort(int array[], int itemsInArray) {
        for (int j = (array.length - 1) / 2; j >= 0; j--) {
            heapArrayAtIndex(array, j, itemsInArray);
        }

        while (itemsInArray > 0) {
            int pop = array[0];
            array[0] = array[itemsInArray - 1];
            array[itemsInArray - 1] = pop;
            itemsInArray--;

            heapArrayAtIndex(array, 0, itemsInArray);
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
        heapSort(array, array.length);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
