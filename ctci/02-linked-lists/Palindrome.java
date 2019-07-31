import java.io.*;
import java.util.*;

/*
  Palindrome: Given a linked list, determine if its a palindrome.
*/
class Solution {

    public static class Node {
        Node next = null;
        char value;

        public Node(char value) {
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

        public boolean isPalindrome() {
            String forward = "";

            Node temp = head;
            while (temp != null) {
                forward += temp.value;
                temp = temp.next;
            }

            Node current = head;
            Node prev = null;
            Node next = null;
            while (current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            head = prev;

            String reverse = "";

            temp = head;
            while (temp != null) {
                reverse += temp.value;
                temp = temp.next;
            }

            return forward.equals(reverse);
        }
    }

    public static void main(String args[]) {
        LinkedList list = new LinkedList();
        list.insert(new Node('r'));
        list.insert(new Node('a'));
        list.insert(new Node('c'));
        list.insert(new Node('e'));
        list.insert(new Node('c'));
        list.insert(new Node('a'));
        list.insert(new Node('r'));

        boolean isPalindrome = list.isPalindrome();

        System.out.println(isPalindrome);
    }
}
