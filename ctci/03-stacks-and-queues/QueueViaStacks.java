import java.io.*;
import java.util.*;

/*
  Queue via Stacks: Implement a MyQueue class which implements a queue with two stacks.
*/
class Solution {

    public static class Stack<T> {
        private class StackNode<T> {
            private T data;
            private StackNode<T> next;

            public StackNode(T data) {
                this.data = data;
            }
        }

        private StackNode<T> top;

        public void push(T data) {
            StackNode<T> nodeToPush = new StackNode<>(data);
            if (top == null) {
                top = nodeToPush;
                return;
            }

            nodeToPush.next = top;
            top = nodeToPush;
        }

        public T pop() {
            if (top != null) {
                T data = top.data;
                top = top.next;
                return data;
            }
            return null;
        }

        public boolean isEmpty() {
            return top == null;
        }
    }

    public static class MyQueue<T> {
        private Stack<T> primaryStack = new Stack<>();
        private Stack<T> secondaryStack = new Stack<>();
        private boolean expressMode = false;

        public void add(T data) {
            if (expressMode) {
                while (!secondaryStack.isEmpty()) {
                    primaryStack.push(secondaryStack.pop());
                }
            }

            primaryStack.push(data);
        }

        public T remove() {
            while (!primaryStack.isEmpty()) {
                secondaryStack.push(primaryStack.pop());
            }

            expressMode = true;

            return secondaryStack.pop();
        }
    }

    public static void main(String args[]) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());

        queue.add(4);
        queue.add(5);
        queue.add(6);

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
    }

}
