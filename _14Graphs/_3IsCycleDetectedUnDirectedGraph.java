package _14Graphs;

import java.util.LinkedList;

//  https://www.youtube.com/watch?v=GLGsIZGLvA0&list=PLNxqWc8Uj2LTb6VYJG3Kebwift2oaBFvE&index=8
//  notes @ https://photos.google.com/photo/AF1QipOC3so2pwlvv3tUWw778S4kq0QZCB4kFhbYVXCP
public class _3IsCycleDetectedUnDirectedGraph {

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

        private boolean isCycleDetectedUsingDFS() {
            boolean[] visited = new boolean[V];
            for (int i = 0; i < visited.length; i++) {
                if (!visited[i])
                    if (helperFunc(visited, adjacentVertices, i, -1))
                        return true;
            }
            return false;
        }

        private boolean helperFunc(boolean[] visited, LinkedList<Integer>[] adjacentVertices, int startVertex, int parent) {
            visited[startVertex] = true;
            //  find adjacent vertices
            LinkedList<Integer> list = adjacentVertices[startVertex];
            for (Integer vertex : list) {
                //  not visited
                if (!visited[vertex])
                    return helperFunc(visited, adjacentVertices, vertex, startVertex);
                    //  visited
                else {
                    //  cycle detected
                    if (startVertex != parent)
                        return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1);
        graph.printAdjacencyList();

        System.out.println("yup Is cycle detected: " + graph.isCycleDetectedUsingDFS());
    }
}
