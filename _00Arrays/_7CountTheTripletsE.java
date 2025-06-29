package _00Arrays;

//  https://www.youtube.com/watch?v=eZJvV3bmEsA&ab_channel=KrishnaTeaches
//  https://practice.geeksforgeeks.org/problems/count-the-triplets4615/1
//  using sorting: https://youtu.be/YnEHFYwQwyU
//  confused solve: https://www.geeksforgeeks.org/count-triplets-such-that-one-of-the-numbers-can-be-written-as-sum-of-the-other-two/
public class _7CountTheTripletsE {

  //  TC: O (n^2)
  private static int countTriplet(int[] arr, int n) {
    //  1. item available arr
    int[] itemAvailableArr = new int[100000]; //  constraint given in arr
    for (int item : arr) {
      itemAvailableArr[item] = 1;
    }
    //  2. check for the triplets
    int cnt = 0;
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        if (itemAvailableArr[arr[i] + arr[j]] == 1) {
          cnt++;
        }
      }
    }
    return cnt;
  }

  public static void main(String[] args) {
    System.out.println("yup: countTriplet: " + countTriplet(new int[]{1, 5, 3, 2}, 4)); //  2
    System.out.println("yup: countTriplet: " + countTriplet(new int[]{2, 3, 4}, 3));  //  0
  }
}
