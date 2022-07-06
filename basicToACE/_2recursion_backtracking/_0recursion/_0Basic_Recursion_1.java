package basicToACE._2recursion_backtracking._0recursion;

//  https://youtu.be/NBipEF08gUo?list=PLQXZIFwMtjowKrFlzGcjMqchffJDRsz1E&t=619
public class _0Basic_Recursion_1 {

  //  sum of n natural numbers
  private static int sum(int n) {
    if (n == 0) {
      return 0;
    }
    return n + sum(n - 1);
  }

  private static int factorial(int n) {
    if (n == 0) {
      return 1;
    }
    return n * factorial(n - 1);
  }

  //  nth term of fibonacci series
  private static int fib(int n) {
    if (n == 1 || n == 2) {
      return n - 1;
    }
    return fib(n - 1) + fib(n - 2);
  }

  private static int n1 = 0;
  private static int n2 = 1;

  private static void fibPrintWithRecursion(int n) {
    if (n > 0) {
      int n3 = n1 + n2;
      n1 = n2;
      n2 = n3;
      System.out.println(n3);
      fibPrintWithRecursion(n - 1);
    }
  }

  private static void fibPrintWithIteration(int n) {
    while (n-- > 0) {
      int n3 = n1 + n2;
      n1 = n2;
      n2 = n3;
      System.out.println(n3);
    }
  }

  //  climbing stairs
  //  https://youtu.be/NBipEF08gUo?list=PLQXZIFwMtjowKrFlzGcjMqchffJDRsz1E&t=5574
  //  how many ways/pattern to reach top?
  //  n - no of steps
  //  refer ClimbingStairs.java for iterative approach
  private static int noOfWaysToClimbingStairs(int currStepNo, int n) {
    //  reached top step
    if (currStepNo == n) {
      return 1;
    }
    //  invalid case - going out of top step - for eg., taking double step instead of 1
    if (currStepNo > n) {
      return 0;
    }
    //  ways1 = taking single step from current step
    return noOfWaysToClimbingStairs(currStepNo + 1, n)
        //  ways2 = taking double steps from current step
        + noOfWaysToClimbingStairs(currStepNo + 2, n);
  }

  //  climbing down from nth step
  private static int noOfWaysToClimbingDownStairs(int n) {
    //  reached ground
    if (n == 0) {
      return 1;
    }
    //  invalid case - going below ground - for eg., taking double step instead of 1
    if (n < 0) {
      return 0;
    }
    return noOfWaysToClimbingDownStairs(n - 1) + noOfWaysToClimbingDownStairs(n - 2);
  }

  //  climbing steps with min cost
  //  https://youtu.be/NBipEF08gUo?list=PLQXZIFwMtjowKrFlzGcjMqchffJDRsz1E&t=6472
  //  refer: _0ClimbingStairsMinCost.java for another approach
  private static int climbingStepsWithMinCost(int currStepNo, int n, int[] cost) {
    if (currStepNo == n - 1) {
      return cost[currStepNo];
    }

    int op = climbingStepsWithMinCost(currStepNo + 1, n, cost); //  1 step at a time
    if (currStepNo + 2 <= n - 1) {
      op = Math.min(op, climbingStepsWithMinCost(currStepNo + 2, n, cost)); //  2 steps at a time
    }
//    if (currStepNo + 3 <= n - 1) {
//      op = Math.min(op, climbingStepsWithMinCost(currStepNo + 3, n, cost)); //  3 steps at a time
//    }
    return cost[currStepNo] + op;
  }

  public static void main(String[] args) {
    System.out.println("yup: sum of N numbers: " + sum(3)); //  yup: sum of N numbers: 6
    System.out.println(
        "yup: factorial of N numbers: " + factorial(4)); //  yup: factorial of N numbers: 24
    System.out.println(
        "yup: 6th term of fib series is: " + fib(6)); // yup: 6th term of fib series is: 5

    System.out.println("yup: print fib series with recursion: ");
    /*
    * 1
      2
      3
      5
      8
      13
      * */
    fibPrintWithRecursion(6);
    n1 = 0;
    n2 = 1;
    System.out.println("yup: print fib series without recursion: ");
    /*
    * 1
      2
      3
      5
      8
      13
      * */
    fibPrintWithIteration(6);
    System.out.println("yup: noOfWaysToClimbingStairs : "
        + noOfWaysToClimbingStairs(0, 4));  //  yup: noOfWaysToClimbingStairs : 5
    System.out.println("yup: noOfWaysToClimbingDownStairs : "
        + noOfWaysToClimbingDownStairs(4));  //  yup: noOfWaysToClimbingDownStairs : 5

    //  check out this too: _0ClimbingStairsMinCost.java
    /*
    * yup: climbing stairs from : currStep: 0, with min cost: 80
      yup: climbing stairs from : currStep: 1, with min cost: 70
      yup: climbing stairs from : currStep: 2, with min cost: 70
      yup: climbing stairs from : currStep: 3, with min cost: 50
      yup: final minCost: 50
      * */
    int[] cost = {10, 20, 100, 50};
//    int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
    /*
    * yup: climbing stairs from : currStep: 0, with min cost: 6
      yup: climbing stairs from : currStep: 1, with min cost: 6
      yup: climbing stairs from : currStep: 2, with min cost: 5
      yup: climbing stairs from : currStep: 3, with min cost: 5
      yup: climbing stairs from : currStep: 4, with min cost: 4
      yup: climbing stairs from : currStep: 5, with min cost: 4
      yup: climbing stairs from : currStep: 6, with min cost: 3
      yup: climbing stairs from : currStep: 7, with min cost: 2
      yup: climbing stairs from : currStep: 8, with min cost: 2
      yup: climbing stairs from : currStep: 9, with min cost: 1
      yup: final minCost: 1
      * */
    int n = cost.length;
    int minCost = Integer.MAX_VALUE;
    for (int currStep = 0; currStep < n; currStep++) {
      minCost = Math.min(minCost, climbingStepsWithMinCost(currStep, n, cost));
      System.out.println("yup: climbing stairs from : currStep: "
          + currStep + ", with min cost: " + minCost);
    }
    System.out.println("yup: final minCost: " + minCost);
  }
}
