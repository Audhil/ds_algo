package _10Blind75._8Trie._wordSearch;

import java.util.ArrayList;
import java.util.List;

//  solution link: https://www.youtube.com/watch?v=EmvsBM7o-5k&t=2s&ab_channel=TECHDOSE
//  https://www.youtube.com/watch?v=asbcE9mZz_U&ab_channel=NeetCode - some problem
//  https://leetcode.com/problems/word-search-ii/
public class _1WordSearchII_H {

  private static class TNode {

    private final TNode[] links = new TNode[26];

    public String getWord() {
      return word;
    }

    public void setWord(String word) {
      this.word = word;
    }

    public String word; //  for ease operation
    private boolean isEnd;

    private boolean containsKey(char ch) {
      return links[ch - 'a'] != null;
    }

    private void put(char ch, TNode tNode) {
      links[ch - 'a'] = tNode;
    }

    private TNode get(char ch) {
      return links[ch - 'a'];
    }

    private void setEnd() {
      isEnd = true;
    }

    private void unSetEnd() {
      isEnd = false;
    }

    private boolean getEnd() {
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
      for (char ch : word.toCharArray()) {
        if (!temp.containsKey(ch)) {
          temp.put(ch, new TNode());
        }
        temp = temp.get(ch);
      }
      temp.setWord(word);
      temp.setEnd();
    }
  }

  public static List<String> findWords(char[][] board, String[] words) {
    Trie trie = new Trie();
    for (String word : words) {
      trie.insert(word);
    }

    int row = board.length;
    int col = board[0].length;

    List<String> resList = new ArrayList<>();
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        dfs(i, j, trie.root, board, resList);
      }
    }
    return resList;
  }

  private static void dfs(int i, int j, TNode root, char[][] board, List<String> resList) {
    char ch = board[i][j];
    if (board[i][j] == '$' || root.get(ch) == null) {
      return;
    }
    root = root.get(ch);
    if (root.getEnd()) {
      resList.add(
          root.getWord()); //  since we saved the entire word, while inserting in trie - temp.setWord(word);
      root.unSetEnd();  //  we don't want the same word to be added in our result
    }
    //  no need to stop after we get a word, keep on iterating to get other words available in trie   //  trie may hold //  a->b and a->b->c as different words
    board[i][j] = '$';
    //  recursive dfs
    if (i > 0) {
      dfs(i - 1, j, root, board, resList);
    }
    if (i < board.length - 1) {
      dfs(i + 1, j, root, board, resList);
    }
    if (j > 0) {
      dfs(i, j - 1, root, board, resList);
    }
    if (j < board[0].length - 1) {
      dfs(i, j + 1, root, board, resList);
    }
    board[i][j] = ch;
  }

  public static void main(String[] args) {
    System.out.println("yup: 1st findWords: " + findWords(
        new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'},
            {'i', 'f', 'l', 'v'}},
        new String[]{"oath", "pea", "eat", "rain"})); //  yup: 1st findWords: [oath, eat]

    System.out.println("yup: 2nd findWords: " + findWords(
        new char[][]{{'a', 'b'}, {'c', 'd'}},
        new String[]{"abcb"})); //  yup: 2nd findWords: []
  }
}
