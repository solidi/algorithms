import java.io.*;
import java.util.*;

/**
 * Part 1: Create a function that translates a given list of length N into an
 * integer and returns the result. ['zero', 'one', 'three', 'zero', 'nine',
 * 'six', 'zero', 'null'] => Return 1309600
 *
 * Part 2: Using the previous solution, stop and return when all ten digits have
 * been seen at least once ['three', 'one', 'two', 'four', 'seven', 'three',
 * 'zero', 'nine', 'eight', 'five', 'nine', 'six', 'null', 'one', 'two'] =>
 * Return 312,473,098,596
 */
class Solution {

    public static int wordsToNumbersPart1(List<String> list) {
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

        return Integer.valueOf(builder.toString());
    }

    public static long wordsToNumbersPart2(List<String> list) {
        Set<String> numberSet = new HashSet<String>();
        StringBuilder builder = new StringBuilder();

        for (String item : list) {
            numberSet.add(item);

            switch (item) {
            case "zero":
                builder.append("0");
                break;
            case "one":
                builder.append("1");
                break;
            case "two":
                builder.append("2");
                break;
            case "three":
                builder.append("3");
                break;
            case "four":
                builder.append("4");
                break;
            case "five":
                builder.append("5");
                break;
            case "six":
                builder.append("6");
                break;
            case "seven":
                builder.append("7");
                break;
            case "eight":
                builder.append("8");
                break;
            case "nine":
                builder.append("9");
                break;
            case "null":
                builder.append("0");
                break;
            }

            if (numberSet.containsAll(
                    Arrays.asList("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"))) {
                break;
            }
        }

        return Long.valueOf(builder.toString());
    }

    public static void main(String args[]) {
        int partOne = wordsToNumbersPart1(Arrays.asList("zero", "one", "three", "zero", "nine", "six", "zero", "null"));
        System.out.println("wordsToNumbersPart1 is: " + partOne);
        long partTwo = wordsToNumbersPart2(Arrays.asList("three", "one", "two", "four", "seven", "three", "zero",
                "nine", "eight", "five", "nine", "six", "null", "one", "two"));
        System.out.println("wordsToNumbersPart2 is: " + partTwo);
    }

}
