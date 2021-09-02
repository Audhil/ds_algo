package _0REVISION.easy.strings;

import java.util.HashSet;
import java.util.Set;

//  https://leetcode.com/problems/check-if-the-sentence-is-pangram/submissions/
public class _30CheckIfPangram {

    public static boolean checkIfPangram(String sentence) {
        if (sentence == null)
            return false;

        Set<Character> set = new HashSet<>();
        for (char ch : sentence.toCharArray()) {
            set.add(ch);
        }
        return set.size() == 26;    //  there are 26 letters in english alphabet
    }

    public static void main(String[] args) {
        System.out.println("yup: " + checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));    //  true
        System.out.println("yup: " + checkIfPangram("hello world"));        //  false
    }
}
