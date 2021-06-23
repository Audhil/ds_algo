package _11backtracking;

import java.util.Arrays;
import java.util.List;

//  https://www.youtube.com/watch?v=TM1RC49VCo8&list=PLNxqWc8Uj2LTaaxs-8vzK0Ft47rMggFnN&index=9
//  notes @ https://photos.google.com/album/AF1QipMLL_acuhN6YogZ1XMenF02iNt7vVctR7ZvlyE_/photo/AF1QipNAgOiWC6P6jy8ILkLvE2bWqqw_ud1Jcf1YDeWN
public class _6WordBreakWithBackTracking {

    public static void main(String[] args) {
        String word = "ilovesamsungmobile"; //  split this string in parts such a way, if it is available in dict
//        String word = "heaven"; //  split this string in parts such a way, if it is available in dict
        List<String> dict =
                Arrays.asList("mobile", "samsung", "sam", "sung",
                        "man", "mango", "icecream", "and",
                        "go", "i", "love", "ice", "cream");
//                Arrays.asList("he", "hea", "a", "ab", "ven");
        System.out.println("yup: is word break available in dict: " + wb(0, 0, word.length(), word, dict));
    }

    private static boolean wb(int i, int j, int length, String word, List<String> dict) {
        if (j == length) {
            if (i == length) //  if both pointers pass end of str, we conclude as iteration is over and found all parts in dict
                return true;
            return false;
        }
        int lengthOfWordBreak = j - i + 1;
        String wordBreak = word.substring(i, i + lengthOfWordBreak);
        //  if not found
        if (!dict.contains(wordBreak))
            return wb(i, j + 1, length, word, dict);
            //  if found
        else {
            if (wb(i, j + 1, length, word, dict))
                return true;
            else
                return wb(j + 1, j + 1, length, word, dict);
        }
    }
}
