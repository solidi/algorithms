import java.io.*;
import java.util.*;

/*
  Remove dups: Write code to remove duplicates from an unsorted linked list.
  
  With extra memory.
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

        public void findDup() {
            Node temp = head;

            while (temp != null) {
                int t_value = temp.value;
                Node second = temp.next;

                while (second != null) {
                    int s_value = second.value;

                    if (t_value == s_value) {
                        System.out.println("dup: " + s_value);
                    }

                    second = second.next;
                }

                temp = temp.next;
            }
        }

        public void removeValue(int value) {
            Node temp = head;
            Node prev = null;

            while (temp != null) {
                if (temp.value == value) {
                    if (temp == head) {
                        head = temp.next;
                    } else {
                        if (temp.next == null) {
                            prev.next = null;
                        } else {
                            prev.next = temp.next;
                        }
                    }

                    return;
                }

                prev = temp;
                temp = temp.next;
            }
        }

        public void removeDup() {
            Node temp = head;
            map.clear();

            while (temp != null) {
                if (!map.containsKey(temp.value)) {
                    map.put(temp.value, 1);
                } else {
                    int increment = map.get(temp.value) + 1;
                    map.put(temp.value, increment);
                }
                temp = temp.next;
            }

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                for (int i = entry.getValue(); i > 1; i--) {
                    removeValue(entry.getKey());
                }
            }
        }

        public void runner() {
            Node slow = head;
            Node fast = head;
            int count = 0;

            while (slow != null && count < 2) {
                if (slow != fast && slow.value == fast.value) {
                    removeValue(slow.value);
                }

                slow = slow.next;

                if (slow == null) {
                    count++;
                    slow = head;
                }

                if (fast.next == null) {
                    fast = head;
                } else {
                    fast = fast.next.next;

                    if (fast == null) {
                        fast = head;
                    }
                }
            }
        }
    }

    public static void main(String args[]) {
        LinkedList list = new LinkedList();
        list.insert(new Node(3));
        list.insert(new Node(1));
        list.insert(new Node(2));
        list.insert(new Node(4));
        list.insert(new Node(3));

        list.print();

        list.runner();

        list.print();
    }
}
