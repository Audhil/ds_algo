package _16Trie.bit_manipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//  https://www.youtube.com/watch?v=Q8LhG9Pi5KM&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp&index=8&ab_channel=takeUforward
//  https://www.codingninjas.com/codestudio/problems/max-xor-queries_1382020?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_tries_videos
public class _6MaxXORQueries_H {

  private static class TNode {

    private final TNode[] links = new TNode[2];

    public boolean containsKey(int bit) {
      return links[bit] != null;
    }

    public void insert(int bit, TNode tNode) {
      links[bit] = tNode;
    }

    public TNode get(int bit) {
      return links[bit];
    }
  }

  private static class Trie {

    private final TNode root;

    public Trie() {
      root = new TNode();
    }

    private void insert(int num) {
      TNode temp = root;
      for (int i = 31; i >= 0; i--) {
        int bit = (num >> i) & i;
        if (!temp.containsKey(bit)) {
          temp.insert(bit, new TNode());
        }
        temp = temp.get(bit);
      }
    }

    public int getMax(int num) {
      TNode temp = root;
      int maxNum = 0;
      for (int i = 31; i >= 0; i--) {
        int bit = (num >> i) & 1;
        System.out.println("yup: bit: " + bit);
        int oppositeBit = 1 - bit;
        if (temp.containsKey(oppositeBit)) {
          maxNum = maxNum | (1 << i);
          temp = temp.get(oppositeBit);
        } else {
          temp = temp.get(bit);
        }
      }
      return maxNum;
    }
  }

  //  query(Xi, Ai)
  private static List<Integer> maxXORQueries(List<Integer> arr, List<List<Integer>> queries) {
    //  1. sort the given arr
    Collections.sort(arr);
    int n = arr.size();
    //  2. sort queries based on Ai
    List<List<Integer>> offlineQueries = new ArrayList<>();
    int m = queries.size();
    for (int i = 0; i < m; i++) {
      List<Integer> temp = new ArrayList<>();
      temp.add(queries.get(i).get(1));  //  Ai
      temp.add(queries.get(i).get(0));  //  Xi
      temp.add(i);  //  index
      offlineQueries.add(temp);
    }
    offlineQueries.sort(Comparator.comparing(o -> o.get(0))); //  sort based on Ai
    //  3. add num in trie, and XOR get the result
    List<Integer> result = new ArrayList<>(m);
    Trie trie = new Trie();
    int index = 0;
    //  fill with -1, as given in question
    for (int i = 0; i < m; i++) {
      result.add(-1);
    }
    for (List<Integer> query : offlineQueries) {
      while (index < n && arr.get(index) <= query.get(0)) {
        trie.insert(arr.get(index));
        index++;
      }
      int maxXor = trie.getMax(query.get(1)); //  query.get(1) holds Xi
      int queryIndex = query.get(2);  //  query.get(2) holds query index
      if (index != 0) {
        result.set(queryIndex, maxXor);
      } else {
        result.set(queryIndex, -1);
      }
    }
    return result;
  }

//  public static ArrayList<Integer> maxXORQueries(List<Integer> arr,
//      List<List<Integer>> queries) {
//    Collections.sort(arr);
//    ArrayList<ArrayList<Integer>> offlineQueries = new ArrayList<ArrayList<Integer>>();
//    int m = queries.size();
//    for (int i = 0; i < m; i++) {
//      ArrayList<Integer> temp = new ArrayList<Integer>();
//      temp.add(queries.get(i).get(1));
//      temp.add(queries.get(i).get(0));
//      temp.add(i);
//      offlineQueries.add(temp);
//    }
//    Collections.sort(offlineQueries, new Comparator<ArrayList<Integer>>() {
//      @Override
//      public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
//        return a.get(0).compareTo(b.get(0));
//      }
//    });
//    int ind = 0;
//    int n = arr.size();
//    Trie trie = new Trie();
//    ArrayList<Integer> ans = new ArrayList<Integer>(m);
//    for (int i = 0; i < m; i++) {
//      ans.add(-1);
//    }
//    for (int i = 0; i < m; i++) {
//      while (ind < n && arr.get(ind) <= offlineQueries.get(i).get(0)) {
//        trie.insert(arr.get(ind));
//        ind++;
//      }
//      int queryInd = offlineQueries.get(i).get(2);
//      if (ind != 0) {
//        ans.set(queryInd, trie.getMax(offlineQueries.get(i).get(1)));
//      } else {
//        ans.set(queryInd, -1);
//      }
//    }
//    return ans;
//  }

  public static void main(String[] args) {
    //  Q1
//    List<Integer> arr = Arrays.asList(0, 1, 2, 3, 4);
//    List<List<Integer>> queries = new ArrayList<>();
//    queries.add(Arrays.asList(1, 3));
//    queries.add(Arrays.asList(5, 6));
//    System.out.println("yup: 1st _6MaxXORQueries_H: " + maxXORQueries(arr, queries));
    //  Q2
//    List<Integer> arr = Arrays.asList(1);
//    List<List<Integer>> queries = new ArrayList<>();
//    queries.add(Arrays.asList(1, 0));
//    System.out.println("yup: 2nd _6MaxXORQueries_H: " + maxXORQueries(arr, queries));
    //  Q3
//    List<Integer> arr = Arrays.asList(6, 6, 3, 5, 2, 4);
//    List<List<Integer>> queries = new ArrayList<>();
//    queries.add(Arrays.asList(6, 3));
//    queries.add(Arrays.asList(8, 1));
//    queries.add(Arrays.asList(12, 4));
//    System.out.println("yup: 3rd _6MaxXORQueries_H: " + maxXORQueries(arr, queries));
    //  Q4
    List<Integer> arr = Arrays.asList(0, 0, 0, 0, 0);
    List<List<Integer>> queries = new ArrayList<>();
    queries.add(Arrays.asList(1, 0));
    queries.add(Arrays.asList(1, 1));
    System.out.println("yup: 4th _6MaxXORQueries_H: " + maxXORQueries(arr, queries));
  }
}
