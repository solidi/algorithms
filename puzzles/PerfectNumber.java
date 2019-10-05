import java.io.*;
import java.util.*;

/**
 * A perfect number is a positive integer that is equal to the sum of its
 * positive divisors.
 *
 * E.g. 1 + 2 + 3 = 6. So 6 is a perfect number.
 * 
 * Create a program that finds the next perfect number.
 */
class Solution {

    public static boolean isPerfectNumber(int number) {
        ArrayList<Integer> divisors = new ArrayList<>();

        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                divisors.add(i);
            }
        }

        int result = 0;
        for (int n : divisors) {
            result += n;
        }

        return result == number;
    }

    public static void main(String[] args) {
        System.out.println("6 is perfect number?: " + isPerfectNumber(6));
        System.out.println("28 is perfect number?: " + isPerfectNumber(28));
        System.out.println("32 is perfect number?: " + isPerfectNumber(32));
    }
}
