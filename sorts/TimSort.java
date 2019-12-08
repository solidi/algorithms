import java.io.*;
import java.util.*;

/**
 * Implement Timsort
 * https://skerritt.blog/timsort-the-fastest-sorting-algorithm-youve-never-heard-of/
 * https://www.geeksforgeeks.org/timsort/
 **/
class Solution {
  public static void insertionSort(int[] arr, int left, int right) {
    for (int i = left + 1; i <= right; i++) {
      int temp = arr[i];
      int j = i - 1;
      while (j >= 0 && arr[j] > temp && j >= left) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = temp;
    }
  }

  public static void merge(int[] arr, int l, int m, int r) {
    int len1 = m - l + 1, len2 = r - m;
    int[] left = new int[len1];
    int[] right = new int[len2];
    for (int x = 0; x < len1; x++) {
      left[x] = arr[l + x];
    }
    for (int x = 0; x < len2; x++) {
      right[x] = arr[m + 1 + x];
    }

    int i = 0;
    int j = 0;
    int k = l;

    while (i < len1 && j < len2) {
      if (left[i] <= right[j]) {
        arr[k] = left[i];
        i++;
      } else {
        arr[k] = right[j];
        j++;
      }
      k++;
    }

    while (i < len1) {
      arr[k] = left[i];
      k++;
      i++;
    }

    while (j < len2) {
      arr[k] = right[j];
      k++;
      j++;
    }
  }

  public static void timSort(int[] arr, int n, int run) {
    for (int i = 0; i < n; i += run) {
      System.out.println(Math.min((i + 31), (n - 1)));
      insertionSort(arr, i, Math.min((i + 31), (n - 1)));
    }

    for (int size = run; size < n; size = 2 * size) {
      for (int left = 0; left < n; left += 2 * size) {
        int mid = left + size - 1;
        int right = Math.min((left + 2 * size - 1), (n - 1));
        merge(arr, left, mid, right);
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
    int array[] = generateArray(64);
    timSort(array, array.length, 32);
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }
  }
}
