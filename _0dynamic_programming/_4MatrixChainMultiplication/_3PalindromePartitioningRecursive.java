package ds_algo._0dynamic_programming._4MatrixChainMultiplication;

// https://youtu.be/szKVpQtBHh8?list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go
public class _3PalindromePartitioningRecursive {

    //  find min partitions required to make each partition a palindrome
    private String str = "ababbbabbababa";    //  a|babbbab|b|ababa - 3
//    private String str = "nitik"; //  n|iti|k - 2
//    private String str = "nitin"; //  0 - since nitin itself a palindrome

    private int solve(String str, int i, int j) {
        if (i >= j)
            return 0;

        if (isPalindrome(str, i, j))
            return 0;

        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int tempAns = solve(str, i, k)  //  based on scheme
                    + solve(str, k + 1, j) //  based on scheme
                    + 1; //  it's partition done, to make scheme separation
            if (min > tempAns)
                min = tempAns;
        }
        return min;
    }

    private boolean isPalindrome(String str, int i, int j) {
        if (i == j)  //  if only 1 char is available in str, it's palindrome by default
            return true;

        if (i > j)   //  i passed j, it's empty str, hence it's palindrome by default
            return true;

        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        _3PalindromePartitioningRecursive prob = new _3PalindromePartitioningRecursive();
        int i = 0;  //  0 is allowed, since it's string, no prob of arr[-1] index issues here
        int j = prob.str.length() - 1;   //  last index
        System.out.println("yup min partition needed to make each sec as palindrome: " + prob.solve(prob.str, i, j));
    }
}
