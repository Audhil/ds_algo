package _0REVISION.easy.dp;

//  https://leetcode.com/problems/number-of-1-bits/discuss/1436998/Java-0ms-Faster-than-100
public class _35NoOf1bits {

    //  https://www.youtube.com/watch?v=wLHhAHkID9M
    //  approach 1: TC: O(1), SC: O(1)
    //  & with 1, at each digit pos
    public static int hammingWeight(int n) {
        int count = 0, mask = 1;
        for (int i = 0; i < 32; i++) {  //  it'll always loop 32 times
            if ((n & mask) != 0) {
                count++;
            }
            mask <<= 1;
        }
        return count;
    }

    //  approach 2:
    //  more optimized. TC: O(1), SC: O(1)
    public static int hammingWeightOptimized(int n) {
        int count = 0;
        while (n != 0) {
            n = (n & n - 1);
            count++;
        }
        return count;
    }

    //  approach 3:
    //  recursive calls: TC: O(1), SC: based on call stacks
    public static int hammingWeightRecursive(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return hammingWeightRecursive(n & (n - 1)) + 1;
    }

    public static void main(String[] args) {
        System.out.println("yup: " + hammingWeight(00000000000000000000000000001011));
        System.out.println("yup: optimized: " + hammingWeightOptimized(00000000000000000000000000001011));
        System.out.println("yup: recursive: " + hammingWeightRecursive(00000000000000000000000000001011));
    }
}