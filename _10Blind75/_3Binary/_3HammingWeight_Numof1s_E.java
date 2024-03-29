package _10Blind75._3Binary;

//  Number of 1 Bits
public class _3HammingWeight_Numof1s_E {

  //  with weird trick(allowing loop to run times as many os 1's in the number) - TC: O (1)
  //  check it out: https://youtu.be/5Km3utixwZs?t=342
  public static int hammingWeightSoln1(int n) {
    int res = 0;
    while (n != 0) {
      //  mod = 0 when last bit is 0(even number), mod = 1 when last bit is 1(odd number)
      n &= (n - 1);
      res += 1;
    }
    return res;
  }

  //  with recursion
  public static int hammingWeightSoln2(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    return hammingWeightSoln2(n & (n - 1)) + 1;
  }

  //  with TC: O(1)
  //  check it out https://youtu.be/5Km3utixwZs
  private static int hammingWeightWithBitShift(int n) {
    int res = 0;
    while (n != 0) {
      //  mod = 0 when last bit is 0(even number), mod = 1 when last bit is 1(odd number)
      int mod = n % 2;
      res += mod;
      n >>= 1;
    }
    return res;
  }

  //  bit shift - TC: O (1)
  private static int revisionBitShift(int n) {
    if (n == 0) {
      return n;
    }
    int res = 0;
    while (n != 0) {
      res += n % 2; //  returns 1 for odd & 0 for even - add it to our result
      n >>= 1;
    }
    return res;
  }

  //  fastest than previous - TC: O (1)
  private static int revisionFastestSoln(int n) {
    if (n == 0) {
      return n;
    }
    int res = 0;
    while (n != 0) {
      n &= (n - 1);
      res++;
    }
    return res;
  }

  //  fastest than previous - TC: O (1)
  private static int revisionFastestRecursionSoln(int n) {
    if (n == 0 || n == 1) {
      return n;
    }
    return 1 + revisionFastestRecursionSoln(n & n - 1);
  }


  public static void main(String[] args) {
    System.out.println("yup: hammingWeightSoln1 : no of 1's in 5: " + hammingWeightSoln1(5)); //  2
    System.out.println("yup: hammingWeightSoln2 : no of 1's in 5: " + hammingWeightSoln2(5)); //  2
    System.out.println(
        "yup: hammingWeightWithBitShift: no of 1's in 5: " + hammingWeightWithBitShift(5)); //  2

    System.out.println("yup: hammingWeightSoln1 : no of 1's in 5: " + revisionBitShift(5)); //  2
    System.out.println("yup: hammingWeightSoln2 : no of 1's in 5: " + revisionFastestSoln(5)); //  2
    System.out.println(
        "yup: hammingWeightWithBitShift: no of 1's in 5: " + revisionFastestRecursionSoln(7)); //  3
  }
}
