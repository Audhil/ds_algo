package _10Blind75._11Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

//  https://www.lintcode.com/problem/892/
//  https://www.youtube.com/watch?v=ef95J3BNbls&ab_channel=LCBear - not worked
//  https://www.youtube.com/watch?v=6kTZYvNNyps&t=1128s&ab_channel=NeetCode - for DFS explanation
//  based on: https://www.youtube.com/watch?v=L5n9AA7cHDY&ab_channel=codeTree
public class _9AlienDictionaryH_TopologicalSort_BFS_KahnsAlgo {

  public static String revision(String[] words) {
    Map<Character, Set<Character>> adjMap = new HashMap<>();
    Map<Character, Integer> inDegreeMap = new HashMap<>();

    for (String word : words) {

      for (char ch : word.toCharArray()) {
        adjMap.put(ch, new HashSet<>());
        inDegreeMap.put(ch, 0);
      }
    }

    //  build edges
    for (int i = 0; i < words.length - 1; i++) {
      int j = i + 1;
      int k = 0;
      String fStr = words[i];
      String sStr = words[j];
      if (fStr.length() > sStr.length() && fStr.startsWith(sStr)) {
        return "";
      }
      while (k < fStr.length() && k < sStr.length()) {
        char firstChar = fStr.charAt(k);
        char secondChar = sStr.charAt(k);
        if (firstChar != secondChar) {
          adjMap.get(firstChar).add(secondChar);
          break;
        }
        k++;
      }
    }

    //  build inDegree
    for (char key : adjMap.keySet()) {
      for (char neighbour : adjMap.get(key)) {
        inDegreeMap.put(neighbour, inDegreeMap.get(neighbour) + 1);
      }
    }

    //  topological sort - Kahn's algo
    PriorityQueue<Character> queue = new PriorityQueue<>();
    for (char ch : inDegreeMap.keySet()) {
      if (inDegreeMap.get(ch) == 0) {
        queue.add(ch);
      }
    }

    StringBuilder sBuilder = new StringBuilder();
    while (!queue.isEmpty()) {
      char temp = queue.poll();
      sBuilder.append(temp);
      for (char ch : adjMap.get(temp)) {
        inDegreeMap.put(ch, inDegreeMap.get(ch) - 1);
        if (inDegreeMap.get(ch) == 0) {
          queue.add(ch);
        }
      }
    }

    return sBuilder.length() == adjMap.keySet().size() ? sBuilder.toString() : "";
  }

  // solving based on kahn's algo
  public static String alienOrder(String[] words) {
    // Write your code here
    if (words == null || words.length == 0) {
      return "";
    }

    Map<Character, Set<Character>> neighbors = new HashMap<>();
    Map<Character, Integer> indegrees = new HashMap<>();

    // build graph
    // build nodes
    for (int i = 0; i < words.length; i++) {
      if (i + 1 < words.length && words[i].startsWith(words[i + 1])) {
        return "";
      }

      for (int j = 0; j < words[i].length(); j++) {
//        if (!neighbors.containsKey(words[i].charAt(j)))
        neighbors.put(words[i].charAt(j), new HashSet<Character>());
        indegrees.put(words[i].charAt(j), 0);
      }
    }

    // build edges
    for (int i = 0; i < words.length - 1; i++) {
      int j = i + 1;
      int k = 0;
      while (k < words[i].length() && k < words[j].length()) {
        if (words[i].charAt(k) != words[j].charAt(k)) {
          neighbors.get(words[i].charAt(k)).add(words[j].charAt(k));
          break;
        }
        k++;
      }
    }

    // build indegrees
    for (char key : neighbors.keySet()) {
      for (char neighbor : neighbors.get(key)) {
        indegrees.put(neighbor, indegrees.get(neighbor) + 1);
      }
    }

    // toplogical sorting
    PriorityQueue<Character> queue = new PriorityQueue<>();

    for (char key : indegrees.keySet()) {
      if (indegrees.get(key) == 0) {
        queue.add(key);
      }
    }

    StringBuilder res = new StringBuilder();
    while (!queue.isEmpty()) {
      char cur = queue.remove();
      res.append(cur);

      for (char neighbor : neighbors.get(cur)) {
        int new_indegree = indegrees.get(neighbor) - 1;
        if (new_indegree == 0) {
          queue.add(neighbor);
        }
        indegrees.put(neighbor, new_indegree);
      }
    }
    return neighbors.keySet().size() != res.length() ? "" : res.toString();
  }

  public static void main(String[] args) {
    String[] strs = {"wrt", "wrf", "er", "ett", "rftt"};
    System.out.println("yup: alien dictionary: " + alienOrder(strs)); //  wertf
    System.out.println("yup: alien dictionary: " + revision(strs)); //  wertf
    strs = new String[]{"z", "x"};
    System.out.println("yup: 2nd alien dictionary: " + alienOrder(strs)); //  zx
    System.out.println("yup: 2nd alien dictionary: " + revision(strs)); //  zx
  }
}
