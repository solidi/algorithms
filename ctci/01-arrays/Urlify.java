import java.io.*;
import java.util.*;

/**
 * URLify: Write a method to replace all spaces in a string with '%20'. You may
 * assume that the string has sufficent space at the end to hold thr additional
 * characters, and that you are given the "true" length of the string.
 * 
 * Example: "Mr John Smith ", 13 "Mr%20John%20Smith"
 **/
class Solution {
    public static String urlify(String input, int length) {
        char[] array = input.toCharArray();
        for (int i = 0; i < input.length(); i++) {
            if (array[i] == ' ') {
                array[i] = '%';
                char one = array[i + 1];
                char two = array[i + 2];
                for (int j = input.length() - 1; j > i; j--) {
                    array[j] = array[j - 2];
                }
                array[i + 1] = '2';
                array[i + 2] = '0';
                i += 2;
            }
        }
        return String.copyValueOf(array);
    }

    public static void main(String args[]) {
        System.out.println(urlify("Mr John Smith    ", 13));
    }
}
