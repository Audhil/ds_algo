package _0easy;

//  https://leetcode.com/problems/length-of-last-word/
public class LenOfLastWord {

    //  fails for i/p = "a" etc
    public static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0 || s.length() == 1)
            return 0;

        int len = 0, j = s.length() - 1;
        while (s.charAt(j) != ' ') {
            len++;
            j--;
        }
        return len;
    }

    public static int lengthOfLastWordd(String s) {
        if (s == null)
            return 0;

        s = s.trim();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ')
                return s.length() - i - 1;
        }
        return s.length();
    }

    public static void main(String[] args) {
//        System.out.println("yup: " + lengthOfLastWord("Hello World"));
//        System.out.println("yup: " + lengthOfLastWord(" "));
        System.out.println("yup: " + lengthOfLastWordd("a"));
    }
}
