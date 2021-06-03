package _0easy;

//  https://leetcode.com/problems/implement-strstr
public class Strstr {

    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty())
            return 0;

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle))
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("yup: " + strStr("hello", "ll"));
    }
}