package _0medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//  https://leetcode.com/problems/find-and-replace-pattern/
/*
* Given a list of strings words and a string pattern, return a list of words[i] that match pattern. You may return the answer in any order.

A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.

Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.



Example 1:

Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
Output: ["mee","aqq"]
Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
"ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation, since a and b map to the same letter.
Example 2:

Input: words = ["a","b","c"], pattern = "a"
Output: ["a","b","c"]


Constraints:

1 <= pattern.length <= 20
1 <= words.length <= 50
words[i].length == pattern.length
pattern and words[i] are lowercase English letters.
* */
public class FindAndReplacePattern {

    /*
     * A) 2 map approach
     *
     * Intuition and Algorithm
     * If say, the first letter of the pattern is "a", and the first letter of the word is "x", then in the permutation, "a" must map to "x".
     * We can write this bijection using two maps: a forward map \text{m1}m1 and a backwards map \text{m2}m2.
     * \text{m1} : \text{"a"} \rightarrow \text{"x"}m1:"a"→"x" \text{m2} : \text{"x"} \rightarrow \text{"a"}m2:"x"→"a"
     * Then, if there is a contradiction later, we can catch it via one of the two maps.
     * For example, if the (word, pattern) is ("aa", "xy"), we will catch the mistake in \text{m1}m1 (namely, \text{m1}(\text{"a"}) = \text{"x"} = \text{"y"}m1("a")="x"="y").
     * Similarly, with (word, pattern) = ("ab", "xx"), we will catch the mistake in \text{m2}m2.
     *
     * Complexity Analysis:
        Time Complexity: O(N * K)O(N∗K), where NN is the number of words, and KK is the length of each word.
        Space Complexity: O(N * K)O(N∗K), the space used by the answer.
     * */
    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        for (String word : words)
            //  approach 1
            if (matchess(word, pattern))
                ans.add(word);
        //  approach 2
//            if (match(word, pattern))
//                ans.add(word);
        return ans;
    }

    private static boolean matchess(String word, String pattern) {
        Map<Character, Character> m1 = new HashMap<>(); //  forward map -> (w -> p)
        Map<Character, Character> m2 = new HashMap<>(); //  backward map -> (p -> w)

        for (int i = 0; i < word.length(); i++) {   //  1 loop is enough, since word & pattern are same in length
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            if (!m1.containsKey(w))
                m1.put(w, p);
            if (!m2.containsKey(p))
                m2.put(p, w);

            if (m1.get(w) != p || m2.get(p) != w)
                return false;
        }
        return true;
    }

    /*
    * B) 1 map approach
    *
    * As in Approach 1, we can have some forward map \text{m1} : \mathbb{L} \rightarrow \mathbb{L}m1:L→L, where \mathbb{L}L is the set of letters.
        However, instead of keeping track of the reverse map \text{m2}m2,
        * we could simply make sure that every value \text{m1}(x)m1(x) in the codomain is reached at most once.
        * This would guarantee the desired permutation exists.
            So our algorithm is this: after defining \text{m1}(x)m1(x) in the same way as Approach 1 (the forward map of the permutation),
            * afterwards we make sure it reaches distinct values.
            *
      * Complexity Analysis:
        Time Complexity: O(N * K)O(N∗K), where NN is the number of words, and KK is the length of each word.
        Space Complexity: O(N * K)O(N∗K), the space used by the answer.
    * */
    public static boolean match(String word, String pattern) {
        Map<Character, Character> M = new HashMap<>();
        for (int i = 0; i < word.length(); ++i) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            if (!M.containsKey(w)) M.put(w, p);
            if (M.get(w) != p) return false;
        }

        boolean[] seen = new boolean[26];
        for (char p : M.values()) {
            if (seen[p - 'a']) return false;
            seen[p - 'a'] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("yup: arrays : " + findAndReplacePattern(new String[]{"abc", "deq", "mee", "aqq", "dkd", "ccc"}, "abb"));
    }
}
