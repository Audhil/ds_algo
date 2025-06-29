package _0REVISION.easy.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//  https://www.lintcode.com/problem/1204/
/*
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's
 * of American keyboard like the following example.
 *
 * https://leetcode.com/problems/single-row-keyboard/
 **/
public class _26SingleRowKeyboard {

    public static String[] findWords(String[] words) {
        String keysRow1 = "QWERTYUIOP";
        String keysRow2 = "ASDFGHJKL";
        String keysRow3 = "ZXCVBNM";
        List<String> list = new ArrayList<>();
        for (String word : words) {
            String s = String.valueOf(word.charAt(0)).toUpperCase();
            String currRow = keysRow1.contains(s) ? keysRow1 : keysRow2.contains(s) ? keysRow2 : keysRow3;
            boolean flag = true;
            for (char ch : word.toUpperCase().toCharArray()) {

                if (!currRow.contains(String.valueOf(ch))) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                list.add(word);
        }
        return list.toArray(new String[0]);
    }

    public static void main(String[] args) {
//        System.out.println("yup: " + Arrays.toString(findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"})));
//        System.out.println("yup: " + Arrays.toString(findWords(new String[]{"qaz","wsx","edc","rfv","tgb","yhn","ujm","ik","pklo","ppppppp"})));
        System.out.println("yup: " + Arrays.toString(findWords(new String[]{"aaaa"})));
    }
}
