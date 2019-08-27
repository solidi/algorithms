import java.io.*;
import java.util.*;

/*
  Graph - Adjacency Matrix.
  https://opendatastructures.org/ods-java/12_1_AdjacencyMatrix_Repres.html
*/
class Solution {
    public static class Graph {
        private int size;
        private boolean[][] array;

        public Graph(int size) {
            this.size = size;
            array = new boolean[size][size];
        }

        public void addEdge(int i, int j) {
            array[i][j] = true;
        }

        public void removeEdge(int i, int j) {
            array[i][j] = false;
        }

        public boolean hasEdge(int i, int j) {
            return array[i][j];
        }

        public void print() {
            for (int i = 0; i < size; i++) {
                System.out.print(i + ": ");
                for (int j = 0; j < size; j++) {
                    System.out.print(array[i][j] + " ");
                }
                System.out.println();
            }
        }

        public List<Integer> outEdges(int i) {
            List<Integer> edges = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                if (array[i][j]) {
                    edges.add(j);
                }
            }
            return edges;
        }

        public List<Integer> inEdges(int i) {
            List<Integer> edges = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                if (array[j][i]) {
                    edges.add(j);
                }
            }
            return edges;
        }
    }

    public static void main(String args[]) {
        int size = 5;
        Graph graph = new Graph(size);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.print();
    }
}
