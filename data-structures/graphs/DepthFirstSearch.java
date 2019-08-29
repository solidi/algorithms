import java.io.*;
import java.util.*;

/*
  Graph - DFS.
  https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
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

        private void DFSUtil(int v, boolean visited[]) {
            visited[v] = true;
            System.out.print(v + " ");

            Iterator<Integer> i = adjListArray[v].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    DFSUtil(n, visited);
                }
            }
        }

        public void DFS(int v) {
            boolean visited[] = new boolean[V];
            DFSUtil(v, visited);
        }
    }

    public static void main(String args[]) {
        int V = 5;
        Graph graph = new Graph(V);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.printGraph();

        graph.DFS(2);
    }
}
