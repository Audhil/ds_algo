package _14Graphs;

import java.util.LinkedList;

//  https://www.youtube.com/watch?v=dc5Pn-YEPVY&list=PLNxqWc8Uj2LTb6VYJG3Kebwift2oaBFvE&index=8
//  NOTES @ https://photos.google.com/photo/AF1QipNOMFdnF88FVOHZ88INWR5sjm_ZFGAIeX9iXoP7
public class _4IsCycleDetectedDirectedGraph {

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
            boolean[] ancestors = new boolean[V];
            for (int i = 0; i < visited.length; i++) {
                if (!visited[i])
                    if (helperFunc(visited, adjacentVertices, i, ancestors))
                        return true;
            }
            return false;
        }

        private boolean helperFunc(boolean[] visited, LinkedList<Integer>[] adjacentVertices, int startVertex, boolean[] ancestors) {
            visited[startVertex] = true;
            ancestors[startVertex] = true;  //  add current vertex in ancestor entry
            //  find adjacent vertices
            LinkedList<Integer> list = adjacentVertices[startVertex];
            for (Integer vertex : list) {
                //  not visited
                if (!visited[vertex])
                    return helperFunc(visited, adjacentVertices, vertex, ancestors);
                    //  visited
                else {
                    //  if the vertex is ancestor
                    if (ancestors[vertex])
                        return true;
                }
            }
            ancestors[startVertex] = false;
            return false;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        graph.printAdjacencyList();

        System.out.println("yup Is cycle detected: " + graph.isCycleDetectedUsingDFS());
    }
}
