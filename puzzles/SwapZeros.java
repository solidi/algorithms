import java.io.*;
import java.util.*;

/**
 * Given an integer list that contains zeros, place all zeros at the end of the
 * array.
 * 
 * For example, given [6, 0, 7, 0, 3, 0, 5, 0], return [6, 5, 7, 10, 3, 0, 0, 0]
 */
class Solution {

    public static void shiftZeros(int givenArray[]) {
        int currentIndex = 0;
        int endIndex = givenArray.length - 1;

        while (currentIndex < endIndex) {
            if (givenArray[currentIndex] == 0) {
                int temp = givenArray[endIndex];
                givenArray[endIndex] = givenArray[currentIndex];
                givenArray[currentIndex] = temp;
                endIndex--;
            }

            // If swap was both zero, run again.
            if (givenArray[currentIndex] != 0) {
                currentIndex++;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] { 6, 0, 7, 0, 3, 0, 5, 0 };
        shiftZeros(array);

        for (int i : array) {
            System.out.print(i + ", ");
        }
    }
}
