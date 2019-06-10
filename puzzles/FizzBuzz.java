import java.io.*;
import java.util.*;

/**
 * Print out the numbers from 1 to 100, each number on its own line, with the
 * following exceptions: if the number is divisible by 3, print out "Fizz"
 * instead of the number if the number is divisible by 5, print out "Buzz"
 * instead of the number if the number is divisible by both 3 and 5, print out
 * "FizzBuzz" instead of the number
 */
class Solution {

    public static void fizzBuzz(int n) {
        for (int i = 1; i <= n; i++) {
            String result = i + "";

            if (i % 15 == 0) {
                result = "FizzBuzz";
            } else if (i % 3 == 0) {
                result = "Fizz";
            } else if (i % 5 == 0) {
                result = "Buzz";
            }

            System.out.println(result);
        }
    }

    public static void main(String args[]) {
        fizzBuzz(100);
    }
}
