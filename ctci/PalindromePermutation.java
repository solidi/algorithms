import java.io.*;
import java.util.*;

/**
 * Palidrome Permutation: Given a string, write a function to check if it is a
 * permutation of a palindrome. Permutation is an arrangement of letters. The
 * palindrome does not need to be limited to just dictionary words.
 * 
 * Input: Tact Coa Out: True: "taco cat", "atco cta", etc
 * 
 * Incomplete at this time.
 **/
class Solution {

    public static boolean countLetters(String input) {
        HashMap<Character, Integer> map = new HashMap<>();
        input = input.toLowerCase();

        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);

            if (letter == ' ') {
                continue;
            }

            if (map.containsKey(letter)) {
                int count = map.get(input.charAt(i));
                map.put(letter, ++count);
            } else {
                map.put(letter, 1);
            }
        }

        boolean foundOdd = false;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();

            System.out.println(key + " -> " + value);

            if (value % 2 != 0) {
                if (!foundOdd) {
                    foundOdd = true;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isPalindrome(String input) {
        System.out.println(input);
        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static String swap2(String input) {
        int min = 0;
        int max = input.length() - 1;
        char[] list = input.toCharArray();
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            int random1 = r.nextInt((max - min) + 1) + min;
            int random2 = r.nextInt((max - min) + 1) + min;
            char first = list[random1];
            char second = list[random2];
            list[random1] = second;
            list[random2] = first;
        }
        return String.copyValueOf(list);
    }

    public static ArrayList<String> palindromePermutation(String input) {
        input = input.toLowerCase();
        ArrayList<String> result = new ArrayList<>();
        String newString = swap2(input);
        for (int i = 0; i < 1000; i++) {
            if (isPalindrome(newString)) {
                result.add(newString);
            }
            newString = swap2(newString);
        }
        return result;
    }

    public static void main(String args[]) {
        /**
         * ArrayList<String> list = palindromePermutation("Tact Coa"); for (String out :
         * list) { System.out.println(out); }
         **/
        System.out.println(countLetters("Tact Coa"));
    }
}
