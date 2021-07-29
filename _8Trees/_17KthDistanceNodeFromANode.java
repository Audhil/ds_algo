package _8Trees;

import java.util.*;

//  https://www.youtube.com/watch?v=pMYN_j4FD2M&list=PLNxqWc8Uj2LRbsOlBiPJZAyZpaUwdDepd&index=21
//  java: https://www.youtube.com/watch?v=xiXWEUvoon4
public class _17KthDistanceNodeFromANode {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    private static List<Integer> findKthDistanceNodesFromNode(TreeNode root, int targetValue, int k) {
        //  1 - generate parentMap - purpose of parentMap, we cannot traverse to parent back with BFS
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        generateParentMap(root, null, parentMap);
        //  2 - DFS - reach the node
        TreeNode reachedNode = reachNodeWithDFS(root, targetValue);
        //  3 - BFS - find nodes, including parent
        return findNodesWithBFS(reachedNode, parentMap, k);
    }

    //  next level
    private static void nextLevel(LinkedList<TreeNode> queue, Set<TreeNode> visitedSet, Map<TreeNode, TreeNode> parentMap) {
        while (true) {
            TreeNode tempNode = queue.poll();
            //  each level is ended with null,
            //  this indicates we reached end of a level
            if (tempNode == null) {
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
                return;
            }
            if (tempNode.left != null && !visitedSet.contains(tempNode.left)) {
                queue.add(tempNode.left);
                visitedSet.add(tempNode.left);
            }
            if (tempNode.right != null && !visitedSet.contains(tempNode.right)) {
                queue.add(tempNode.right);
                visitedSet.add(tempNode.right);
            }
            if (parentMap.get(tempNode) != null && !visitedSet.contains(parentMap.get(tempNode))) {
                queue.add(parentMap.get(tempNode));
                visitedSet.add(parentMap.get(tempNode));
            }
        }
    }

    //  BFS - find nodes at k distance from given node
    private static List<Integer> findNodesWithBFS(TreeNode reachedNode, Map<TreeNode, TreeNode> parentMap, int k) {
        List<Integer> nodeList = new ArrayList<>();
        if (reachedNode == null) {
            System.out.println("yup: 1");
            return nodeList;
        }
        int level = 0;
        Set<TreeNode> visitedSet = new HashSet<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(reachedNode);
        visitedSet.add(reachedNode);
        queue.add(null);

        while (!queue.isEmpty()) {
            if (level == k) {
                while (!queue.isEmpty()) {
                    TreeNode tempNode = queue.poll();
                    if (tempNode != null) {
                        nodeList.add(tempNode.value);
                    }
                }
                nodeList.sort((o1, o2) -> o1 - o2);
                return nodeList;
            }
            level++;
            nextLevel(queue, visitedSet, parentMap);
        }
        return nodeList;
    }

    //  DFS - reach the node with preOrder traversal
    private static TreeNode reachNodeWithDFS(TreeNode root, int targetValue) {
        if (root == null)
            return null;

        if (root.value == targetValue)
            return root;

        TreeNode left = reachNodeWithDFS(root.left, targetValue);
        TreeNode right = reachNodeWithDFS(root.right, targetValue);

        if (left != null)
            return left;

        return right;
    }


    //  generate parentMap
    private static void generateParentMap(TreeNode root, TreeNode parentNode, Map<TreeNode, TreeNode> parentMap) {
        if (root == null)
            return;
        parentMap.put(root, parentNode);
        generateParentMap(root.left, root, parentMap);
        generateParentMap(root.right, root, parentMap);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(6);
        root.left.right.left.left = new TreeNode(8);

        int k = 2, nodeValue = 5;
        List<Integer> nodes = findKthDistanceNodesFromNode(root, nodeValue, k);
        System.out.println("nodes at k = " + k + " distance are,");
        nodes.forEach(node -> System.out.print(node + " "));
        /*
        from node 5,
        k = 0; nodeList: 5
        k = 1; nodeList: 2 6 7
        k = 2; nodeList: 1 4 8
        k = 3; nodeList: 3
        k = 4; nodeList:[] ....
        * */
    }
}
