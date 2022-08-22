package _12GreedyAlgorithm;

import java.util.Arrays;

//  it is same as _1GasStationM.java
//  https://www.youtube.com/watch?v=zcnVaVJkLhY&ab_channel=TECHDOSE
public class _2CircularTourProbM {

  public static int canCompleteCircuit(int[] distance, int[] petrol) {
    if (distance.length != petrol.length) {
      return -1;
    }
    int distanceToCover = Arrays.stream(distance).sum();
    int petrolAvailable = Arrays.stream(petrol).sum();
    if (distanceToCover > petrolAvailable) {
      return -1;
    }
    int n = petrol.length;
    int currPetrol = 0;
    int start = 0;
    int deficitPetrol = 0;
    for (int i = 0; i < n; i++) {
      currPetrol += (petrol[i] - distance[i]);
      if (currPetrol < 0) {
        start = i + 1;
        deficitPetrol += currPetrol;
        currPetrol = 0;
      }
    }
    return (currPetrol + deficitPetrol) >= 0 ? start : -1;
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: can complete the circular tour: " +
            canCompleteCircuit(new int[]{4, 6, 7, 4},
                new int[]{6, 5, 5, 5}));  //  yup: can complete the circular tour: 3

    System.out.println(
        "yup: can complete the circular tour: " +
            canCompleteCircuit(new int[]{4, 4, 1, 5, 1},
                new int[]{5, 1, 2, 3, 4}));  //  yup: can complete the circular tour: 4
  }
}
