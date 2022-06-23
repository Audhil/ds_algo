package _10Blind25._6GreedyApproach._0Basics;

//  https://www.codechef.com/submit/RAMDEV
public class _0BabaRamdevMats {

  //  ref: https://youtu.be/tw_cqPzpCKM?list=PLQXZIFwMtjozzDH4ZRtpIl0piBjsRF5Bf&t=1954
  private static int noOfPeople(int noOfHalls) {
    int ans = 0;
    //  hall dimensions
    int L = 30, B = 20;
    //  mat dimensions
    int l = 20, b = 15;
    for (int i = 0; i < noOfHalls; i++) {
      //  ((L / b) * (B / l)) - keeping mats horizontally
      //  ((L / l) * (B / b)) - keeping mats vertically
      ans += Math.max(((L / l) * (B / b)), ((L / b) * (B / l)));
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println("yup: babaRamdev mats: " + noOfPeople(30));
  }
}
