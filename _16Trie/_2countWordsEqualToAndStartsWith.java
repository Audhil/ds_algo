package _16Trie;

//  https://youtu.be/K5pcpkEMCN0?list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp&t=341
public class _2countWordsEqualToAndStartsWith {

  private static class TNode {

    private final TNode[] links = new TNode[26];
    private int countEndWith = 0;

    public int getCountEndWith() {
      return countEndWith;
    }

    private void increaseEndsWith() {
      countEndWith++;
    }

    private void decreaseEndsWith() {
      countEndWith--;
    }

    private int countPrefix = 0;

    public int getCountPrefix() {
      return countPrefix;
    }

    private void increasePrefix() {
      countPrefix++;
    }

    private void decreasePrefix() {
      countPrefix--;
    }

    public boolean containsKey(char ch) {
      return links[ch - 'a'] != null;
    }

    public void put(char ch, TNode tNode) {
      links[ch - 'a'] = tNode;
    }

    public TNode get(char ch) {
      return links[ch - 'a'];
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
        //  move to reference trie node
        temp = temp.get(ch);
        temp.increasePrefix();
      }
      temp.increaseEndsWith();
    }

    private int countWordsEqualTo(String word) {
      TNode temp = root;
      for (char ch : word.toCharArray()) {
        if (!temp.containsKey(ch)) {
          return 0;
        }
        temp = temp.get(ch);
      }
      return temp.getCountEndWith();
    }

    private int countWordsStartsWith(String word) {
      TNode temp = root;
      for (char ch : word.toCharArray()) {
        if (!temp.containsKey(ch)) {
          return 0;
        }
        temp = temp.get(ch);
      }
      return temp.getCountPrefix();
    }

    //  assuming word exists, hence moving to erase
    private void erase(String word) {
      TNode temp = root;
      for (char ch : word.toCharArray()) {
        if (!temp.containsKey(ch)) {
          return;
        }
        temp = temp.get(ch);
        temp.decreasePrefix();
      }
      temp.decreaseEndsWith();
    }
  }

  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insert("apple");
    trie.insert("apple");
    trie.insert("apps");
    trie.insert("apps");

    System.out.println("yup: countWordsEqualTo: " + trie.countWordsEqualTo("e"));  //  0
    System.out.println("yup: countWordsEqualTo: " + trie.countWordsEqualTo("apps"));  //  2
    System.out.println("yup: countWordsEqualTo: " + trie.countWordsEqualTo("apc")); //  0
    System.out.println("yup: countWordsStartsWith: " + trie.countWordsStartsWith("a")); //  4
    System.out.println("yup: countWordsStartsWith: " + trie.countWordsStartsWith("ap")); //  4
    System.out.println("yup: countWordsStartsWith: " + trie.countWordsStartsWith("p")); //  0
    System.out.println("yup: countWordsStartsWith: " + trie.countWordsStartsWith("appl")); //  2

    trie.erase("apps");
    System.out.println("yup: after deleting: ");
    System.out.println("yup: countWordsEqualTo: " + trie.countWordsEqualTo("apps"));  //  1

    System.out.println("yup: final output: ");
    System.out.println("yup: countWordsEqualTo: " + trie.countWordsEqualTo("e"));  //  0
    System.out.println("yup: countWordsEqualTo: " + trie.countWordsEqualTo("apps"));  //  1
    System.out.println("yup: countWordsEqualTo: " + trie.countWordsEqualTo("apc")); //  0
    System.out.println("yup: countWordsStartsWith: " + trie.countWordsStartsWith("a")); //  3
    System.out.println("yup: countWordsStartsWith: " + trie.countWordsStartsWith("ap")); //  3
    System.out.println("yup: countWordsStartsWith: " + trie.countWordsStartsWith("p")); //  0
    System.out.println("yup: countWordsStartsWith: " + trie.countWordsStartsWith("appl")); //  2
  }
}
