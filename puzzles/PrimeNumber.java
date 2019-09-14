import java.io.*;
import java.util.*;

class Solution {
    public static boolean prime(int number) {
        if (number % 2 == 0) {
            return false;
        }

        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]) {
        System.out.println("Is this number prime?: " + prime(13));
    }
}
