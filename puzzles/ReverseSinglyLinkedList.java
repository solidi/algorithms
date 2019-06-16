import java.io.*;
import java.util.*;

/*
Reverse a singly linked list without using extra memory.
*/
class Solution {

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }

        public String toString() {
            return "" + value;
        }
    }

    public static class LinkedList {
        public Node head;

        public void add(Node nodeToAdd) {
            if (head == null) {
                head = nodeToAdd;
                return;
            }

            nodeToAdd.next = head;
            head = nodeToAdd;
        }

        public void print() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.value + " -> ");
                temp = temp.next;
            }
            System.out.print("null\n");
        }

        public void reverse() {
            Node curr = head, next = head, prev = head;
            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                curr = prev;
                prev = next;
            }
            head = prev;
        }
    }

    public static void main(String args[]) {
        LinkedList list = new LinkedList();
        list.add(new Node(1));
        list.add(new Node(2));
        list.add(new Node(3));
        list.print();
        list.reverse();
        list.print();
    }
}
