package _6SlidingWindowAlgo;

public class _1MaxSumOfSubArrayWithSizeK {

    private int[] arr = {2, 5, 1, 8, 2, 9, 1};
    private int size = 7;
    private int k = 3;  //  window size

    private int sumOfMaxSubArray() {
        int i = 0, j = 0, sum = 0, mx = Integer.MIN_VALUE;
        while (j < size) {
            sum += arr[j];
            if (j - i + 1 < k)
                j++;
            else if (j - i + 1 == k) {
                mx = Math.max(mx, sum);
                sum -= arr[i];
                i++;
                j++;
            }
        }
        return mx;
    }

    public static void main(String[] args) {
        _1MaxSumOfSubArrayWithSizeK prob = new _1MaxSumOfSubArrayWithSizeK();
        System.out.println("yup: max sum of sub array with size : k : " + prob.k + " is : " + prob.sumOfMaxSubArray());
    }
}
