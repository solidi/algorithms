import java.io.*;
import java.util.*;

/*
  Return kth to Last: Implement an algorithm to find the kth to last element of a singly linked
  list.
  
  3 -> 4 -> 5 -> 4
  1    2    3    4
  
  store tail?
  last - k
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
        Node head;

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

        public void kth(int k) {
            Node p1 = head;
            Node p2 = head;

            for (int i = 0; i < k; i++) {
                p1 = p1.next;
            }

            while (p1 != null) {
                p1 = p1.next;
                p2 = p2.next;
            }

            System.out.println("kth element is: " + p2.value);
        }
    }

    public static void main(String args[]) {
        LinkedList list = new LinkedList();
        list.insert(new Node(3));
        list.insert(new Node(1));
        list.insert(new Node(2));
        list.insert(new Node(4));
        list.insert(new Node(3));

        list.print();
        list.kth(3);
    }
}
