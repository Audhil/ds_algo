package _0hard;

import java.util.HashMap;
import java.util.Map;

//  https://www.youtube.com/watch?v=9UEHPiK53BA
public class DistinctSubsequence {

    private static long solve(String str) {
        long[] dp = new long[str.length() + 1];   //  +1 to hold "" subsequence
        dp[0] = 1; //   "" is also a subsequence

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 1; i < dp.length; i++) {
            dp[i] = 2 * dp[i - 1];
            char ch = str.charAt(i - 1);
            if (map.containsKey(ch)) {
                int index = map.get(ch);
                dp[i] -= dp[index - 1];
            }
            map.put(ch, i);
        }

        return dp[str.length()] - 1;
    }

    public static void main(String[] args) {
        System.out.println("yup: " + solve("abcbac"));
    }
}
