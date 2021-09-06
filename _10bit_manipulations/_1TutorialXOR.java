package _10bit_manipulations;

public class _1TutorialXOR {

    /*
     * XOR - https://www.youtube.com/watch?v=bTauscvOymA
     *
     * 1. 5 ^ 5 = 0
     * 2. 0 ^ 5 = 5
     * */
    /*
      1. find no that is not repeeated in the array
    * */
    //  TC: O(n) & SC: O(1)
    private static int findNonRepeatedNumber(int[] arr) {
        int res = 0;
        for (int j : arr) {
            res ^= j;
        }
        return res;
    }

    /*
     * 2. find 2 Non repeated items in the array
     * TC: O(n) & SC: O(1)
     * */
    private static void find2NonRepeatedNumbers(int[] arr) {
        int res = 0;
        for (int j : arr) {
            res ^= j;
        }
        //  res will have 2 unique numbers XORed together
        //  finding last set bit from the num
//        res &= -res;
        res &= ~(res - 1);
        //  iterate through array and divide it in to 2 parts(one with items ending with 1, another ending with 0)
        int sum1 = 0, sum2 = 0;
        for (int j : arr) {
            if ((j & res) > 0)
                sum1 ^= j;
            else
                sum2 ^= j;
        }
        System.out.println("yup: sum1: " + sum1 + ", sum2: " + sum2 + " are non repeating numbers");
    }

    /*
     * 3. find non repeated element in array, where others repeated thrice
     * each element is 32 bit number
     * TC: O(n) & SC: O(1)
     * */
    private static int findNonRepeatedNumberInThriceRepeatedArray(int[] arr, int k) {
        int[] resArr = new int[32];
        for (int i = 0; i < resArr.length; i++) {
            for (int j : arr) {
                if ((j & (1 << i)) != 0) { //  is the bit set in the given number
                    resArr[i] += 1;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < resArr.length; i++) {
            res += (resArr[i] % k) * (1 << i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("yup: non repeated item: " + findNonRepeatedNumber(new int[]{5, 3, 5, 1, 6, 7, 6, 1, 7}));   //  yup: non repeated item: 3
        find2NonRepeatedNumbers(new int[]{2, 3, 7, 9, 11, 2, 3, 11});   //  yup: sum1: 7, sum2: 9 are non repeating numbers
        System.out.println("yup: non repeated item in k repeating items: " + findNonRepeatedNumberInThriceRepeatedArray(new int[]{2, 2, 1, 5, 1, 1, 2}, 3));    //  yup: non repeated item in k repeating items: 5
    }
}
