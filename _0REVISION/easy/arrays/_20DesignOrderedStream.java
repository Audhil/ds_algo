package _0REVISION.easy.arrays;

import java.util.ArrayList;
import java.util.List;

//  https://leetcode.com/problems/design-an-ordered-stream/
public class _20DesignOrderedStream {

  private static class OrderedStream {

    private final String[] arr;
    private int ptr = 0;

    public OrderedStream(int n) {
      arr = new String[n];
    }

    public List<String> insert(int idKey, String value) {
      List<String> list = new ArrayList<>();
      arr[idKey - 1] = value;
      while (ptr < arr.length && arr[ptr] != null) {
        list.add(arr[ptr++]);
      }
      return list;
    }

    public List<String> revision(int idKey, String value) {
      List<String> resList = new ArrayList<>();
      arr[idKey - 1] = value;
      while (ptr < arr.length && arr[ptr] != null) {
        resList.add(arr[ptr++]);
      }
      return resList;
    }
  }

  public static void main(String[] args) {
    OrderedStream orderedStream = new OrderedStream(5);
    System.out.println(orderedStream.insert(3, "ccccc"));   //  []
    System.out.println(orderedStream.insert(1, "aaaaa"));   //  [aaaaa]
    System.out.println(orderedStream.insert(2, "bbbbb"));   //  [bbbbb, ccccc]
    System.out.println(orderedStream.insert(5, "eeeee"));   //  []
    System.out.println(orderedStream.insert(4, "ddddd"));   //  [ddddd, eeeee]
  }
}
