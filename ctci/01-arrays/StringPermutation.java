import java.io.*;
import java.util.*;

/**
 * Check permutation: Given two strings, write a method to decide if one is a
 * permutation of the other.
 **/
class Solution {

    /**
     * Assume permutation is same characters but of different order.
     **/
    public static boolean isPermutation(String string1, String string2) {
        HashMap<Character, Boolean> map = new HashMap<>();

        if (string1.length() != string2.length()) {
            return false;
        }

        for (int i = 0; i < string1.length(); i++) {
            map.put(string1.charAt(i), true);
        }

        for (int i = 0; i < string2.length(); i++) {
            if (!map.containsKey(string2.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]) {
        System.out.println(isPermutation("abcdefg", "gfedcba"));
        System.out.println(isPermutation("abcd", "abc"));
        System.out.println(isPermutation("abcdefgh", "igfedcba"));
    }

}
