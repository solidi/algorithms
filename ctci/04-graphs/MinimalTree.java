import java.io.*;
import java.util.*;

/*
  Minimal Tree: given a sorted array, with unique integers, write an algorithm to 
  create a binary search tree with minimal height.
 */
class Solution {
    public static class TreeNode {
        private int value;
        TreeNode right;
        TreeNode left;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public static TreeNode minimalTree(int array[]) {
        return minimalTree(array, 0, array.length - 1);
    }

    private static TreeNode minimalTree(int array[], int start, int end) {
        if (end < start) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode n = new TreeNode(array[mid]);
        n.left = minimalTree(array, start, mid - 1);
        n.right = minimalTree(array, mid + 1, end);
        return n;
    }

    public static void printTree(TreeNode root) {
        if (root != null) {
            System.out.println(root.value + "");
            printTree(root.left);
            printTree(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode n = minimalTree(new int[] { 2, 4, 6, 8, 10, 12, 14, 16 });
        printTree(n);
    }
}
