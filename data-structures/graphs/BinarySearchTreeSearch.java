import java.io.*;
import java.util.*;

/*
  Binary Tree Search.
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

        public int search(int valueToFind) {
            Node temp = root;

            while (temp != null) {
                if (valueToFind > temp.data) {
                    temp = temp.right;
                } else if (valueToFind < temp.data) {
                    temp = temp.left;
                } else if (valueToFind == temp.data) {
                    return temp.data;
                }
            }

            return -1;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        System.out.println(tree.search(20));
    }
}
