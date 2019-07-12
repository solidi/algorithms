import java.io.*;
import java.util.*;

/**
 * String Rotation: Assume you have a method isSubstring which checks if one
 * word is a substring of another. Given two strings, s1 and s2, write code to
 * check if s2 is a rotation of s1 using only one call to isSubstring.
 * 
 * "waterbottle" -> "erbottlewat"
 **/
class Solution {

    public static boolean isRotation(String s1, String s2) {
        int length = s1.length();

        if (length != s2.length()) {
            return false;
        }

        int firstIndex = 0;
        int secondIndex = 0;
        char start = s1.charAt(firstIndex);
        char compare = s2.charAt(secondIndex);

        while (start != compare && length > secondIndex) {
            secondIndex++;
            compare = s2.charAt(secondIndex);
        }

        if (secondIndex == length) {
            return false;
        }

        while (firstIndex < length) {
            System.out.println(s1.charAt(firstIndex) + " == " + s2.charAt(secondIndex));

            if (s1.charAt(firstIndex) != s2.charAt(secondIndex)) {
                return false;
            }

            start = s1.charAt(firstIndex++);
            compare = s2.charAt(secondIndex++);

            if (secondIndex == length) {
                secondIndex = 0;
            }
        }

        return true;
    }

    public static boolean theirs(String s1, String s2) {
        String combine = s2 + s2;
        return combine.indexOf(s1) != -1;
    }

    public static void main(String args[]) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        System.out.println(theirs(s1, s2));
    }
}
