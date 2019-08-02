import java.io.*;
import java.util.*;

class Solution {

    public static class StackItem<T> {
        public T value;
        public StackItem<T> next;

        public StackItem(T item) {
            this.value = item;
        }

        public String toString() {
            return "" + value;
        }
    }

    public static interface Stack<T> {
        public void push(StackItem<T> item);

        public StackItem<T> pop();

        public StackItem<T> peek();

        public boolean isEmpty();
    }

    public static class StackImpl<T> implements Stack<T> {
        private StackItem<T> top;

        public void push(StackItem<T> itemToPush) {
            itemToPush.next = top;
            top = itemToPush;
        }

        public StackItem<T> pop() {
            if (top == null) {
                return null;
            }

            StackItem<T> pop = top;
            top = top.next;
            return pop;
        }

        public StackItem<T> peek() {
            return top;
        }

        public boolean isEmpty() {
            return top == null;
        }
    }

    public static void main(String args[]) {
        Stack<Integer> stack = new StackImpl<>();
        stack.push(new StackItem<>(1));
        stack.push(new StackItem<>(2));
        stack.push(new StackItem<>(3));
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
