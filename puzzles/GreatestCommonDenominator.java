import java.io.*;
import java.util.*;

/**
Write a function that determines the greatest common denominator between two numbers.
 */
class Solution {
  public static int gcd(int m, int n) {
    if (n == 0) {
      return m;
    }
    
    return gcd(n, m % n);
  }
  
  public static void main(String[] args) {
    System.out.println("Greatest common denominator is: " + gcd(6, 3));
  }
}
