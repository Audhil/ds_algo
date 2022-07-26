package _10Blind75._6GreedyApproach._2HuffmanEncoding;

import java.util.PriorityQueue;

//  to understand priority queue
//  https://www.codechef.com/problems/SAVKONO
//  https://www.youtube.com/watch?v=XxleDeFelGE&list=PLQXZIFwMtjozzDH4ZRtpIl0piBjsRF5Bf&index=4&ab_channel=CodeChef
public class _0SaveKonoha {

  //  we can use priority queue(heap)
  private static void saveKonoha() {
    int giantStrength = 25;
    int attempts = 0;
    int[] soldierStrengths = {3, 2, 11, 5}; //  yup: defeated: attempts: 5
    //  using max heap
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
    for (int strength : soldierStrengths) {
      priorityQueue.add(strength);
    }
    while (!priorityQueue.isEmpty() && giantStrength > 0) {
      int soldierStrength = priorityQueue.poll();
      giantStrength -= soldierStrength;
      attempts++;
      soldierStrength /= 2;
      if (soldierStrength > 0) {
        priorityQueue.add(soldierStrength);
      }
    }
    if (giantStrength <= 0) {
      System.out.println("yup: defeated: attempts: " + attempts);
    } else {
      System.out.println("yup: cannot be defeated: evacuate! Evacuate!");
    }
  }

  public static void main(String[] args) {
    saveKonoha();
  }
}
