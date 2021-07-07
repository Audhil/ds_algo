package _14Graphs;

import java.util.LinkedList;

//  https://www.youtube.com/watch?v=7VlwS1XRStY&list=PLNxqWc8Uj2LTb6VYJG3Kebwift2oaBFvE&index=4
//  Breadth first search
//  notes @ https://photos.google.com/album/AF1QipMLL_acuhN6YogZ1XMenF02iNt7vVctR7ZvlyE_/photo/AF1QipNHSrAzCu-lzJdcTR9R-76i98TFqtPPaS-wLKMJ
//  TC: O(V + E)
//  SC: O(V + E)
//  refer for TC & SC https://www.youtube.com/watch?v=N3P45XAfNHY&list=PLNxqWc8Uj2LTb6VYJG3Kebwift2oaBFvE&index=6
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
        LinkedList<Integer>[] adjacentVertices;

        public Graph(int v) {
            V = v;
            adjacentVertices = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                adjacentVertices[i] = new LinkedList<>();
            }
        }

        private void addEdge(int vertex, int neighbourVertex) {
            adjacentVertices[vertex].add(neighbourVertex);
        }

        private void BFS(int startVertex) {
            LinkedList<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[V];

            visited[startVertex] = true;
            queue.add(startVertex);

            while (!queue.isEmpty()) {
                int item = queue.poll();
                System.out.print(item + " ");

                LinkedList<Integer> neighbourVertices = adjacentVertices[item];
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
