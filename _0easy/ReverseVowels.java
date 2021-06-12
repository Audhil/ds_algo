package _0easy;

import java.util.Locale;

//  https://leetcode.com/problems/reverse-vowels-of-a-string/
/*
* Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases.



Example 1:

Input: s = "hello"
Output: "holle"
Example 2:

Input: s = "leetcode"
Output: "leotcede"


Constraints:

1 <= s.length <= 3 * 105
s consist of printable ASCII characters.

* */
public class ReverseVowels {
    public static String reverseVowels(String s) {
        if (s == null)
            return null;
        char[] a = s.toLowerCase(Locale.ROOT).toCharArray();
        int i = 0, j = a.length - 1;
        while (i < j) {
            if (!isVowel(a[i]))
                i++;
            else if (!isVowel(a[j]))
                j--;
            else {
                char tmp = a[j];
                a[j--] = a[i];
                a[i++] = tmp;
            }
        }
        return new String(a);
    }

    public static boolean isVowel(char charIs) {
        return charIs == 'a' || charIs == 'A'
                || charIs == 'e' || charIs == 'E'
                || charIs == 'i' || charIs == 'I'
                || charIs == 'o' || charIs == 'O'
                || charIs == 'u' || charIs == 'U';
    }

    public static void main(String[] args) {
//        System.out.println("yup: reverseVowels : " + reverseVowels("hello"));
        System.out.println("yup: reverseVowels : " + reverseVowels("leetcode"));
    }
}
