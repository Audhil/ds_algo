package _16Trie;

//  https://youtu.be/dBGUmUQhjaM?list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp
public class _1Basics {

  private static class TNode {

    private final TNode[] links = new TNode[26];
    private boolean flag = false;


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
      flag = true;
    }

    public boolean isEnd() {
      return flag;
    }
  }

  private static class Trie {

    private final TNode root;

    public Trie() {
      root = new TNode();
    }

    //  TC: O (lenOfWord)
    private void insert(String word) {
      TNode temp = root;
      for (int i = 0; i < word.length(); i++) {
        char ch = word.charAt(i);
        if (!temp.containsKey(ch)) {
          temp.put(ch, new TNode());
        }
        //  move to reference trie node
        temp = temp.get(ch);
      }
      temp.setEnd();
    }

    //  TC: O (lenOfWord)
    private boolean search(String word) {
      TNode temp = root;
      for (char ch : word.toCharArray()) {
        if (!temp.containsKey(ch)) {
          return false;
        }
        temp = temp.get(ch);
      }
      return temp.isEnd();
    }

    //  TC: O (lenOfWord)
    private boolean startsWith(String word) {
      TNode temp = root;
      for (char ch : word.toCharArray()) {
        if (!temp.containsKey(ch)) {
          return false;
        }
        temp = temp.get(ch);
      }
      return true;
    }
  }

  public static void main(String[] args) {
    Trie trie = new Trie();
    String word = "apple";
    trie.insert(word);
    System.out.println("yup: is " + word + " : available: " + trie.search(word)); //  true
    System.out.println("yup: is " + word + " : startsWith: : " + trie.startsWith("app")); //  true
    System.out.println("yup: is " + word + " : startsWith: : " + trie.startsWith("bad")); //  false
    System.out.println("yup: is " + word + " : startsWith: : " + trie.startsWith("apd")); //  false
    System.out.println("yup: is " + word + " : startsWith: : " + trie.startsWith("appl"));  //  true
    System.out.println("yup: is " + word + " : startsWith: : " + trie.startsWith("apple")); //  true
    System.out.println(
        "yup: is " + word + " : startsWith: : " + trie.startsWith("applee"));  //  false
    System.out.println("yup: trying alternate version");
    word = "appd";
    trie.insert(word);
    System.out.println("yup: is " + word + " : available: " + trie.search(word)); //  true
    System.out.println("yup: is " + word + " : startsWith: : " + trie.startsWith("app")); //  true
    System.out.println("yup: is " + word + " : startsWith: : " + trie.startsWith("bad")); //  false
    System.out.println("yup: is " + word + " : startsWith: : " + trie.startsWith("apd")); //  false
    System.out.println("yup: is " + word + " : startsWith: : " + trie.startsWith("appl"));  //  true
    System.out.println("yup: is " + word + " : startsWith: : " + trie.startsWith("apple")); //  true
    System.out.println(
        "yup: is " + word + " : startsWith: : " + trie.startsWith("applee"));  //  false

    System.out.println("yup: is apple word : available: " + trie.search("apple")); //  true
    System.out.println("yup: is appd word : available: " + trie.search("appd")); //  true
  }
}
