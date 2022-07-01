package _10Blind25._6GreedyApproach._6TopQuestions;

import java.util.Arrays;

//  https://youtu.be/lZJGbS12mWo?list=PLQXZIFwMtjozzDH4ZRtpIl0piBjsRF5Bf&t=6297
public class _3TicketCounter {

  //  coins with 5, 10, 20
  //  always try to keep 5
  //  return change of Rs. 5 for given Rs. 10
  //  return change of (Rs. 5 + Rs. 10) or (Rs. 5 + Rs. 5 + Rs. 5) for given Rs. 20
  private static boolean canWeSatisfyAllCustomers(int[] customers) {
    if (customers == null) {
      return false;
    }
    int countOf5 = 0, countOf10 = 0, countOf20 = 0;
    Arrays.sort(customers);
    for (int customer : customers) {
      if (customer == 5) {
        countOf5++;
      } else if (customer == 10) {
        countOf5--;
        countOf10++;
      } else if (customer == 20) {
        countOf5--;
        if (countOf10 > 0) {
          countOf10--;
        } else {
          countOf5--;
        }
      }
      if (countOf5 < 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println("can you satisfy customers with change: " + canWeSatisfyAllCustomers(
        new int[]{5, 5, 5, 10, 20})); //  true
    System.out.println("can you satisfy customers with change: " + canWeSatisfyAllCustomers(
        new int[]{5, 5, 5, 10, 20, 20})); //  false
    System.out.println("can you satisfy customers with change: " + canWeSatisfyAllCustomers(
        new int[]{20, 5, 5, 10, 20, 20}));  //  false
  }
}
