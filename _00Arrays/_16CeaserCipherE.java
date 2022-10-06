package _00Arrays;

//  https://www.hackerrank.com/challenges/caesar-cipher-1/problem
public class _16CeaserCipherE {

  //  TC: O (n); SC: O (n)
  public static String caesarCipher(String s, int k) {
    StringBuilder stringBuilder = new StringBuilder();
    for (char ch : s.toCharArray()) {
      if (!Character.isAlphabetic(ch)) {
        stringBuilder.append(ch);
        continue;
      }
      if (Character.isUpperCase(ch)) {
        stringBuilder.append((char) ((((ch - 'A') + k)) % 26 + 'A'));
      } else {
        stringBuilder.append((char) ((((ch - 'a') + k)) % 26 + 'a'));
      }
    }
    return stringBuilder.toString();
  }

  public static void main(String[] args) {
    System.out.println("yup: ceasorCipher: " + caesarCipher("middle-Outz", 2));
    System.out.println(
        "yup: ceasorCipher: " + caesarCipher("There's-a-starman-waiting-in-the-sky", 3));
  }
}
