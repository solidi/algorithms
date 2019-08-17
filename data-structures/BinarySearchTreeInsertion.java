import java.io.*;
import java.util.*;

/*
  Binary Tree Insertion.
*/
class Solution {

    public static class BinarySearchTree {
        private static class Node {
            public int data;
            private Node left;
            private Node right;

            public Node(int data) {
                this.data = data;
            }
        }

        public Node root;

        public void insert(int data) {
            Node nodeToInsert = new Node(data);

            if (root == null) {
                root = nodeToInsert;
                return;
            }

            Node temp = root;
            Node previous = null;

            while (temp != null) {
                if (nodeToInsert.data > temp.data) {
                    if (temp.right == null) {
                        temp.right = nodeToInsert;
                        return;
                    }
                    temp = temp.right;
                } else if (nodeToInsert.data <= temp.data) {
                    if (temp.left == null) {
                        temp.left = nodeToInsert;
                        return;
                    }
                    temp = temp.left;
                }
            }
        }

        public void printPreOrder(Node node) {
            if (node != null) {
                System.out.println(node.data + "");
                printPreOrder(node.left);
                printPreOrder(node.right);
            }
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.printPreOrder(tree.root);
    }
}
