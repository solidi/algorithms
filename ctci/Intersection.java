import java.io.*;
import java.util.*;

/*
  Intersection: Given two singly linked lists, determine if the two lists intersect. Return the intersecting node.
  Note that the intersection is defined based on reference, not value. That is, if the kth node of the first linked
  list is the same exact node (by reference) as the jth node of the second linked list, then they are intersecting.
*/
class Solution {

    public static class Node {
        Node next = null;
        int value = 0;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class LinkedList {
        public Node head;
        HashMap<Integer, Integer> map = new HashMap<>();

        public void insert(Node nodeToInsert) {
            if (head == null) {
                head = nodeToInsert;
                return;
            }

            nodeToInsert.next = head;
            head = nodeToInsert;
        }

        public void print() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.value + " -> ");
                temp = temp.next;
            }

            System.out.println("null");
        }

        public Node intersect(LinkedList list1, LinkedList list2) {
            Node firstNode = list1.head;
            Node compareNode = list2.head;
            Node next = list2.head;

            while (firstNode != null) {
                compareNode = next;

                while (compareNode != null) {
                    if (firstNode == compareNode) {
                        return firstNode;
                    }
                    compareNode = compareNode.next;
                }

                firstNode = firstNode.next;

                if (next.next != null) {
                    next = next.next;
                }
            }

            return null;
        }
    }

    public static void main(String args[]) {
        Node seven = new Node(7);
        LinkedList list1 = new LinkedList();
        list1.insert(new Node(6));
        list1.insert(new Node(1));
        list1.insert(seven);

        LinkedList list2 = new LinkedList();
        list2.insert(new Node(3));
        list2.insert(new Node(2));
        list2.insert(seven);
        list2.insert(new Node(5));

        Node item = list1.intersect(list1, list2);
        System.out.println(item == null ? "none" : item.value);
    }
}
