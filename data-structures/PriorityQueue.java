import java.io.*;
import java.util.*;

class Solution {
    public static class Task {
        String job;
        int priority;

        public Task(String job, int priority) {
            this.job = job;
            this.priority = priority;
        }

        public String toString() {
            return "Job Name : " + job + "\nPriority : " + priority;
        }
    }

    public static class PriorityQueue {
        private Task[] heap;
        private int heapSize, capacity;

        public PriorityQueue(int capacity) {
            this.capacity = capacity + 1;
            heap = new Task[this.capacity];
            heapSize = 0;
        }

        public void clear() {
            heap = new Task[capacity];
            heapSize = 0;
        }

        public void insert(String job, int priority) {
            Task newJob = new Task(job, priority);
            heap[++heapSize] = newJob;
            int pos = heapSize;

            while (pos != 1 && newJob.priority > heap[pos / 2].priority) {
                heap[pos] = heap[pos / 2];
                pos /= 2;
            }

            heap[pos] = newJob;
        }

        public Task remove() {
            int parent = 1, child = 2;
            Task item, temp;

            if (heapSize == 0) {
                System.out.println("Heap is empty");
                return null;
            }

            item = heap[1];
            temp = heap[heapSize--];

            while (child <= heapSize) {
                if (child < heapSize && heap[child].priority < heap[child + 1].priority)
                    child++;
                if (temp.priority >= heap[child].priority)
                    break;

                heap[parent] = heap[child];
                parent = child;
                child *= 2;
            }
            heap[parent] = temp;

            return item;
        }
    }

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue(10);
        pq.insert("job", 1);
        pq.insert("job", 40);
        pq.insert("job", 3);
        System.out.println(pq.remove());
        System.out.println(pq.remove());
        System.out.println(pq.remove());
    }
}
