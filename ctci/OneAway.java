import java.io.*;
import java.util.*;

/**
 * There are three types of edits that can be performed on strings: insert a
 * character, remove a character, or replace a character. Given two strings,
 * write a function to check if they are one edit (or zero edits) away.
 * 
 * pale, ple -> true 
 * pales, pale -> true 
 * pale, bale -> true pale, 
 * 
 * ??? Error
 * bake -> false
 **/
class Solution {

    public static boolean oneAway(String input1, String input2) {
        if ((input1.length() - input2.length()) > 1) {
            return false;
        }

        if (input1.contentEquals(input2)) {
            return true;
        }

        boolean givenFault = false;

        for (int i = 0; i < input1.length(); i++) {
            if (input1.length() == input2.length()) {
                if (input1.charAt(i) != input2.charAt(i)) {
                    if (givenFault)
                        return false;
                    else
                        givenFault = true;
                }
            }

            if (input1.length() > input2.length()) {
                if (input2.length() > i) {
                    if (input1.charAt(i) == input2.charAt(i)) {
                        continue;
                    }

                    if (input1.charAt(i + 1) != input2.charAt(i)) {
                        return false;
                    }
                }
            }

            if (input2.length() > input1.length()) {
                if (input1.length() > i) {
                    if (input2.charAt(i) == input1.charAt(i)) {
                        continue;
                    }

                    if (input2.charAt(i + 1) != input1.charAt(i)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String args[]) {
        System.out.println(oneAway("pale", "ple"));
        System.out.println(oneAway("pales", "pale"));
        System.out.println(oneAway("pale", "bale"));
    }
}
