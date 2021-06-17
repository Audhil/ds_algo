package _0medium;

//  good expln: https://www.youtube.com/watch?v=tKY1c-m8Sq8
//  https://leetcode.com/problems/check-if-a-string-can-break-another-string/
/*
* Given two strings: s1 and s2 with the same size, check if some permutation of string s1 can break some permutation of string s2 or vice-versa. In other words s2 can break s1 or vice-versa.

A string x can break string y (both of size n) if x[i] >= y[i] (in alphabetical order) for all i between 0 and n-1.



Example 1:

Input: s1 = "abc", s2 = "xya"
Output: true
Explanation: "ayx" is a permutation of s2="xya" which can break to string "abc" which is a permutation of s1="abc".
Example 2:

Input: s1 = "abe", s2 = "acd"
Output: false
Explanation: All permutations for s1="abe" are: "abe", "aeb", "bae", "bea", "eab" and "eba" and all permutation for s2="acd" are: "acd", "adc", "cad", "cda", "dac" and "dca". However, there is not any permutation from s1 which can break some permutation from s2 and vice-versa.
Example 3:

Input: s1 = "leetcodee", s2 = "interview"
Output: true


Constraints:

s1.length == n
s2.length == n
1 <= n <= 10^5
All strings consist of lowercase English letters.

* */

//  time complexity: O(n) + O(n) = 2 O(n) => O(n)
//  space complexity: O(26) + O(26) -> O(1)
public class StringCanBreakAnother {

    public static boolean checkIfCanBreak(String s1, String s2) {
        if (s1 == null || s2 == null)
            return false;

        int[] cOccurance1 = calculateOccurance(s1);
        int[] cOccurance2 = calculateOccurance(s2);

//        System.out.println(Arrays.toString(cOccurance1));
//        System.out.println(Arrays.toString(cOccurance2));

        int diffCount = 0;
        boolean s1BreakS2 = true;
        boolean s2BreakS1 = true;

        //  s1 can break s2 ?
        for (int i = 0; i < 26; i++) {
            if (cOccurance1[i] == cOccurance2[i])
                continue;
            else if (cOccurance1[i] > cOccurance2[i])
                diffCount += cOccurance1[i] - cOccurance2[i];
            else
                diffCount -= cOccurance2[i] - cOccurance1[i];
            if (diffCount < 0) {
                s1BreakS2 = false;
                break;
            }
        }

        //  s2 can break s1 ?
        diffCount = 0;
        for (int i = 0; i < 26; i++) {
            if (cOccurance2[i] == cOccurance1[i])
                continue;
            else if (cOccurance2[i] > cOccurance1[i])
                diffCount += cOccurance2[i] - cOccurance1[i];
            else
                diffCount -= cOccurance1[i] - cOccurance2[i];
            if (diffCount < 0) {
                s2BreakS1 = false;
                break;
            }
        }
        return s1BreakS2 || s2BreakS1;
    }

    private static int[] calculateOccurance(String str) {
        int[] occurance = new int[26];  //  '26' -> english letters
        for (int i = 0; i < str.length(); i++)
            occurance[str.charAt(i) - 'a']++;
        return occurance;
    }

    public static void main(String[] args) {
        System.out.println("yup: " + checkIfCanBreak("netflix", "primeiv"));
        System.out.println("yup: " + checkIfCanBreak("abc", "xya"));
    }
}
