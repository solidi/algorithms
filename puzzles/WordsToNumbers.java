import java.io.*;
import java.util.*;

/**
 * Create a function that replaces a list of words with corresponding digits and
 * prints the result. ['zero', 'one', 'three', 'zero', 'nine', 'six', 'zero',
 * 'null'] => Print 01309600
 **/
public class Solution {

    public static String wordsToNumbers(List<String> list) {
        StringBuilder builder = new StringBuilder();
        for (String item : list) {
            switch (item) {
            case "zero":
                builder.append("0");
                break;
            case "one":
                builder.append("1");
                break;
            case "three":
                builder.append("3");
                break;
            case "six":
                builder.append("6");
                break;
            case "nine":
                builder.append("9");
                break;
            default:
                builder.append("0");
            }
        }

        return builder.toString();
    }

    public static void main(String args[]) {
        String result = wordsToNumbers(Arrays.asList("zero", "one", "three", "zero", "nine", "six", "zero", "null"));
        System.out.println(result);
    }

}
