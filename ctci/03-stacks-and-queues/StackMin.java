import java.io.*;
import java.util.*;

/*
  Stack Min: How would you design a stack which, in addition to push and pop, has a 
  function min which returns the minimum element? Push, pop, and min should operate
  in O(1) time.
*/
class Solution {
    public static class Stack<T extends Comparable<T>> {
        private static class StackNode<T extends Comparable<T>> {
            private T data;
            private StackNode<T> next;

            // min
            private T min;

            public StackNode(T data) {
                this.data = data;

                // min
                this.min = data;
            }
        }

        private StackNode<T> top;

        public void push(T data) {
            StackNode<T> nodeToInsert = new StackNode<>(data);

            // min
            if (top != null) {
                if (top.min.compareTo(data) < 0) {
                    nodeToInsert.min = top.data;
                }
            }

            nodeToInsert.next = top;
            top = nodeToInsert;
        }

        public T pop() {
            if (top == null) {
                return null;
            }

            StackNode<T> popped = top;
            top = top.next;

            return popped.data;
        }

        public T min() {
            return top.min;
        }
    }

    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(1);
        stack.push(-1);
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
    }
}
