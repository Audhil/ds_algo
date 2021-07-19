package _14Graphs;

public class _0Basics {
    /*
    * https://www.youtube.com/watch?v=EiR9w6kA_4M&list=PLNxqWc8Uj2LTb6VYJG3Kebwift2oaBFvE&index=6
    * 1. edges - no of edges = (v(v-1))/2
    * 2. types of graph - directional / un directional & weighted / unweighted
    * 3. Indegree - no of edges pointing to single point, Outdegree - no of edges moving away from a point
    * 4. bridge - edge connecting 2 graphs together - ie., by removing 1 edge, bigger graph will become 2 graphs
    * 5. articulation point - vertex connecting 2 graphs together - ie., by removing 1 edge, bigger graph will become 2 graphs
    * 6. spanning tree - (v, e) -> (v, v-1) - v vertices & v-1 edges
    *
    * Representation
    *
    * 1. Adjacency matrix
    * (i, j) -> edge
    * a[i][j] -> O(1) -> to find edge is available
    * neighbours -> O(V)
    * space - O(v^2)
    * constructing - O(v^2)
    *
    * 2. Adjacency list
    *   a. Map<Int, List<Int>>
        b. List<List<Int>>
    * edge -> O(neighbours)
    * space - O(v + e)
    * constructing - O(v + e)
    *
    * 3. edge list
    * [(1,2),(0,2),(1,3),(2,1),(0,2)]
    *
    * edge -> O(e)
    * space - O(e)
    * traversing - O(e)
    * */
}
