package ds_algo._0dynamic_programming._4MatrixChainMultiplication;

import java.util.HashMap;

//  https://youtu.be/SqA0o-DGmEw?list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go
//  https://www.interviewbit.com/problems/scramble-string/
public class _8ScrambledStringsRecursive_Memoized {
    /*
    * Scramble String using Recursion
        Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
        Below is one possible representation of A = “great”:
         great
           /    \
          gr    eat
         / \    /  \
        g   r  e   at
                   / \
                  a   t
        To scramble the string, we may choose any non-leaf node and swap its two children.

        For example, if we choose the node “gr” and swap its two children, it produces a scrambled string “rgeat”.

            rgeat
           /    \
          rg    eat
         / \    /  \
        r   g  e   at
                   / \
                  a   t
        We say that “rgeat” is a scrambled string of “great”.

        Similarly, if we continue to swap the children of nodes “eat” and “at”, it produces a scrambled string “rgtae”.

            rgtae
           /    \
          rg    tae
         / \    /  \
        r   g  ta  e
               / \
              t   a
        We say that “rgtae” is a scrambled string of “great”.
    * */

//    private String str1 = "phqtrnilf";    //  false - both are not scrambled string
//    private String str2 = "ilthnqrpf";    //  false - both are not scrambled string

    private String str1 = "great";
    private String str2 = "great";
//    private String str2 = "aetrg";
//    private String str2 = "aetrge";

    private HashMap<String, Integer> map = new HashMap<>();

    //  code from: https://www.interviewbit.com/problems/scramble-string/
    public int isScramble(final String a, final String b) {
        if (a.compareTo(b) == 0)
            return 1;
        else if (a.length() <= 1)
            return 0;

        String keyValue = a + " " + b;
        if (map.containsKey(keyValue))
            return map.get(keyValue);

        int n = a.length();
        int flagScramble = 0;
        for (int i = 1; i <= n - 1; i++) {
            boolean cond1 = (isScramble(a.substring(0, i), b.substring(n - i, n)) == 1 && isScramble(a.substring(i, n), b.substring(0, n - i)) == 1);   //  when swapped
            boolean cond2 = (isScramble(a.substring(0, i), b.substring(0, i)) == 1 && isScramble(a.substring(i, n), b.substring(i, n)) == 1);   //  when not swapped - for eg., a = great, b = great
            if (cond1 || cond2) {
                flagScramble = 1;
                break;
            }
        }
        map.put(keyValue, flagScramble);
        return flagScramble;
    }

//    this is not working - check it later
//    private boolean solve(String a, String b) {
//        if (a.compareTo(b) == 0)  //  if both strings are equal, then it's scrambled strings
//            return true;
//        if (a.length() <= 1) //  if there's "" in any string, it's not allowed
//            return false;
//
//        //  condition
//        int n = a.length(); //  both str1, str2 are equal in length
//        boolean flag = false;
//        for (int i = 1; i <= n - 1; i++) {
//            boolean condn1, condn2;
//            condn1 = condn2 = false;
//            if (solve(a.substring(0, i), b.substring(n - i, i)) && solve(a.substring(i, n), b.substring(0, n - i))) //  when swap happened
//                condn1 = true;
//            if (solve(a.substring(0, i), b.substring(0, i)) && solve(a.substring(i, n), b.substring(i, n)))  //  when swap is not happened
//                condn2 = true;
//            if (condn1 || condn2) {
//                flag = true;
//                break;
//            }
//        }
//        return flag;
//    }

    public static void main(String[] args) {
        _8ScrambledStringsRecursive_Memoized prob = new _8ScrambledStringsRecursive_Memoized();
        boolean isScrambledString;
        if (prob.str1.length() != prob.str2.length())
            isScrambledString = false;
        else if (prob.str1.isEmpty() && prob.str2.isEmpty())  //  since both strings are equal, one is scrambled string of another
            isScrambledString = true;
        else
            isScrambledString = prob.isScramble(prob.str1, prob.str2) == 1;
        System.out.println("yup it is scrambled string: " + isScrambledString);
    }
}
