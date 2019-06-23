import java.io.*;
import java.util.*;

/**
 * Palindrome - write a function that takes in a string, and returns true or
 * false based on these rules.
 **/
class Solution {
    public static boolean isPalindrome(String input) {
        if (input == null || input.length() < 1) {
            return false;
        }

        char inputArray[] = input.toCharArray();

        for (int i = 0; i < input.length() / 2; i++) {
            if (inputArray[i] != inputArray[input.length() - 1 - i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]) {
        System.out.println(isPalindrome("abba"));
        System.out.println(isPalindrome("baa"));
        System.out.println(isPalindrome("racecar"));
    }
}
