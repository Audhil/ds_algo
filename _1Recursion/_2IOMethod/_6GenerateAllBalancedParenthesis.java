package ds_algo._1Recursion._2IOMethod;

import java.util.ArrayList;
import java.util.List;

//  https://youtu.be/eyCj_u3PoJE?list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY
public class _6GenerateAllBalancedParenthesis {

  //  recursive tree @ https://photos.google.com/photo/AF1QipOl3fACCUB72VnYliJqga4lhCFE9eQgg3zHlAgm

  public static void main(String[] args) {
    List<String> balParenthesis = new ArrayList<>();
    int n = 3;
    getBalancedParenthesis(balParenthesis, n);
    System.out.println("yup: balParenthesis: " + balParenthesis);
    System.out.println("yup: printBrackets: ");
    printBrackets(2, 2, "");

    //    List<String> balParenthesis2 = new ArrayList<>();
    //    n = 4;
    //    getBalancedParenthesisRevision(balParenthesis2, n);
    //    System.out.println("yup: balParenthesis2: "
    //        + balParenthesis2); //  yup: balParenthesis2: [(((()))), ((()())), ((())()), ((()))(),
    // (()(())), (()()()), (()())(), (())(()), (())()(), ()((())), ()(()()), ()(())(), ()()(()),
    // ()()()()]
    //
    //    List<String> balParenthesis3 = new ArrayList<>();
    //    getBalancedParenthesisRevision2(balParenthesis3,
    //        n);   // based on _1GenerateAllBalancedParenthesis.java
    //    System.out.println("yup: balParenthesis3: "
    //        + balParenthesis3); //  yup: balParenthesis2: [(((()))), ((()())), ((())()), ((()))(),
    // (()(())), (()()()), (()())(), (())(()), (())()(), ()((())), ()(()()), ()(())(), ()()(()),
    // ()()()()]
    //
    //    List<String> balParenthesis4 = new ArrayList<>();
    //    getBalancedParenthesisWithBackTrackingRevision(balParenthesis4,
    //        n);   // based on _1GenerateAllBalancedParenthesis.java
    //    System.out.println("yup: balParenthesis4 with backTracking: "
    //        + balParenthesis3);
  }

  private static void getBalancedParenthesisWithBackTrackingRevision(
      List<String> balParenthesis4, int n) {
    generateWithBackTracking(balParenthesis4, 0, 0, n, new String[1]);
  }

  private static void generateWithBackTracking(
      List<String> balParenthesis4, int openCount, int closeCount, int n, String[] temp) {
    if (closeCount == n) {
      balParenthesis4.add(temp[0]);
      return;
    }
    if (openCount < n) {
      temp[0] += "(";
      generateWithBackTracking(balParenthesis4, openCount + 1, closeCount, n, temp);
      temp[0] = temp[0].substring(0, temp[0].length() - 1);
    }

    if (closeCount < openCount) {
      temp[0] += ")";
      generateWithBackTracking(balParenthesis4, openCount, closeCount + 1, n, temp);
      temp[0] = temp[0].substring(0, temp[0].length() - 1);
    }
  }

  private static void getBalancedParenthesisRevision2(List<String> balParenthesis3, int n) {
    int openCount = 0, closeCount = 0;
    String output = "";
    generate2(balParenthesis3, openCount, closeCount, output, n);
  }

  private static void generate2(
      List<String> balParenthesis3, int openCount, int closeCount, String output, int n) {
    if (closeCount == n) {
      balParenthesis3.add(output);
      return;
    }

    if (openCount < n) {
      generate2(balParenthesis3, openCount + 1, closeCount, output + "(", n);
    }

    if (closeCount < openCount) {
      generate2(balParenthesis3, openCount, closeCount + 1, output + ")", n);
    }
  }

  private static void getBalancedParenthesisRevision(List<String> balParenthesis, int n) {
    int openCount = n, closeCount = n;
    String output = "";
    generate(balParenthesis, openCount, closeCount, output);
  }

  private static void generate(
      List<String> balParenthesis, int openCount, int closeCount, String output) {
    if (openCount == 0 && closeCount == 0) {
      balParenthesis.add(output);
      return;
    }

    if (openCount != 0) {
      String op = output;
      op += "(";
      generate(balParenthesis, openCount - 1, closeCount, op);
    }

    if (closeCount > openCount) {
      String op = output;
      op += ")";
      generate(balParenthesis, openCount, closeCount - 1, op);
    }
  }

  private static void getBalancedParenthesis(List<String> list, int n) {
    int openCount = n;
    int closeCount = n;
    String output = "";
    solve(list, openCount, closeCount, output);
  }

  private static void solve(List<String> list, int openCount, int closeCount, String output) {
    System.out.println(
        "yup this is solve: openCount: "
            + openCount
            + ", closeCount: "
            + closeCount
            + ", output: "
            + output);
    //  bc
    if (openCount == 0 && closeCount == 0) {
      list.add(output);
      return;
    }

    if (openCount != 0) {
      String op1 = output;
      op1 += '(';
      solve(list, openCount - 1, closeCount, op1);
    }

    if (closeCount > openCount) {
      String op2 = output;
      op2 += ')';
      solve(list, openCount, closeCount - 1, op2);
    }
  }

  private static void printBrackets(int open, int close, String output) {
    if (open == 0 && close == 0) {
      System.out.println(output);
    }

    if (open != 0) {
      String op1 = output;
      op1 += '(';
      printBrackets(open - 1, close, op1);
    }

    if (close > open) {
      String op2 = output;
      op2 += ')';
      printBrackets(open, close - 1, op2);
    }
  }
}
