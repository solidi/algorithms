import java.io.*;
import java.util.*;

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

        public int depth(TreeNode node) {
            if (node == null) {
                return 0;
            }

            if (node.left == null && node.right == null) {
                return 1;
            }

            if (node.left == null) {
                return depth(node.right) + 1;
            }

            if (node.right == null) {
                return depth(node.left) + 1;
            }

            return Math.max(depth(node.right), depth(node.left)) + 1;
        }
    }

    public static void main(String args[]) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(16);
        tree.insert(17);
        System.out.println(tree.depth(tree.root));
    }
}
