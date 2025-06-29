package _ZSubX;

//  https://www.youtube.com/watch?v=T6lOtastw6A&ab_channel=CodingandSystemDesignInterviews
public class _1printAllSubArrays_iterative {

  //  TC: O (n^3)
  /*
    * {1 }
      {1 2 }
      {1 2 3 }
      {1 2 3 4 }
      {1 2 3 4 5 }
      {1 2 3 4 5 6 }
      {1 2 3 4 5 6 7 }
      {1 2 3 4 5 6 7 8 }
      {1 2 3 4 5 6 7 8 9 }
      {1 2 3 4 5 6 7 8 9 10 }
      {2 }
      {2 3 }
      {2 3 4 }
      {2 3 4 5 }
      {2 3 4 5 6 }
      {2 3 4 5 6 7 }
      {2 3 4 5 6 7 8 }
      {2 3 4 5 6 7 8 9 }
      {2 3 4 5 6 7 8 9 10 }
      {3 }
      {3 4 }
      {3 4 5 }
      {3 4 5 6 }
      {3 4 5 6 7 }
      {3 4 5 6 7 8 }
      {3 4 5 6 7 8 9 }
      {3 4 5 6 7 8 9 10 }
      {4 }
      {4 5 }
      {4 5 6 }
      {4 5 6 7 }
      {4 5 6 7 8 }
      {4 5 6 7 8 9 }
      {4 5 6 7 8 9 10 }
      {5 }
      {5 6 }
      {5 6 7 }
      {5 6 7 8 }
      {5 6 7 8 9 }
      {5 6 7 8 9 10 }
      {6 }
      {6 7 }
      {6 7 8 }
      {6 7 8 9 }
      {6 7 8 9 10 }
      {7 }
      {7 8 }
      {7 8 9 }
      {7 8 9 10 }
      {8 }
      {8 9 }
      {8 9 10 }
      {9 }
      {9 10 }
      {10 }
  */

  private static void subArrays(int[] nums) {
    int n = nums.length;
    for (int s = 0; s < n; s++) {
      for (int e = s; e < n; e++) {
        print(s, e, nums);
      }
    }
  }

  private static void print(int s, int e, int[] nums) {
    System.out.print("{");
    for (int i = s; i <= e; i++) {
      System.out.print(nums[i] + " ");
    }
    System.out.println("}");
  }

  public static void main(String[] args) {
    subArrays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
  }
}
