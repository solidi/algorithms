import java.io.*;
import java.util.*;

/**
 * Is Unique - implement an algorithm to determine if a string has all unqiue
 * characters. What if you cannot use additional data structures?
 **/
class Solution {

    public static boolean isUnique(String input) {
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isUniqueWithList(String input) {
        ArrayList<Character> map = new ArrayList<>();

        char[] list = input.toCharArray();
        for (int i = 0; i < list.length; i++) {
            if (map.contains(list[i])) {
                return false;
            }
            map.add(list[i]);
        }

        return true;
    }

    public static void main(String args[]) {
        System.out.println(isUnique("testing"));
        System.out.println(isUnique("abcdefghi"));
        System.out.println(isUnique("This is not unique"));
    }

}
