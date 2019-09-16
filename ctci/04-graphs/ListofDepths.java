import java.io.*;
import java.util.*;

/**
 * List of Depths: Given a binary tree, design an algorithm which creates a
 * linked list of all the nodes at each depth. (e.g. if you have a tree with
 * depth d, you'll have D linked lists)
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

        public void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
            if (root != null) {
                LinkedList<TreeNode> list = null;
                if (lists.size() == level) {
                    list = new LinkedList<TreeNode>();
                    lists.add(list);
                } else {
                    list = lists.get(level);
                }
                list.add(root);
                createLevelLinkedList(root.left, lists, level + 1);
                createLevelLinkedList(root.right, lists, level + 1);
            }
        }

        public ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode node) {
            ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
            createLevelLinkedList(root, lists, 0);
            return lists;
        }
    }

    public static void main(String args[]) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(16);
        tree.insert(17);
        ArrayList<LinkedList<TreeNode>> lists = tree.createLevelLinkedList(tree.root);
        for (LinkedList<TreeNode> list : lists) {
            for (TreeNode node : list) {
                System.out.print(node.value + " -> ");
            }
            System.out.println("null");
        }
    }
}
