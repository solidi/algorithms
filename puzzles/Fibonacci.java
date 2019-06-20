import java.io.*;
import java.util.*;

/*
Write a function that returns the number at a user defined index in the Fibonacci sequence.
*/
class Solution {
    public static int fibonacciIterative(int n) {
        int sum = 0;

        if (n < 2) {
            return n;
        }

        int y = 1;
        int z = 0;

        for (int i = 2; i <= n; i++) {
            sum = y + z;
            z = y;
            y = sum;
        }

        return sum;
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String args[]) {
        System.out.println(fibonacciIterative(6));
    }
}