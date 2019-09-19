import java.io.*;
import java.util.*;

/**
 * Check Balanced: Implement a function to check if a binary tree is balanced.
 * For the purposes of the question,a balanced tree is defined to be a tree such
 * that the heights of the two subtrees of any node never differ by more than
 * one.
 */
class Solution {

    public static class TreeNode {
        int value;
        TreeNode right;
        TreeNode left;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public static class BinarySearchTree {
        TreeNode root;

        public void insert(int value) {
            TreeNode nodeToInsert = new TreeNode(value);

            if (root == null) {
                root = nodeToInsert;
                return;
            }

            TreeNode temp = root;
            while (temp != null) {
                if (nodeToInsert.value > temp.value) {
                    if (temp.right == null) {
                        temp.right = nodeToInsert;
                        return;
                    }
                    temp = temp.right;
                } else {
                    if (temp.left == null) {
                        temp.left = nodeToInsert;
                        return;
                    }
                    temp = temp.left;
                }
            }
        }

        public void printTree(TreeNode node) {
            if (node != null) {
                System.out.println(node.value + "");
                printTree(node.left);
                printTree(node.right);
            }
        }

        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }

            int height = getHeight(root.left) - getHeight(root.right);
            if (Math.abs(height) > 1) {
                return false;
            } else {
                return isBalanced(root.left) && isBalanced(root.right);
            }
        }

        public int getHeight(TreeNode root) {
            if (root == null) {
                return -1;
            }
            return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        }
    }

    public static void main(String args[]) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(4);
        tree.insert(17);
        tree.printTree(tree.root);
        System.out.println(tree.getHeight(tree.root) + " balanced: " + tree.isBalanced(tree.root));
    }
}
