package _10Blind25._6GreedyApproach._5JobScheduling;

import java.util.Arrays;
import java.util.PriorityQueue;

//  https://www.codechef.com/problems/FAIRELCT
//  ref: https://www.youtube.com/watch?v=dA1jjx-CAeQ&list=PLQXZIFwMtjozzDH4ZRtpIl0piBjsRF5Bf&index=6
public class _0FairElect {

  //  I'm friend of John and make him win.
  //  swap votes -> minHeap of John, maxHeap of Jack
  private static int fairElectionWithHeaps(int[] johnVotes, int[] jackVotes) {
    int sum_john = 0, sum_jack = 0, numOfSwaps = 0;
    //  1. minHeap for John
    PriorityQueue<Integer> pqJohn = new PriorityQueue<>();
    for (int johnVote : johnVotes) {
      sum_john += johnVote;
      pqJohn.add(johnVote);
    }
    //  2. maxHeap for Jack
    PriorityQueue<Integer> pqJack = new PriorityQueue<>((a, b) -> b - a);
    for (int jackVote : jackVotes) {
      sum_jack += jackVote;
      pqJack.add(jackVote);
    }
    //  4. early results
    if (sum_john > sum_jack) {
      return numOfSwaps;
    }
    //  5. start swapping
    while (!pqJack.isEmpty() && !pqJohn.isEmpty()) {
      sum_john += pqJack.peek();
      sum_john -= pqJohn.peek();
      sum_jack += pqJohn.peek();
      sum_jack -= pqJack.peek();
      pqJack.remove();
      pqJack.add(pqJohn.peek());
      pqJohn.remove();
      pqJohn.add(pqJack.peek());
      numOfSwaps++;
      if (sum_john > sum_jack) {
        break;
      }
    }
    return numOfSwaps;
  }

  private static int fairElectionWithArrays(int[] johnVotes, int[] jackVotes) {
    int sum_john = 0, sum_jack = 0, numOfSwaps = 0;
    //  1. sort johnVotes ascending
    Arrays.sort(johnVotes);
    //  2. sort jackVotes descending - bubble sort
    int temp;
    for (int i = 0; i < jackVotes.length; i++) {
      for (int j = i + 1; j < jackVotes.length; j++) {
        if (jackVotes[i] < jackVotes[j]) {
          temp = jackVotes[i];
          jackVotes[i] = jackVotes[j];
          jackVotes[j] = temp;
        }
      }
    }
    //  3. calculate sum of votes
    for (int johnVote : johnVotes) {
      sum_john += johnVote;
    }
    for (int jackVote : jackVotes) {
      sum_jack += jackVote;
    }
    //  4. early results
    if (sum_john > sum_jack) {
      return numOfSwaps;
    }
    //  5. start swapping
    temp = 0;
    while (temp < Math.min(johnVotes.length, jackVotes.length)) {
      sum_john += jackVotes[temp];
      sum_john -= johnVotes[temp];
      sum_jack += johnVotes[temp];
      sum_jack -= jackVotes[temp];
      numOfSwaps++;
      if (sum_john > sum_jack) {
        break;
      }
      temp++;
    }
    return numOfSwaps;
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: fairElectionWithArrays noOfSwaps: to make John win the election: " +
            fairElectionWithArrays(new int[]{2, 2}, new int[]{5, 5, 5}));

    System.out.println(
        "yup: fairElectionWithHeaps noOfSwaps: to make John win the election: " +
            fairElectionWithHeaps(new int[]{2, 2}, new int[]{5, 5, 5}));

    System.out.println(
        "yup: fairElectionWithArrays noOfSwaps: to make John win the election: " +
            fairElectionWithArrays(new int[]{1, 3, 2, 4}, new int[]{6, 7, 8}));

    System.out.println(
        "yup: fairElectionWithHeaps noOfSwaps: to make John win the election: " +
            fairElectionWithHeaps(new int[]{1, 3, 2, 4}, new int[]{6, 7, 8}));
  }
}
