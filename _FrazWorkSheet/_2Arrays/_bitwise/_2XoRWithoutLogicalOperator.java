package _FrazWorkSheet._2Arrays._bitwise;

//  https://youtu.be/aVZcIRPuJ78?t=284
public class _2XoRWithoutLogicalOperator {

  private static int xor(int x, int y) {
    return (~x | ~y) & (x | y);
  }

  public static void main(String[] args) {
    System.out.println("xor of 3,5 : " + xor(3, 5));  //  xor of 3,5 : 6
  }
}
