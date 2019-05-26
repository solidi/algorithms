import java.io.*;
import java.util.*;

/*
 Build a Queue using a linked list. 
 
 Queue interface is
 enqueue()
 dequeue()
 empty()
 peek()
 */
class Solution {

    public static class Node {
        int value;
        Node nextNode;
        Node prevNode;

        public Node(int value) {
            this.value = value;
        }

        public String toString() {
            return "" + value;
        }
    }

    public static interface Queue {
        public void enqueue(Node item);

        public Node dequeue();

        public boolean empty();

        public Node peek();
    }

    public static class QueueImpl implements Queue {
        DoubleLinkedList list = new DoubleLinkedList();

        public void enqueue(Node item) {
            list.insert(item);
        }

        public Node dequeue() {
            return list.deleteTail();
        }

        public boolean empty() {
            return list.peekTail() == null ? true : false;
        }

        public Node peek() {
            return list.peekTail();
        }
    }

    public static class DoubleLinkedList {
        Node head;
        Node tail;

        public void insert(Node nodeToInsert) {
            if (head == null) {
                head = nodeToInsert;
                tail = nodeToInsert;
            }

            head.prevNode = nodeToInsert;
            nodeToInsert.nextNode = head;
            head = nodeToInsert;
        }

        public Node delete() {
            Node temp = head;

            if (head != null) {
                head = head.nextNode;
            } else {
                tail = null;
            }

            return temp;
        }

        public Node deleteTail() {
            Node temp = tail;

            if (tail != null) {
                tail = tail.prevNode;
            } else {
                head = null;
            }

            return temp;
        }

        public Node peekTail() {
            return tail;
        }
    }

    public static void main(String args[]) {
        Queue queue = new QueueImpl();
        queue.enqueue(new Node(5));
        queue.enqueue(new Node(4));
        queue.enqueue(new Node(3));
        queue.enqueue(new Node(2));

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }

}
