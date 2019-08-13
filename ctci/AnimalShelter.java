import java.io.*;
import java.util.*;

/*
  Animal Shelter: Create a data structure to maintain a queue of cats and dogs. The interface
  must support adopting the oldest animal. The user can also select which of the oldest animals
  it would like, dog or cat.
*/
class Solution {
    public static enum Animal {
        DOG, CAT, NEITHER;
    }

    public static class Queue<T> {
        private class QueueNode<T> {
            private T data;
            private QueueNode<T> next;

            public QueueNode(T data) {
                this.data = data;
            }
        }

        private QueueNode<T> first;
        private QueueNode<T> last;

        public void add(T data) {
            QueueNode<T> nodeToAdd = new QueueNode<>(data);
            if (last != null) {
                last.next = nodeToAdd;
            }
            last = nodeToAdd;
            if (first == null) {
                first = last;
            }
        }

        public T remove(Animal animal) {
            if (first == null)
                return null;
            T data = first.data;

            if (animal != Animal.NEITHER) {
                QueueNode<T> next = first;
                while (next != null && data != animal) {
                    next = next.next;
                }
                if (next != null)
                    data = next.data;
                else
                    data = null;
            } else {
                first = first.next;
                if (last == null) {
                    first = null;
                }
            }

            return data;
        }

    }

    public static void main(String[] args) {
        Queue<Animal> queue = new Queue<>();
        queue.add(Animal.DOG);
        queue.add(Animal.CAT);
        queue.add(Animal.CAT);

        System.out.println(queue.remove(Animal.NEITHER));
        System.out.println(queue.remove(Animal.CAT));
        System.out.println(queue.remove(Animal.DOG));
    }
}
