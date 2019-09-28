import java.io.*;
import java.util.*;

class Solution {
    public static boolean isPrimeAll(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPrimeEvens(int number) {
      for (int i = 2; i * 2 < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPrimeEfficient(int number) {
        if (number % 2 == 0) {
            return false;
        }

        // then just check the odds.
        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]) {
        System.out.println("126 this number prime?: " + isPrimeEfficient(126));
        System.out.println("127 this number prime?: " + isPrimeEfficient(127));
        System.out.println("128 this number prime?: " + isPrimeEfficient(128));
    }
}
