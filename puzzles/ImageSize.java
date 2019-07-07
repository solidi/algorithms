import java.io.*;
import java.util.*;

/**
 * Create a function, when given a screen size and a list of available image
 * sizes, returns the image size that best fits the screen.
 * 
 * Screen size X = 100
 * 
 * list of images - = 90, 50, 60
 * 
 * largest w/o going over
 */
class Solution {

    public static void main(String args[]) {
        int screenSize = 100;
        int imageSizes[] = { 90, 99, 105 };

        int largestScreenSize = largestScreenSize(screenSize, imageSizes);

        System.out.println("Largest Screen Size is: " + largestScreenSize);
    }

    public static int largestScreenSize(int screenSize, int[] imageSizes) {
        int largestImageSize = 0;

        for (int i = 0; i < imageSizes.length; i++) {
            if (imageSizes[i] > largestImageSize && imageSizes[i] <= screenSize) {
                largestImageSize = imageSizes[i];
            }

            if (largestImageSize == screenSize) {
                break;
            }
        }

        return largestImageSize;
    }

}
