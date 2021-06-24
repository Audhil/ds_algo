package _12GreedyAlgorithm;

//  https://www.youtube.com/watch?v=poWB2UCuozA&list=PLqM7alHXFySESatj68JKWHRVhoJ1BxtLW&index=2
//  for sorted arr = O(n)
//  for not sorted arr = O(n log n)
public class _0MaxNoOfActivities {

    public static void main(String[] args) {
        int[] s = {1, 3, 0, 5, 8, 5};
        int[] f = {2, 4, 6, 7, 9, 9};
        int n = s.length;
        printMaxActivities(s, f, n);
    }

    //  end time is sorted
    private static void printMaxActivities(int[] s, int[] f, int n) {
        int i = 0, j = 0;
        System.out.println("activities selected are: ");
        System.out.println(i);

        for (int k = 1; k < f.length; k++) {
            if (s[k] > f[j]) {
                System.out.println(k);
                j++;
            }
        }
    }
}
