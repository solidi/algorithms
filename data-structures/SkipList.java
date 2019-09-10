import java.io.*;
import java.util.*;

class Solution {
    public static class SkipNode {
        int element;
        SkipNode right;
        SkipNode down;

        public SkipNode(int x) {
            this(x, null, null);
        }

        public SkipNode(int x, SkipNode rt, SkipNode dt) {
            element = x;
            right = rt;
            down = dt;
        }
    }

    public static class SkipList {
        private SkipNode header;
        private int infinity;
        private SkipNode bottom = null;
        private SkipNode tail = null;

        public SkipList(int inf) {
            infinity = inf;
            bottom = new SkipNode(0);
            bottom.right = bottom.down = bottom;
            tail = new SkipNode(infinity);
            tail.right = tail;
            header = new SkipNode(infinity, tail, bottom);
        }

        public void insert(int x) {
            SkipNode current = header;
            bottom.element = x;
            while (current != bottom) {
                while (current.element < x) {
                    current = current.right;
                }

                if (current.down.right.right.element < current.element) {
                    current.right = new SkipNode(current.element, current.right, current.down.right.right);
                    current.element = current.down.right.element;
                } else {
                    current = current.down;
                }
            }

            if (header.right != tail) {
                header = new SkipNode(infinity, tail, header);
            }
        }

        public void makeEmpty() {
            header.right = tail;
            header.down = bottom;
        }

        public boolean isEmpty() {
            return header.right == tail && header.down == bottom;
        }

        public void printList() {
            System.out.print("\nSkiplist = ");
            SkipNode current = header;
            while (current.down != bottom) {
                current = current.down;
            }
            while (current.right != tail) {
                System.out.print(current.element + " ");
                current = current.right;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SkipList skipList = new SkipList(100);
        skipList.insert(5);
        skipList.insert(10);
        skipList.insert(20);
        skipList.printList();
    }
}