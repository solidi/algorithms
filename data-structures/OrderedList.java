import java.io.*;
import java.util.*;

// Build an ordered linked list (greatest to lease)
// Create this linkedlist that prints out 50->30->10->5
// Include insertion, deletion, and find (by value) - find the 30
// Insertion order: 5, 50, 30, 10
class Solution {

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public String toString() {
            return "" + value;
        }
    }

    static class LinkedList {
        Node head;

        public void insertion(Node nodeToInsert) {
            if (head == null) {
                head = nodeToInsert;
                return;
            }

            Node tempNode = head;
            Node prevNode = head;

            while (tempNode != null && tempNode.value > nodeToInsert.value) {
                prevNode = tempNode;
                tempNode = tempNode.next;
            }

            if (tempNode == null) {
                // End
                prevNode.next = nodeToInsert;
            } else {
                if (tempNode == head) {
                    // Start
                    head = nodeToInsert;
                    head.next = tempNode;
                } else {
                    // Middle
                    nodeToInsert.next = tempNode;
                    prevNode.next = nodeToInsert;
                }
            }
        }

        public void deletion() {
            if (head == null) {
                return;
            }

            head = head.next;
        }

        public Node find(int valueToFind) {
            Node temp = head;

            while (temp != null) {
                if (temp.value == valueToFind) {
                    return temp;
                }
                temp = temp.next;
            }

            return temp;
        }

        public void print() {
            Node temp = head;

            while (temp != null) {
                System.out.print(temp.value + "->");
                temp = temp.next;
            }

            System.out.println("null");
        }
    }

    public static void main(String args[]) {
        LinkedList list = new LinkedList();
        list.insertion(new Node(5));
        list.print();
        System.out.println();

        list.insertion(new Node(50));
        list.print();
        System.out.println();

        list.insertion(new Node(30));
        list.print();
        System.out.println();

        list.insertion(new Node(10));
        list.print();
        System.out.println();

        System.out.println(list.find(30));
        System.out.println(list.find(6));
    }
}
