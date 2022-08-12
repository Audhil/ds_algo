package _0REVISION.easy.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/find-anagram-mappings/
https://www.lintcode.com/problem/813/
813 · Find Anagram Mappings

* Given two lists A and B, and B is an anagram of A. B is an anagram of A means B is made by randomizing the order of the elements in A.
We want to find an index mapping P, from A to B. A mapping P[i] = j means the ith element in A appears in B at index j.
These lists A and B may contain duplicates. If there are multiple answers, output any of them.

Input:  A = [12, 28, 46, 32, 50] and B = [50, 12, 32, 46, 28]
Output: [1, 4, 3, 2, 0]
Explanation:
As P[0] = 1 because the 0th element of A appears at B[1], and P[1] = 4 because the 1st element of A appears at B[4], and so on.
Example2
* */
public class _18FindAnagramMapping {

  public static int[] revision(int[] A, int[] B) {
    if (A.length != B.length) {
      return null;
    }
    Map<Integer, Integer> cMap = new HashMap<>();
    for (int i = 0; i < B.length; i++) {
      cMap.put(B[i], i);
    }
    for (int i = 0; i < A.length; i++) {
      A[i] = cMap.get(A[i]);
    }
    return A;
  }

  public static int[] anagramMappings(int[] A, int[] B) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < B.length; i++) {
      map.put(B[i], i);
    }
    for (int i = 0; i < A.length; i++) {
      A[i] = map.get(A[i]);
    }
    return A;
  }

  public static void main(String[] args) {
    System.out.println("yup: _18FindAnagramMapping: " + Arrays.toString(
        anagramMappings(new int[]{12, 28, 46, 32, 50}, new int[]{50, 12, 32, 46, 28})));
    System.out.println("yup: _18FindAnagramMapping: " + Arrays.toString(
        anagramMappings(new int[]{1, 2, 3, 4, 5}, new int[]{5, 4, 3, 2, 1})));
  }
}
