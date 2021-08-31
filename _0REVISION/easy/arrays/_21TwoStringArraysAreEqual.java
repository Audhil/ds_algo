package _0REVISION.easy.arrays;

//  https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
/*
* Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.

A string is represented by an array if the array elements concatenated in order forms the string.

Example 1:

Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
Output: true
Explanation:
word1 represents string "ab" + "c" -> "abc"
word2 represents string "a" + "bc" -> "abc"
The strings are the same, so return true.
Example 2:

Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
Output: false
Example 3:

Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
Output: true

* */
public class _21TwoStringArraysAreEqual {

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        if (word1 == null || word2 == null)
            return false;

        StringBuilder s1 = new StringBuilder();
        for (String s : word1) {
            s1.append(s);
        }

        StringBuilder s2 = new StringBuilder();
        for (String s : word2) {
            s2.append(s);
        }

        return s1.toString().equals(s2.toString());
    }

    public static void main(String[] args) {
        System.out.println("yup: _21TwoStringArraysAreEqual: " + arrayStringsAreEqual(new String[]{"ab", "c"}, new String[]{"a", "bc"}));   //  true
        System.out.println("yup: _21TwoStringArraysAreEqual: " + arrayStringsAreEqual(new String[]{"a", "cb"}, new String[]{"ab", "c"}));   //  false
    }
}
