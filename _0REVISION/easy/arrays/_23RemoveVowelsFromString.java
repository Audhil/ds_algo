package _0REVISION.easy.arrays;

//  https://www.youtube.com/watch?v=dzAVG6MI6EU
//  https://leetcode.com/problems/remove-vowels-from-a-string/
public class _23RemoveVowelsFromString {

    public static String removeVowels(String s) {
        if (s == null)
            return null;

        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                continue;
            }
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println("yup: remove vowels: " + removeVowels("leetcodeisacommunityforcoders")); //  yup: remove vowels: ltcdscmmntyfrcdrs
    }
}
