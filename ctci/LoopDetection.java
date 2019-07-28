import java.io.*;
import java.util.*;

/*
  Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the 
  beginning of the loop.

  Example: A -> B -> C -> D -> E -> C
  Returns: C
*/
class Solution {

    public static class Node {
        Node next = null;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class LinkedList {
        public Node head;

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

        public Node findCorruption() {
            Node slow = head;
            Node fast = head.next;

            while (slow != fast) {
                if (slow.next == null) {
                    return null;
                }

                if (fast.next == null || fast.next.next == null) {
                    return null;
                }

                slow = slow.next;
                fast = fast.next.next;
            }

            return fast;
        }
    }

    public static void main(String args[]) {
        LinkedList list = new LinkedList();
        Node corrupt = new Node(3);
        Node lastIn = new Node(5);

        list.insert(new Node(1));
        list.insert(new Node(2));
        list.insert(corrupt);
        list.insert(new Node(4));
        list.insert(lastIn);

        // Make corrupt
        corrupt.next = lastIn;

        Node item = list.findCorruption();
        System.out.println(item == null ? "No loop" : item.value);
    }
}