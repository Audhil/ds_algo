package _11backtracking;

import java.util.HashSet;
import java.util.Set;

//  https://www.youtube.com/watch?v=ZeZU85fZzE0&list=PLNxqWc8Uj2LTaaxs-8vzK0Ft47rMggFnN&index=4
/*
 * TC:   O(n!)
 * */
public class PermutationsOfString {

    private static void permutationsOfString(int pos, int len, String currString, Set<String> permutations) {
        if (pos == len - 1) {
            permutations.add(currString);
            return;
        }
        for (int i = pos; i < len; i++) {
            currString = swap(currString, pos, i);
            permutationsOfString(pos + 1, len, currString, permutations);
            //  re forming original string for backtracking
            currString = swap(currString, pos, i);
        }
    }

    private static String swap(String str, int posA, int posB) {
        char[] chars = str.toCharArray();
        char temp = chars[posA];
        chars[posA] = chars[posB];
        chars[posB] = temp;
        return String.valueOf(chars);
    }

    //  as per gfg: https://www.geeksforgeeks.org/print-all-permutations-of-a-string-in-java/
    private static void printPermutationOfString(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans + " ");
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            //  res of string
            String ros = str.substring(0, i) + str.substring(i + 1);
            printPermutationOfString(ros, ans + ch);
        }
    }

    private static void printPermutationOfStringWithoutDuplicates(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans + " ");
        }

        boolean[] alphabets = new boolean[26];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            //  res of string
            String ros = str.substring(0, i) + str.substring(i + 1);

            if (!alphabets[ch - 'a'])
                printPermutationOfStringWithoutDuplicates(ros, ans + ch);
            alphabets[ch - 'a'] = true;
        }
    }

    public static void main(String[] args) {
//        String abc = "abc";
        String abc = "abb";
        Set<String> stringSet = new HashSet<>();
        permutationsOfString(0, abc.length(), abc, stringSet);
        System.out.println("yup: permutations: " + stringSet.size());
        for (String perm : stringSet) {
            System.out.println(perm);
        }

        System.out.println("as per GFG:");
        printPermutationOfString("abb", "");
        System.out.println("as per GFG without duplicates:");
        printPermutationOfStringWithoutDuplicates("abb", "");
    }
}
