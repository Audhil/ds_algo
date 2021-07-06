package _14Graphs;

import java.util.LinkedList;

//  https://www.youtube.com/watch?v=7VlwS1XRStY&list=PLNxqWc8Uj2LTb6VYJG3Kebwift2oaBFvE&index=4
//  Breadth first search
public class _1BFS {

    /*
    * points
    * 1. make a queue
    * 2. while q is not empty:
    *       take front of queue
    *       remove front of queue
    *       add it to output, make visited true
    *       not visited add in queue
    * */

    //  https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
    private static class Graph {
        int V;
        LinkedList<Integer>[] adjacentEdges;

        public Graph(int v) {
            V = v;
            adjacentEdges = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                adjacentEdges[i] = new LinkedList<>();
            }
        }

        private void addEdge(int vertex, int neighbourVertex) {
            adjacentEdges[vertex].add(neighbourVertex);
        }

        private void BFS(int vertex) {
            LinkedList<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[V];

            visited[vertex] = true;
            queue.add(vertex);

            while (!queue.isEmpty()) {
                int item = queue.poll();
                System.out.print(item + " ");

                LinkedList<Integer> neighbourVertices = adjacentEdges[item];
                for (Integer nVertex : neighbourVertices) {
                    if (!visited[nVertex]) {
                        visited[nVertex] = true;
                        queue.add(nVertex);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);

        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(2,0);
        graph.addEdge(2,3);
        graph.addEdge(3,3);

        System.out.println("BFS from vertex: 2");
        graph.BFS(2);
    }
}
