import java.io.*;
import java.util.*;

/**
 * Created a linked list in highest order. input 8, 3, 5, 10, 19 
 * Result: 19 -> 10 -> 8 -> 5 -> 3
 **/
class Solution {

    public static class Node {
        public Node next;
        private int value;

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

            Node current = head;
            Node prev = head;

            while (current != null && current.value >= nodeToInsert.value) {
                prev = current;
                current = current.next;
            }

            if (current == head) {
                nodeToInsert.next = current;
                head = nodeToInsert;
            } else {
                if (current == null) {
                    prev.next = nodeToInsert;
                } else {
                    nodeToInsert.next = current;
                    prev.next = nodeToInsert;
                }
            }
        }

        public void print() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.value + " -> ");
                temp = temp.next;
            }

            System.out.println("null");
        }
    }

    public static void main(String args[]) {
        LinkedList list = new LinkedList();
        list.insert(new Node(8));
        list.insert(new Node(3));
        list.insert(new Node(5));
        list.insert(new Node(10));
        list.insert(new Node(19));
        list.print();
    }

}
