import java.io.*;
import java.util.*;

class Solution {
    public static int binarySearchIterative(int what[], int find) {
        int startPoint = 0;
        int endPoint = what.length;
        int midPoint = (startPoint + endPoint) / 2;

        while (startPoint <= endPoint) {
            if (find > what[midPoint]) {
                startPoint = midPoint + 1;
            } else if (find < what[midPoint]) {
                endPoint = midPoint - 1;
            } else {
                return what[midPoint];
            }

            midPoint = (startPoint + endPoint) / 2;
        }

        return -1;
    }

    public static int binarySearch(int what[], int find, int startIndex, int endIndex) {
        int middleIndex = (startIndex + endIndex) / 2;

        if (startIndex <= endIndex) {
            if (find > what[middleIndex]) {
                return binarySearch(what, find, middleIndex + 1, endIndex);
            } else if (find < what[middleIndex]) {
                return binarySearch(what, find, startIndex, middleIndex - 1);
            } else {
                return what[middleIndex];
            }
        }

        return -1;
    }

    public static void main(String args[]) {
        int whatToSearch[] = { 1, 5, 7, 9, 11, 15, 56, 90 };
        System.out.println(binarySearch(whatToSearch, 90, 0, whatToSearch.length));
        System.out.println(binarySearchIterative(whatToSearch, 90));
    }
}
