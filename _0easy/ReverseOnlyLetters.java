package _0easy;

//  https://leetcode.com/problems/reverse-only-letters/
/*
*
Given a string s, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.



Example 1:

Input: s = "ab-cd"
Output: "dc-ba"
Example 2:

Input: s = "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"
Example 3:

Input: s = "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"


Note:

s.length <= 100
33 <= s[i].ASCIIcode <= 122
s doesn't contain \ or "
*
* */
public class ReverseOnlyLetters {

    public static String reverseOnlyLetters(String s) {
        if (s == null)
            return null;

        char[] strArry = s.toCharArray();
        int i = 0, j = strArry.length - 1;
        while (i < j) {
            char chAtI = strArry[i];
            char chAtJ = strArry[j];
            if (!isAlphabet(chAtI))
                i++;
            else if (!isAlphabet(chAtJ))
                j--;
                //  both are alphabets, swap them
            else {
                strArry[i] = chAtJ;
                strArry[j] = chAtI;
                i++;
                j--;
            }
        }
        return String.valueOf(strArry);
    }

    private static boolean isAlphabet(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    public static void main(String[] args) {
//        System.out.println("yup: " + reverseOnlyLetters("ab-cd"));
//        System.out.println("yup: " + reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println("yup: " + reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}
