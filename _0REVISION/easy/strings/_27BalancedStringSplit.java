package _0REVISION.easy.strings;

/*
https://leetcode.com/problems/split-a-string-in-balanced-strings/
* Balanced strings are those that have an equal quantity of 'L' and 'R' characters.

Given a balanced string s, split it in the maximum amount of balanced strings.

Return the maximum amount of split balanced strings.
*
* Example 1:

Input: s = "RLRRLLRLRL"
Output: 4
Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
Example 2:

Input: s = "RLLLLRRRLR"
Output: 3
Explanation: s can be split into "RL", "LLLRRR", "LR", each substring contains same number of 'L' and 'R'.
Example 3:

Input: s = "LLLLRRRR"
Output: 1
Explanation: s can be split into "LLLLRRRR".
Example 4:

Input: s = "RLRRRLLRLL"
Output: 2
Explanation: s can be split into "RL", "RRRLLRLL", since each substring contains an equal number of 'L' and 'R'
*/
public class _27BalancedStringSplit {

    public static int balancedStringSplit(String s) {
        if (s == null)
            return 0;
        int count = 0;
        int ans = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'L')
                count++;
            else
                count--;
            if (count == 0)
                ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("yup: " + balancedStringSplit("RLRRLLLR"));
    }
}
