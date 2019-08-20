import java.io.*;
import java.util.*;

/*
  Binary Min-Heap Insert.
  http://www.algolist.net/Data_structures/Binary_heap/Insertion
  https://www.geeksforgeeks.org/binary-heap/
  
  array[(currentNodeIndex - 1) / 2]  Returns the parent node
  array[(2 * currentNodeIndex) + 1]  Returns the left child node
  array[(2 * currentNodeIndex) + 2]  Returns the right child node
*/
class Solution {
    public static class BinaryMinHeap {
        private int heapSize;
        private int data[];

        public BinaryMinHeap(int size) {
            data = new int[size];
        }

        public void insert(int value) {
            if (heapSize == data.length) {
                System.out.println("Heap's underlying storage is overflow");
            } else {
                heapSize++;
                data[heapSize - 1] = value;
                siftUp(heapSize - 1);
            }
        }

        private int getParentIndex(int nodeIndex) {
            return (nodeIndex - 1) / 2;
        }

        private void siftUp(int nodeIndex) {
            int parentIndex, temp;

            if (nodeIndex == 0) {
                return;
            }

            parentIndex = getParentIndex(nodeIndex);

            if (data[parentIndex] > data[nodeIndex]) {
                temp = data[parentIndex];
                data[parentIndex] = data[nodeIndex];
                data[nodeIndex] = temp;
                siftUp(parentIndex);
            }
        }

        private void print() {
            for (int i = 0; i < heapSize; i++) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        BinaryMinHeap heap = new BinaryMinHeap(10);
        heap.insert(9);
        heap.insert(4);
        heap.insert(32);
        heap.print();
        heap.insert(2);
        heap.insert(22);
        heap.insert(18);
        heap.insert(1);
        heap.print();
    }
}
