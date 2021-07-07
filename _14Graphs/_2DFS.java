package _14Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//  https://www.youtube.com/watch?v=gHkOhnINlZo&list=PLNxqWc8Uj2LTb6VYJG3Kebwift2oaBFvE&index=5
//  notes @ https://photos.google.com/photo/AF1QipMLxG28a6yymKFzhmKjVw9N3Ls56z9au9AVYUg6
//  TC: O(V + E)
//  SC: O(V + E)
//  refer for TC & SC https://www.youtube.com/watch?v=N3P45XAfNHY&list=PLNxqWc8Uj2LTb6VYJG3Kebwift2oaBFvE&index=6
public class _2DFS {

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

        private void printAdjacencyList() {
            System.out.println("yup: AdjacencyList: ");
            for (int i = 0; i < adjacentVertices.length; i++) {
                LinkedList<Integer> list = adjacentVertices[i];
                System.out.print(i + ": ");
                for (Integer integer : list) {
                    System.out.print(integer + " ");
                }
                System.out.println();
            }
        }

        private List<Integer> DFS(int startVertex) {
            System.out.println("yup: DFS: ");
            boolean[] visited = new boolean[V];
            List<Integer> dfsRes = new ArrayList<>();
            dfsHelper(startVertex, visited, adjacentVertices, dfsRes);
            return dfsRes;
        }

        //  by pre order
        private void dfsHelper(int vertex, boolean[] visited, LinkedList<Integer>[] adjacentVertices, List<Integer> dfsRes) {
            dfsRes.add(vertex);
            System.out.print(vertex + " ");
            visited[vertex] = true;
            LinkedList<Integer> list = adjacentVertices[vertex];
            for (Integer integer : list) {
                if (!visited[integer]) {
                    dfsHelper(integer, visited, adjacentVertices, dfsRes);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 5);
        graph.addEdge(1, 4);
        graph.addEdge(4, 3);
        graph.addEdge(3, 5);
        graph.addEdge(4, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 5);
        graph.addEdge(5, 0);
        graph.printAdjacencyList();
        System.out.println("\nyup dfs List : " + graph.DFS(3));
    }
}
