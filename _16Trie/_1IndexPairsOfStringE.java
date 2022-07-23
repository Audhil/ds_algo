package _16Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//  https://leetcode.com/problems/index-pairs-of-a-string/
//  https://www.youtube.com/watch?v=dFp1hdN2owg&ab_channel=RenZhang
public class _1IndexPairsOfStringE {

  /*
   * Given a "text" string and "words"(a list of strings),
   * return all index pairs [i, j] so that the substring text[i] .... text[j] is in the list of "words"
   *
   * eg 1:
   * text = "thestoryofleetcodeandme", words = ["story","fleet", "leetcode"]
   * output: [[3,7],[9,13],[10,17]]
   *
   * eg 2:
   * text = "ababa", words = ["aba","ab"]
   * output: [[0,1],[0,2],[2,3],[2,4]]
   * notice that matches can overlap, see "aba" is found in [0,2] & [2,4]
   * */

  private static class TNode {

    private final TNode[] links = new TNode[26];
    private boolean isEnd = false;

    public boolean containsKey(char ch) {
      return links[ch - 'a'] != null;
    }

    public void put(char ch, TNode tNode) {
      links[ch - 'a'] = tNode;
    }

    public TNode get(char ch) {
      return links[ch - 'a'];
    }

    public void setEnd() {
      isEnd = true;
    }

    public boolean isEnd() {
      return isEnd;
    }
  }

  private static class Trie {

    private final TNode root;

    public Trie() {
      root = new TNode();
    }

    private void insert(String word) {
      TNode temp = root;
      for (int index = 0; index < word.length(); index++) {
        char ch = word.charAt(index);
        if (!temp.containsKey(ch)) {
          temp.put(ch, new TNode());
        }
        temp = temp.get(ch);
      }
      temp.setEnd();
    }

    private void trieSearch(int i, int n, String text, List<List<Integer>> solution) {
      TNode temp = root;
      int j = i;
      while (j < n && temp.containsKey(text.charAt(j))) {
        temp = temp.get(text.charAt(j));
        if (temp.isEnd()) {
          solution.add(Arrays.asList(i, j));
        }
        j++;
      }
    }
  }

  private static List<List<Integer>> indexPairs(String text, List<String> words) {
    //  1. create trie with chars in "text"
    Trie trie = new Trie();
    //  O(K L), K is # words, L is max len of word
    for (String word : words) {
      trie.insert(word);
    }
    // 2. search words & return
    List<List<Integer>> resList = new ArrayList<>();
    int n = text.length();
    //  O(N * L)  N len of text, L is from trieSearch()
    for (int i = 0; i < n; i++) {
      trie.trieSearch(i, n, text, resList);
    }
    return resList;
  }

  public static void main(String[] args) {
    System.out.println("yup: finally answer: " + indexPairs("thestoryofleetcodeandme",
        Arrays.asList("story", "fleet", "leetcode",
            "me")));  //  yup: finally answer: [[3, 7], [9, 13], [10, 17], [21, 22]]
  }
}
