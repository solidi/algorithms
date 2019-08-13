import java.io.*;
import java.util.*;

/*
  Sort Stack: Write an algorithm where a stack is sorted with the smallest items are on top.
  Use a secondary stack for extra space.
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
            nodeToPush.next = top;
            top = nodeToPush;
        }

        public T pop() {
            StackNode<T> item = top;
            if (top == null) {
                return null;
            }
            top = top.next;
            return item.data;
        }

        public T peek() {
            return top.data;
        }

        public boolean isEmpty() {
            return top == null;
        }
    }

    public static void sortStack(Stack<Integer> stackToSort) {
        Stack<Integer> secondaryStack = new Stack<>();

        while (!stackToSort.isEmpty()) {
            Integer tmp = stackToSort.pop();
            while (!secondaryStack.isEmpty() && secondaryStack.peek() > tmp) {
                stackToSort.push(secondaryStack.pop());
            }
            secondaryStack.push(tmp);
        }

        while (!secondaryStack.isEmpty()) {
            stackToSort.push(secondaryStack.pop());
        }
    }

    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(4);
        stack.push(3);
        stack.push(5);

        sortStack(stack);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

}
