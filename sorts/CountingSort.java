/**
 * Time Best: n+k Average: n+k Worst: n+k
 *
 * Space Worst: k
 */
public class Solution {

    public static int[] countingSort(int array[], int maxNumberValue) {
        int numberCounts[] = new int[maxNumberValue];
        int sortedArray[] = new int[array.length];
        int sortedIndex = 0;

        // Count how many instances of a number and place that
        // number in its corresponding index.
        for (int number : array) {
            numberCounts[number]++;
        }

        // Loop through each number count index.
        // Take the count of that number.
        for (int number = 0; number < numberCounts.length; number++) {
            int count = numberCounts[number];

            for (int i = 0; i < count; i++) {
                sortedArray[sortedIndex] = number;
                sortedIndex++;
            }
        }

        return sortedArray;
    }

    public static int findMaxValue(int data[]) {
        int max = 0;
        for (int value : data) {
            if (max < value) {
                max = value;
            }
        }
        return max;
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
        int result[] = countingSort(array, findMaxValue(array) + 1);
        for (int number : result) {
            System.out.print(number + " ");
        }
    }
}
