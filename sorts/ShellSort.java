import java.io.*;
import java.util.*;

/*
  Write a solution to the Shell Sort.
*/
class Solution {
    public static void shellSort(int array[]) {
        int inner, outer, temp, interval = array.length / 2;
        while (interval > 0) {
            for (outer = interval; outer < array.length; outer++) {
                temp = array[outer];
                inner = outer;
                while ((inner > interval - 1) && array[inner - interval] >= temp) {
                    array[inner] = array[inner - interval];
                    inner -= interval;
                }
                array[inner] = temp;
            }
            interval = (interval - 1) / 2;
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
        shellSort(array);
        for (int number : array) {
            System.out.print(number + " ");
        }
    }
}
