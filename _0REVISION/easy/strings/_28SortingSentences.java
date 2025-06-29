package _0REVISION.easy.strings;

import java.util.HashMap;
import java.util.Map;

//  https://leetcode.com/problems/sorting-the-sentence/submissions/
public class _28SortingSentences {
    public static String sortSentence(String s) {
        if (s == null)
            return null;

        Map<Integer, String> map = new HashMap<>();
        String[] strArry = s.split(" ");
        for (String str : strArry) {
            map.put(Character.getNumericValue(str.charAt(str.length() - 1)), str.substring(0, str.length() - 1));
        }
        // System.out.println(map);
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < strArry.length; i++) {
            sBuilder.append(map.get(i + 1)).append(" ");
        }
        return sBuilder.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println("yup: " + sortSentence("is2 sentence4 This1 a3"));   //  yup: This is a sentence
    }
}
