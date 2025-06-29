package _0easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//  https://leetcode.com/problems/remove-vowels-from-a-string/
//  https://www.youtube.com/watch?v=6KCBrIWEauw
public class RemoveVowelsFromStr {

    public static String removeVowels(String s) {
        if (s == null)
            return null;

        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (!vowels.contains(ch))
                stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }

    //  with regex+java apis
    public static String removeVowelss(String s) {
        return s.replaceAll("[aeiou]", "");
    }

    public static void main(String[] args) {
//        System.out.println("yup: removed vowels result string: " + removeVowels("leetcodeisacommunityfordevelopers"));
        System.out.println("yup: removed vowels result string: " + removeVowelss("leetcodeisacommunityfordevelopers"));
    }
}
