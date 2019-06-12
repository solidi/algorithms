import java.io.*;
import java.util.*;

/**
 * Get the Triangular number of a specific number. Triangular number = any of
 * the series of numbers (1, 3, 6, 10, 15, etc.) obtained by continued summation
 * of the natural numbers 1, 2, 3, 4, 5, etc.
 *
 * T1 = X => Sum = 1
 *
 * T2 = x => Sum = 3 x x
 *
 * T3 = x => Sum = 6 x x x x x
 * 
 * T4 = x => Sum = 10 x x x x x x x x x
 */
class Solution {
    public static int triangleNumber(int rows) {
        int sum = 0;

        for (int i = 1; i <= rows; i++) {
            sum += i;
        }

        return sum;
    }

    public static int triangleNumberRecursive(int rows) {
        if (rows > 0) {
            return rows + triangleNumberRecursive(--rows);
        }

        return rows;
    }

    public static void main(String args[]) {
        System.out.println(triangleNumberRecursive(5));
    }
}
