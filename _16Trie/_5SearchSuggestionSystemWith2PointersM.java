package _16Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//  https://leetcode.com/problems/search-suggestions-system/
//  https://www.youtube.com/watch?v=D4T2N0yAr20&ab_channel=NeetCode
public class _5SearchSuggestionSystemWith2PointersM {

  public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
    //  O (n log n)
    Arrays.sort(products);  //  sorting lexicographically
    List<List<String>> resList = new ArrayList<>();
    //  2 pointers
    int l = 0, r = products.length - 1;
    for (int i = 0; i < searchWord.length(); i++) {
      char sch = searchWord.charAt(i);  //  char at search str
      //  move left pointer if needed
      //  notes: products[l].length() <= i || products[l].charAt(i) != sch ->
      //  if the given product(at l) length is less than i, or if ith the char of product(at l) doesn't matches with search ch
      while (l <= r && (products[l].length() <= i || products[l].charAt(i) != sch)) {
        l++;
      }
      //  move right pointer if needed
      while (l <= r && (products[r].length() <= i || products[r].charAt(i) != sch)) {
        r--;
      }
      int remaining = r - l + 1;
      //  Math.min(3, remaining) - what if remaining words are less than 3
      List<String> tempList = new ArrayList<>();
      for (int j = 0; j < Math.min(3, remaining); j++) {
        tempList.add(products[l + j]);
      }
      resList.add(tempList);
    }
    return resList;
  }

  public static void main(String[] args) {
    //  [[mobile, moneypot, monitor], [mobile, moneypot, monitor], [mouse, mousepad], [mouse, mousepad], [mouse, mousepad]]
    System.out.println(
        suggestedProducts(new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"},
            "mouse"));

    //  [[baggage, bags, banner], [baggage, bags, banner], [baggage, bags], [bags]]
    System.out.println(
        suggestedProducts(new String[]{"bags", "baggage", "banner", "box", "cloths"},
            "bags"));

    //  [[havana], [havana], [havana], [havana], [havana], [havana]]
    System.out.println(
        suggestedProducts(new String[]{"havana"},
            "havana"));
  }
}
