import java.io.*;
import java.util.*;

/*
  Delete Middle Node: Implement an algorithm to delete a node in the middle of a singly
  linked list, given only access to that node.
  
  Approach: Shift values, remove last node.
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
      
        public void removeMiddle(Node nodeToRemove) {
          Node temp = nodeToRemove;
          Node prev = null;
          
          while (temp != null) {
            if (temp.next != null) {
              // Shift values.
              temp.value = temp.next.value;
            } else {
              // Remove last.
              prev.next = null;
            }
            prev = temp;
            temp = temp.next;
          }
        }
    }

    public static void main(String args[]) {
        LinkedList list = new LinkedList();
        Node toRemove = new Node(2);

        list.insert(new Node(3));
        list.insert(new Node(1));
        list.insert(toRemove);
        list.insert(new Node(4));
        list.insert(new Node(3));

        list.print();
        list.removeMiddle(toRemove);
        list.print();
    }
}
