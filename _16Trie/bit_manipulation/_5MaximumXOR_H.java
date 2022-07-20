package _16Trie.bit_manipulation;

//  https://www.youtube.com/watch?v=EIhAwfHubE8&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp&index=6&ab_channel=takeUforward
public class _5MaximumXOR_H {

  private static class TNode {

    private final TNode[] links = new TNode[2];

    private boolean containsKey(int bit) {
      return links[bit] != null;
    }

    private void put(int bit, TNode node) {
      links[bit] = node;
    }

    private TNode get(int bit) {
      return links[bit];
    }
  }

  private static class Trie {

    private final TNode root;

    public Trie() {
      root = new TNode();
    }

    //  save number in bits
    private void insert(int num) {
      TNode temp = root;
      for (int i = 31; i >= 0; i--) {
        int bit = (num >> i) & 1; //  extract the bit
        if (!temp.containsKey(bit)) {
          temp.put(bit, new TNode());
        }
        temp = temp.get(bit);
      }
    }

    //  refer this https://youtu.be/EIhAwfHubE8?list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp&t=877
    private int getMax(int num) {
      TNode temp = root;
      int maxNum = 0;
      for (int i = 31; i >= 0; i--) {
        int bit = (num >> i) & 1; //  extract the bit
        int oppositeBit = 1 - bit;  //  inverted form of that bit
        if (temp.containsKey(oppositeBit)) {
          maxNum = maxNum | (1 << i); //  set that bit in maxNum
          temp = temp.get(oppositeBit);
        } else {
          temp = temp.get(bit);
        }
      }
      return maxNum;
    }
  }

  //  create trie of array 1, Xor each item from array 2 with trie
  private static int maxXOR(int[] arr1, int[] arr2) {
    Trie trie = new Trie();
    for (int num : arr1) {
      trie.insert(num);
    }
    int maxi = 0;
    for (int num : arr2) {
      maxi = Math.max(maxi, trie.getMax(num));
    }
    return maxi;
  }

  public static void main(String[] args) {
    int[] arr1 = {1, 2, 3, 4, 5};
    int[] arr2 = {5, 4, 3, 2, 1};
    System.out.println("yup: maxXor from given arrays is: " + maxXOR(arr1,
        arr2));  //  yup: maxXor from given arrays is: 7
  }
}
