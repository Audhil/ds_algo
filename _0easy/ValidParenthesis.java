package _0easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//  https://leetcode.com/problems/valid-parentheses/
/*
* Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.


Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
Example 4:

Input: s = "([)]"
Output: false
Example 5:

Input: s = "{[]}"
Output: true


Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.

* */
public class ValidParenthesis {

    public static boolean isValidd(String s) {
        if (s == null || s.isEmpty()) return false;

        if (s.startsWith(")")
                || s.startsWith("]")
                || s.startsWith("}"))
            return false;

        Map<Character, Character> cMap = new HashMap<>();
        cMap.put(')', '(');
        cMap.put(']', '[');
        cMap.put('}', '{');
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //  if it is closed bracket
            if (cMap.containsKey(c)) {
                char topElement = stack.isEmpty() ? '#' : stack.pop();
                if (topElement != cMap.get(c))
                    return false;
            }
            //  if it is open bracket
            else
                stack.push(c);
        }
        return stack.isEmpty();
    }

    //  fails for cases like [}, (], [) etc
    public static boolean isValid(String s) {
        if (s == null || s.isEmpty()) return false;

        if (s.startsWith(")")
                || s.startsWith("]")
                || s.startsWith("}"))
            return false;

        Map<Character, Integer> charMap = new HashMap<>();
        charMap.put('(', 1);
        charMap.put(')', -1);
        charMap.put('[', 2);
        charMap.put(']', -2);
        charMap.put('{', 3);
        charMap.put('}', -3);

        int res = 0, prevValue = 0;
        for (int i = 0; i < s.length(); i++) {
            int currValue = charMap.get(s.charAt(i));
//            if (currValue < 0 && Math.abs(prevValue) < Math.abs(currValue)) {
//                return false;
//            }
            prevValue = currValue;
            res += currValue;
        }
        return res == 0;
    }

    public static void main(String[] args) {
        System.out.println("yup: " + isValidd("()[]{}"));
    }
}
