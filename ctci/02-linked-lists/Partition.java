import java.io.*;
import java.util.*;

/*
  Parition: Write code to parition a linked list around a value x, such that all nodes less then x come
  before all nodes greater than or equal to x.
  
  Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1
  Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
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

        public void partitionList(int partitionValue) {
            LinkedList secondaryList = new LinkedList();
            Node temp = head;

            while (temp != null) {
                Node n = new Node(temp.value);
                if (temp.value >= partitionValue) {
                    secondaryList.insert(n);
                }
                temp = temp.next;
            }

            temp = head;

            while (temp != null) {
                Node n = new Node(temp.value);
                if (temp.value < partitionValue) {
                    secondaryList.insert(n);
                }
                temp = temp.next;
            }

            head = secondaryList.head;
        }
    }

    public static void main(String args[]) {
        LinkedList list = new LinkedList();
        list.insert(new Node(1));
        list.insert(new Node(2));
        list.insert(new Node(10));
        list.insert(new Node(5));
        list.insert(new Node(8));
        list.insert(new Node(5));
        list.insert(new Node(3));

        list.print();

        list.partitionList(5);

        list.print();
    }
}
