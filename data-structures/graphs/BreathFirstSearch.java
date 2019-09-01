import java.io.*;
import java.util.*;

/*
  Graph - BFS.
*/
class Solution {
    public static class Graph {
        private int V;
        private LinkedList<Integer> adjListArray[];

        @SuppressWarnings("unchecked")
        public Graph(int V) {
            this.V = V;
            adjListArray = (LinkedList<Integer>[]) new LinkedList<?>[V];
            for (int i = 0; i < V; i++) {
                adjListArray[i] = new LinkedList<>();
            }
        }

        public void addEdge(int src, int dest) {
            // Undirected graph
            adjListArray[src].add(dest);
            adjListArray[dest].add(src);
        }

        public void printGraph() {
            for (int v = 0; v < V; v++) {
                System.out.println("Adjacency list of vertex " + v);
                System.out.print("head");
                for (Integer pCrawl : adjListArray[v]) {
                    System.out.print(" -> " + pCrawl);
                }
                System.out.println("\n");
            }
        }

        private void BFS(int vertex) {
            boolean visited[] = new boolean[V];
            Queue<Integer> q = new LinkedList<Integer>();
            q.add(vertex);
            visited[vertex] = true;

            while (!q.isEmpty()) {
                int i = q.remove();
                for (Integer j : adjListArray[i]) {
                    if (!visited[j]) {
                        q.add(j);
                        System.out.print(j + " ");
                        visited[j] = true;
                    }
                }
            }
        }
    }

    public static void main(String args[]) {
        int vertices = 5;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.printGraph();

        graph.BFS(2);
    }
}