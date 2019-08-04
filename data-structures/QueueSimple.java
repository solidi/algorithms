import java.io.*;
import java.util.*;

class Solution {
    public static class Queue<T> {
        private static class QueueItem<T> {
            private T data;
            private QueueItem<T> next;

            public QueueItem(T data) {
                this.data = data;
            }
        }

        private QueueItem<T> first;
        private QueueItem<T> last;

        public void add(T data) {
            QueueItem<T> item = new QueueItem<>(data);
            if (last != null) {
                last.next = item;
            }
            last = item;
            if (first == null) {
                first = last;
            }
        }

        public T remove() {
            QueueItem<T> item = first;
            if (first != null) {
                first = first.next;
            }
            if (first == null) {
                last = null;
            }
            return item == null ? null : item.data;
        }

        public T peek() {
            return first == null ? null : first.data;
        }

        public boolean isEmpty() {
            return first == null;
        }
    }

    public static void main(String args[]) {
        Queue<Integer> queue = new Queue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.isEmpty());
        System.out.println(queue.remove());
        System.out.println(queue.peek());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        queue.add(6);
        System.out.println(queue.remove());
    }
}
