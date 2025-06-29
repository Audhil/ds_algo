package _0REVISION.easy.strings;

//  https://leetcode.com/problems/replace-all-digits-with-characters/
public class _32ReplaceDigitsWithChars {

    public static String replaceDigits(String s) {
        if (s == null)
            return null;

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            //  at odd index
            if (i % 2 != 0) {
                stringBuilder.append(shift(s.charAt(i - 1), s.charAt(i)));
            } else {
                stringBuilder.append(s.charAt(i));
            }
        }

        return stringBuilder.toString().trim();
    }

    private static Character shift(char ch, char number) {
        return (char) (ch + Integer.parseInt(String.valueOf(number)));
    }

    public static void main(String[] args) {
        System.out.println("yup: " + replaceDigits("a1c1e1"));  //  abcdef
        System.out.println("yup: " + replaceDigits("a1b2c3d4e"));   //  abbdcfdhe
    }
}
