package _14Graphs;

import java.util.LinkedList;
import java.util.Stack;

//  https://www.youtube.com/watch?v=qe_pQCh09yU&ab_channel=TECHDOSE - topological sort + course schedule II
//  https://www.youtube.com/watch?v=eMVg3Gvnva4&list=PLNxqWc8Uj2LTb6VYJG3Kebwift2oaBFvE&index=9
public class _5TopologicalSort {

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

        private void DFS(int startVertex, Stack<Integer> stack) {
            boolean[] visited = new boolean[V];
//            from only one vertex
//            dfsHelper(startVertex, visited, adjacentVertices, stack);
            for (int i = 0; i < V; i++)
                if (!visited[i])
                    dfsHelper(i, visited, adjacentVertices, stack);
        }

        //  by pre order
        private void dfsHelper(int startVertex, boolean[] visited, LinkedList<Integer>[] adjacentVertices, Stack<Integer> stack) {
            visited[startVertex] = true;
            LinkedList<Integer> list = adjacentVertices[startVertex];
            for (Integer node : list) {
                if (!visited[node])
                    dfsHelper(node, visited, adjacentVertices, stack);
            }
            stack.push(startVertex);
        }

        //  performing topological sort using DFS
        private void topologicalSort(int startVertex) {
            Stack<Integer> stack = new Stack<>();
            DFS(startVertex, stack);
            System.out.println("after sorting: ");
            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(1, 0);
        graph.addEdge(2, 0);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
//        graph.printAdjacencyList();
        graph.topologicalSort(0);   //  let's start from vertex 1
    }
}
