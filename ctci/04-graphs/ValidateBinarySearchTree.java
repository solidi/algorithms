import java.io.*;
import java.util.*;

/**
 * Validate BST: Implement a function to check if a binary tree is a binary
 * search tree.
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

        private Integer last_printed = null;

        public boolean checkBST(TreeNode node) {
            if (node == null) {
                return true;
            }

            if (!checkBST(node.left)) {
                return false;
            }

            if (last_printed != null && node.value <= last_printed) {
                return false;
            }
            last_printed = node.value;

            if (!checkBST(node.right)) {
                return false;
            }

            return true;
        }

        public void printTree(TreeNode node) {
            if (node != null) {
                printTree(node.left);
                System.out.println(node.value + "");
                printTree(node.right);
            }
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
        System.out.println("Is a validate BST?: " + tree.checkBST(tree.root));
    }
}
