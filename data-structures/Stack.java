import java.io.*;
import java.util.*;

/*
 Build a Stack using a linked list. 
 
 Queue interface
 push()
 pop()
 empty()
 peek()

 */
class Solution {

    public static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public String toString() {
            return "" + value;
        }
    }

    public static interface Stack {
        public void push(Node item);

        public Node pop();

        public boolean empty();

        public Node peek();
    }

    public static class StackImpl implements Stack {
        LinkedList list = new LinkedList();

        public void push(Node item) {
            list.insert(item);
        }

        public Node pop() {
            return list.delete();
        }

        public boolean empty() {
            return list.empty();
        }

        public Node peek() {
            return list.peek();
        }
    }

    public static class LinkedList {
        Node head;

        public void insert(Node itemToInsert) {
            if (head == null) {
                head = itemToInsert;
                return;
            }

            itemToInsert.next = head;
            head = itemToInsert;
        }

        public Node delete() {
            if (head == null) {
                return head;
            }

            Node temp = head;
            head = head.next;

            return temp;
        }

        public boolean empty() {
            return head != null ? false : true;
        }

        public Node peek() {
            return head;
        }
    }

    public static void main(String args[]) {
        Stack stack = new StackImpl();

        stack.push(new Node(5));
        stack.push(new Node(4));
        stack.push(new Node(3));
        stack.push(new Node(2));

        while (!stack.empty()) {
            System.out.print(stack.pop() + " -> ");
        }

        System.out.println("null");
    }
}
