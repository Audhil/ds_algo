package _7F2FInterviews;

import java.util.Arrays;

//  https://youtu.be/uo4kuV3pWfE?list=PL_z_8CaSLPWdJfdZHiNYYM46tYQUjbBJx
//  time complexity - O (n)
//  disclaimer: SwapSort doesn't work on const(immutable) arrays, if it is said so, then go back to prev (1). map or (2). maths flow
public class _2FindMissingAndDuplicateUsingSwapSort {

    private int[] arr = {2, 3, 1, 5, 1};
    private int[] arr2 = {2, 3, 1, 8, 2, 3, 5, 1};  //  multi duplicate & multi missing
    private int[] arr3 = {3, 4, 5, 1, 2};   //  for worst case
    private int[] arr4 = {3, 5, 5, 1, 2};   //  for worst case, with duplicate item

    private void solveWithSwapSort() {
        System.out.println(Arrays.toString(arr2));
        int i = 0;
        while (i < arr2.length) {
            if (arr2[i] != arr2[arr2[i] - 1])
                swapp(i, arr2[i] - 1, arr2);
            else
                i++;
        }
        System.out.println(Arrays.toString(arr2));
        for (int index = 0; index < arr2.length; index++) {
            if (arr2[index] != index + 1) {
                System.out.println("yup: missing no: " + (index + 1));
                System.out.println("yup: duplicate no: " + arr2[index]);
            }
        }
    }

    private void swapp(int index1, int index2, int[] arr) {
        arr[index1] = arr[index1] + arr[index2];
        arr[index2] = arr[index1] - arr[index2];
        arr[index1] = arr[index1] - arr[index2];
    }


    public static void main(String[] args) {
        _2FindMissingAndDuplicateUsingSwapSort prob = new _2FindMissingAndDuplicateUsingSwapSort();
        prob.solveWithSwapSort();
    }
}
