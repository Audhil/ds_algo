package _8Trees.binarysearchtree;

import java.util.Arrays;

//  https://www.youtube.com/watch?v=fJvkHgnld7s&list=PLNxqWc8Uj2LQpbGv6I_HWf0kTj6kMVVwm&index=31
//  notes @ https://photos.google.com/photo/AF1QipM_VtjnLeW9KZ8Dhqh3g8tDKPkAXR59GO2SvCl_
public class _30UniqueBSTs {

    //  construct unique BSTs from given N elements
    //  f(N) = summation[ f(i - 1) * f(n - i)]

    private static int uniqueBSTs(int n) {
        if (n == 0 || n == 1)
            return 1;

        int count = 0;
        for (int i = 1; i < n; i++) {
            count += (uniqueBSTs(i - 1) * uniqueBSTs(n - i));
        }
        return count;
    }

    //  with memoization
    private static int uniqueBSTsWithMemoization(int n, int[] memArr) {
        if (n == 0 || n == 1)
            return 1;

        if (memArr[n] != -1)
            return memArr[n];
        int count = 0;
        for (int i = 1; i < n; i++) {
            count += (uniqueBSTsWithMemoization(i - 1, memArr) * uniqueBSTsWithMemoization(n - i, memArr));
        }
        return memArr[n] = count;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(System.currentTimeMillis());
        System.out.println("yup: unique BSTs : " + uniqueBSTs(n));
        System.out.println("---" + System.currentTimeMillis());
        int[] memArr = new int[n + 1];
        Arrays.fill(memArr, -1);
        System.out.println(System.currentTimeMillis());
        System.out.println("yup: unique BSTs : " + uniqueBSTsWithMemoization(n, memArr));
        System.out.println("---" + System.currentTimeMillis());
    }
}
