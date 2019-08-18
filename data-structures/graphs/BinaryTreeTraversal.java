import java.io.*;
import java.util.*;

/*
  Trees are graphs.
  Trees can have many children. They cannot contain cycles.
  Trees that only have two nodes is a binary tree.
  Trees that have values as left descendents <= n < right descendents are binary search trees.
  A node that has no children is a leaf.
  A complete binary tree contain all nodes except the last level.
  A full binary tree has all nodes with zero or two nodes.
  A perfect binary tree all nodes filled.
  A binary tree can be traversed inorder, preorder, or postorder.
  Preorder traversal contains the root node first.
  Postorder traversal contains the root node last.
*/
class Solution {
    public static class Node {
        public int value;
        private Node left;
        private Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.println("" + node.value);
            printInOrder(node.right);
        }
    }

    public static void printPreOrder(Node node) {
        if (node != null) {
            System.out.println("" + node.value);
            printInOrder(node.left);
            printInOrder(node.right);
        }
    }

    public static void printPostOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            printInOrder(node.right);
            System.out.println("" + node.value);
        }
    }

    public static void main(String[] args) {
        Node leaf5 = new Node(6, null, null);
        Node leaf6 = new Node(7, null, null);
        Node leaf7 = new Node(4, null, null);
        Node leaf8 = new Node(5, null, null);
        Node leaf1 = new Node(3, leaf7, leaf8);
        Node leaf2 = new Node(2, leaf5, leaf6);
        Node tree = new Node(1, leaf1, leaf2);

        printInOrder(tree);
        System.out.println("");
        printPreOrder(tree);
        System.out.println("");
        printPostOrder(tree);
    }
}
