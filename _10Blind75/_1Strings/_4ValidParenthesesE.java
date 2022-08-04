package _10Blind75._1Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//  https://leetcode.com/problems/valid-parentheses/
//  another soln: https://www.youtube.com/watch?v=WTzjTskDFMg&ab_channel=NeetCode
public class _4ValidParenthesesE {

  //  using map & stack
  public static boolean isValid(String s) {
    if (s == null || s.isEmpty()) {
      return false;
    }

    if (s.startsWith(")") || s.startsWith("]") || s.startsWith("}")) {
      return false;
    }

    Map<Character, Character> map = new HashMap<>();
    map.put(')', '(');
    map.put(']', '[');
    map.put('}', '{');

    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (map.containsKey(ch)) {
        char topElement = stack.isEmpty() ? '#' : stack.pop();
        if (topElement != map.get(ch)) {
          return false;
        }
      } else {
        stack.push(ch);
      }
    }
    return stack.isEmpty();
  }

  public static boolean revision(String s) {
    if (s.isEmpty()) {
      return false;
    }

    if (s.startsWith(")") || s.startsWith("]") || s.startsWith("}")) {
      return false;
    }
    Map<Character, Character> map = new HashMap<>();
    map.put(')', '(');
    map.put(']', '[');
    map.put('}', '{');
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (map.containsKey(ch)) {
        char topElement = stack.isEmpty() ? '#' : stack.pop();
        if (topElement != map.get(ch)) {
          return false;
        }
      } else {
        stack.push(ch);
      }
    }
    return stack.isEmpty();
  }

  public static void main(String[] args) {
    System.out.println("yup: is valid parenthesis: " + isValid("()"));  //  true
    System.out.println("yup: is valid parenthesis: " + isValid("()[]{}"));  //  true
    System.out.println("yup: is valid parenthesis: " + isValid(")("));  //  false
    System.out.println("yup: is valid parenthesis: " + isValid("(]"));  //  false
  }
}
