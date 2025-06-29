package _0easy._facebook;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//  https://www.lintcode.com/problem/423/?fromId=29&_from=collection
public class _3ValidParenthesesE {

  public static boolean isValidParentheses(String s) {
    if (s.startsWith(")") || s.startsWith("}") || s.startsWith("]")) {
      return false;
    }
    Map<Character, Character> map = new HashMap<>();
    map.put(')', '(');
    map.put(']', '[');
    map.put('}', '{');

    Stack<Character> stack = new Stack<>();
    for (char ch : s.toCharArray()) {
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
    System.out.println("yup: valid parenthesis: " + isValidParentheses(")()"));
    System.out.println("yup: valid parenthesis: " + isValidParentheses("([)]"));
    System.out.println("yup: valid parenthesis: " + isValidParentheses("()[]{}"));
  }
}
