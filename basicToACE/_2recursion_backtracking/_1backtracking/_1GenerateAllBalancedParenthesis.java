package basicToACE._2recursion_backtracking._1backtracking;

import java.util.ArrayList;
import java.util.List;

//  https://youtu.be/exyxf_ihbhI?list=PLQXZIFwMtjowKrFlzGcjMqchffJDRsz1E&t=4968
public class _1GenerateAllBalancedParenthesis {

  private static void revision(int n, int openCount, int closeCount, String temp,
      List<String> ansList) {
    if (closeCount == n) {
      ansList.add(temp);
    } else {
      if (openCount < n) {
        revision(n, openCount + 1, closeCount, temp + "(", ansList);
      }
      if (closeCount < openCount) {
        revision(n, openCount, closeCount + 1, temp + ")", ansList);
      }
    }
  }

  private static void revisionBackTracking(int n,
      int openCount,
      int closeCount,
      String[] temp,
      List<String> ansList) {
    if (closeCount == n) {
      ansList.add(temp[0]);
    } else {
      if (openCount < n) {
        temp[0] += "(";
        revisionBackTracking(n, openCount + 1, closeCount, temp, ansList);
        temp[0] = temp[0].substring(0, temp[0].length() - 1);
      }
      if (closeCount < openCount) {
        temp[0] += ")";
        revisionBackTracking(n, openCount, closeCount + 1, temp, ansList);
        temp[0] = temp[0].substring(0, temp[0].length() - 1);
      }
    }
  }

  private static void generateAllBalancedParenthesis(
      int openCount,
      int closeCount,
      int n,
      String temp,
      List<String> ans) {
    if (closeCount == n) {
      ans.add(temp);
    } else {
      if (openCount < n) {
        generateAllBalancedParenthesis(openCount + 1, closeCount, n, temp + '(', ans);
      }
      if (closeCount < openCount) {
        generateAllBalancedParenthesis(openCount, closeCount + 1, n, temp + ')', ans);
      }
    }
  }

  private static void generateAllBalancedParenthesisWithBackTracking(
      int openCount,
      int closeCount,
      int n,
      Wrapper wrapper,  //  equivalent of String &temp;
      List<String> ans) {
    if (closeCount == n) {
      ans.add(wrapper.temp);
    } else {
      if (openCount < n) {
        wrapper.temp += '(';
        generateAllBalancedParenthesisWithBackTracking(openCount + 1, closeCount, n, wrapper, ans);
        wrapper.temp = wrapper.temp.substring(0, wrapper.temp.length() - 1);
      }
      if (closeCount < openCount) {
        wrapper.temp += ')';
        generateAllBalancedParenthesisWithBackTracking(openCount, closeCount + 1, n, wrapper, ans);
        wrapper.temp = wrapper.temp.substring(0, wrapper.temp.length() - 1);
      }
    }
  }

  static class Wrapper {

    String temp = "";
  }

  //  given n - generate 2n length string
  public static void main(String[] args) {
    List<String> ansList = new ArrayList<>();
    int n = 4, openCount = 0, closeCount = 0;
    String temp = "";
    generateAllBalancedParenthesis(openCount, closeCount, n, temp, ansList);
    System.out.println("yup: generated paranthesises are: ");
    //  n =4, [(((()))), ((()())), ((())()), ((()))(), (()(())), (()()()), (()())(), (())(()), (())()(), ()((())), ()(()()), ()(())(), ()()(()), ()()()()]
    System.out.println(ansList);
    ansList.clear();
    //  just to demonstrate backtracking
    System.out.println("yup: generate paranthesises with backtracking: ");
    generateAllBalancedParenthesisWithBackTracking(
        openCount, closeCount, n, new Wrapper(),
        ansList);
    System.out.println(
        ansList);  //  [(((()))), ((()())), ((())()), ((()))(), (()(())), (()()()), (()())(), (())(()), (())()(), ()((())), ()(()()), ()(())(), ()()(()), ()()()()]

    System.out.println("yup: revision");
    ansList.clear();
    temp = "";
    revision(n, 0, 0, temp, ansList);
    System.out.println(ansList);
    ansList.clear();
    System.out.println("yup: revision with back tracking");
    String[] tempStr = {""};
    revisionBackTracking(n, 0, 0, tempStr, ansList);
    System.out.println(ansList);
  }
}
