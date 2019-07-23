import java.io.*;
import java.util.*;

/*
  Sum Lists: You have two numbers represented by a linke list where each node contains a single
  digit. The digits are stored in reverse order, such that the 1 digits is at the head of the list.
  Write a function that adds the two numbers and returns the sum of the linked list.
  
  Input: (7 -> 1 -> 6) + (5 -> 9 -> 2) 617 + 295
  Output: (2 -> 1 -> 9) 912
  
  Try it reversed as well.
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

        public LinkedList sum(LinkedList list1, LinkedList list2) {
            int number1 = 0;
            int number2 = 0;
            int iteration = 1;

            Node temp = list1.head;
            while (temp != null) {
                int num = temp.value * iteration;
                number1 += num;
                iteration *= 10;
                temp = temp.next;
            }

            iteration = 1;

            temp = list2.head;
            while (temp != null) {
                int num = temp.value * iteration;
                number2 += num;
                iteration *= 10;
                temp = temp.next;
            }

            int sum = number1 + number2;
            LinkedList sumList = new LinkedList();
            while (sum > 1) {
                sumList.insert(new Node(sum % 10));
                sum /= 10;
            }

            return sumList;
        }

        public LinkedList sumReverse(LinkedList list1, LinkedList list2) {
            int number1 = 0;
            int number2 = 0;
            int iteration = 1;

            Node temp = list1.head;
            while (temp != null) {
                iteration *= 10;
                temp = temp.next;
            }
            temp = list1.head;
            while (temp != null) {
                iteration /= 10;
                int num = temp.value * iteration;
                number1 += num;
                temp = temp.next;
            }

            iteration = 1;

            temp = list2.head;
            while (temp != null) {
                iteration *= 10;
                temp = temp.next;
            }
            temp = list2.head;
            while (temp != null) {
                iteration /= 10;
                int num = temp.value * iteration;
                number2 += num;
                temp = temp.next;
            }

            int sum = number1 + number2;
            LinkedList sumList = new LinkedList();
            while (sum > 1) {
                sumList.insert(new Node(sum % 10));
                sum /= 10;
            }

            return sumList;
        }
    }

    public static void main(String args[]) {
        LinkedList list1 = new LinkedList();
        list1.insert(new Node(6));
        list1.insert(new Node(1));
        list1.insert(new Node(7));

        LinkedList list2 = new LinkedList();
        list2.insert(new Node(2));
        list2.insert(new Node(9));
        list2.insert(new Node(5));

        LinkedList sumList = list1.sum(list1, list2);
        sumList.print();

        LinkedList list3 = new LinkedList();
        list3.insert(new Node(7));
        list3.insert(new Node(1));
        list3.insert(new Node(6));

        LinkedList list4 = new LinkedList();
        list4.insert(new Node(5));
        list4.insert(new Node(9));
        list4.insert(new Node(2));

        LinkedList sumList2 = list1.sumReverse(list3, list4);
        sumList2.print();
    }
}
