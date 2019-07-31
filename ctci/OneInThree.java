import java.io.*;
import java.util.*;

/*
  One in Three: Write a solution that would store three stacks in one array.
*/
class Solution {

    public static int sharedArray[] = new int[10], length = sharedArray.length;
    public static int waterLine1 = 0, waterLine2 = length / 3, waterLine3 = length - waterLine2;
    public static int size1 = 0, size2 = waterLine2, size3 = waterLine3;

    public static class Stack {
        public int id;

        public Stack(int id) {
            this.id = id;
        }

        public void push(int number) {
            if (id == 1) {
                if (size1 < waterLine2) {
                    sharedArray[size1++] = number;
                }
            } else if (id == 2) {
                if (size2 < waterLine3) {
                    sharedArray[size2++] = number;
                }
            } else {
                if (size3 < length) {
                    sharedArray[size3++] = number;
                }
            }
        }

        public int pop() {
            if (id == 1) {
                return sharedArray[--size1];
            } else if (id == 2) {
                return sharedArray[--size2];
            }

            return sharedArray[--size3];
        }

        public int peek() {
            if (id == 1) {
                return sharedArray[size1 - 1];
            } else if (id == 2) {
                return sharedArray[size2 - 1];
            }

            return sharedArray[size3 - 1];
        }
    }

    public static void main(String args[]) {
        Stack stack1 = new Stack(1);
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        System.out.println(stack1.peek());

        Stack stack2 = new Stack(2);
        stack2.push(4);
        stack2.push(5);
        stack2.push(6);
        stack2.push(7);
        System.out.println(stack2.peek());

        Stack stack3 = new Stack(3);
        stack3.push(8);
        stack3.push(9);
        stack3.push(10);
        System.out.println(stack3.peek());
    }
}
