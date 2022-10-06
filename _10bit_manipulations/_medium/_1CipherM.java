package _10bit_manipulations._medium;

//  https://youtu.be/AYk8H7EtjX4
public class _1CipherM {

  public static String cipher(int k, String s) {
    int[] ansArr = new int[s.length() - k + 1];
    //  1. 0th char is same in both i/p & o/p string
    ansArr[0] = s.charAt(0) - '0';
    //  2. fill k chars
    int i = 1;
    for (; i < k; i++) {
      ansArr[i] = (s.charAt(i - 1) - '0') ^ (s.charAt(i) - '0');
    }
    //  3. fill remaining chars of output
    int flag, l, p = 1;
    for (int j = i; j < ansArr.length; j++) {
      flag = 0;
      //  xor of recent (k-1) bits
      for (l = p; l < k + p - 1; l++) {
        flag ^= ansArr[l];
      }
      ansArr[j] = flag ^ (s.charAt(j) - '0');
      p++;
    }
    StringBuilder stringBuilder = new StringBuilder();
    for (int value : ansArr) {
      stringBuilder.append((char) (value + 48));
    }
    return stringBuilder.toString();
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: cipher of strings: " + cipher(4, "1110100110")); //  yup: cipher of strings: 1001010
    System.out.println(
        "yup: cipher of strings: " + cipher(2, "1110001"));  //  yup: cipher of strings: 101111
    System.out.println(
        "yup: cipher of strings: " + cipher(3, "1110011011")); //  yup: cipher of strings: 10000101
  }
}