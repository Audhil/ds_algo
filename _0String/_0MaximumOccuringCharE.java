package _0String;

//  https://practice.geeksforgeeks.org/problems/maximum-occuring-character-1587115620/1
public class _0MaximumOccuringCharE {

  public static char getMaxOccuringChar(String line) {
    int[] countArr = new int[26];
    for (char ch : line.toCharArray()) {
      countArr[ch - 'a']++;
    }
    int max = Integer.MIN_VALUE;
    int ans = 0;
    for (int i = 0; i < 26; i++) {
      if (max < countArr[i]) {
        ans = i;
        max = countArr[i];
      }
    }
    return (char) ('a' + ans);
  }

  public static void main(String[] args) {
    System.out.println("yup: finally: " + getMaxOccuringChar("testsample"));  //  yup: finally: e
    System.out.println("yup: finally: " + getMaxOccuringChar("output"));  //  yup: finally: t
    System.out.println("yup: finally: " + getMaxOccuringChar("jack"));  //  yup: finally: a
  }
}
