package _0REVISION.easy.arrays;

import java.util.HashSet;
import java.util.Set;

//  https://leetcode.com/problems/count-the-number-of-consistent-strings/
public class _24CountNumsOfConsistentStrs {

    public static int countConsistentStrings(String allowed, String[] words) {
        if (allowed == null || words == null)
            return 0;

        Set<Character> set = new HashSet<>();
        for (char ch : allowed.toCharArray()) {
            set.add(ch);
        }

        int count = 0;
        for (String word : words) {
            boolean flag = true;
            for (char ch : word.toCharArray()) {
                if (!set.contains(ch)) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("yup: " + countConsistentStrings("ab", new String[]{"ad", "bd", "aaab", "baa", "badab"}));   //  yup: 2
        System.out.println("yup: " + countConsistentStrings("abc", new String[]{"a", "b", "c", "ab", "ac", "bc", "abc"}));  //  yup: 7
        System.out.println("yup: " + countConsistentStrings("cad", new String[]{"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"})); //  yup: 4
    }
}
