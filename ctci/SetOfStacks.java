import java.io.*;
import java.util.*;

/*
  Stack of plates: Imagine a stack of plates. If the stack gets too high, it might topple.
  Therefore, in real life, we would likely start a new stack when the previous stack
  exceeds some threshold. Implement a data structure SetOfStacks that mimics this. SetOfStacks
  should be composed of several stacks and should create a new stack once the previous one 
  exceeds capacity.
*/
class Solution {

    public static class Stack<T extends Comparable<T>> {
        private static class StackNode<T extends Comparable<T>> {
            private T data;
            private StackNode<T> next;

            public StackNode(T data) {
                this.data = data;
            }
        }

        private StackNode<T> top;
        private int count = 0;

        public void push(T data) {
            StackNode<T> nodeToInsert = new StackNode<>(data);
            nodeToInsert.next = top;
            top = nodeToInsert;
            count++;
        }

        public T pop() {
            if (top == null) {
                return null;
            }

            StackNode<T> popped = top;
            top = top.next;
            count--;

            return popped.data;
        }

        public boolean isEmpty() {
            return top == null;
        }

        public int getCount() {
            return count;
        }
    }

    public static class SetOfStacks<T extends Comparable<T>> {
        private static int THRESHOLD_COUNT = 3;
        private int count = 0;
        private ArrayList<Stack<T>> stacks = new ArrayList<Stack<T>>();

        public void push(T data) {
            Stack<T> stackToPushOn = null;

            if (stacks.isEmpty()) {
                stackToPushOn = new Stack<T>();
                stacks.add(stackToPushOn);
            } else {
                stackToPushOn = stacks.get(count);
            }

            if (stackToPushOn.getCount() >= THRESHOLD_COUNT) {
                count++;
                stackToPushOn = new Stack<T>();
                stacks.add(stackToPushOn);
            }

            stackToPushOn.push(data);
        }

        public T pop() {
            Stack<T> stackToPop = null;

            if (stacks.isEmpty()) {
                return null;
            } else {
                stackToPop = stacks.get(count);
            }

            if (stackToPop.isEmpty()) {
                count--;
                stacks.remove(stacks.size() - 1);
                stackToPop = stacks.get(count);
            }

            return stackToPop.pop();
        }
    }

    public static void main(String args[]) {
        SetOfStacks<Integer> set = new SetOfStacks<>();
        set.push(1);
        set.push(2);
        set.push(3);
        set.push(4);
        set.push(5);
        set.push(6);

        System.out.println(set.pop());
        System.out.println(set.pop());
        System.out.println(set.pop());
        System.out.println(set.pop());
        System.out.println(set.pop());
        System.out.println(set.pop());
    }
}
