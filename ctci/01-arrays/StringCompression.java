import java.io.*;
import java.util.*;

/**
 * String Compression: Implement a method to perform basic string compression
 * using the counts of repeated characters. For example, the string aabcccccaaa
 * would become a2b1c5a3. If the compressed string would not become smaller than
 * the original string, your method should return the original string. Assume
 * upper and lower cased lettered strings.
 **/
class Solution {

    public static String compressString2(String stringToCompress) {
        char[] list = new char[stringToCompress.length() * 2];
        int listCount = 0, counter = 0;
        char current = stringToCompress.charAt(1);

        for (int i = 0; i < stringToCompress.length(); i++) {
            if (current != stringToCompress.charAt(i)) {
                list[listCount++] = current;
                list[listCount++] = (char) (counter + '0');
                current = stringToCompress.charAt(i);
                counter = 0;
            }
            counter++;
        }

        list[listCount++] = current;
        list[listCount++] = (char) (counter + '0');

        if (listCount >= stringToCompress.length()) {
            return stringToCompress;
        }

        return String.valueOf(list);
    }

    public static void main(String args[]) {
        System.out.println(compressString2("aabcccccaaa"));
    }
}
