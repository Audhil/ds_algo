package _0REVISION.easy.arrays;

//  https://leetcode.com/problems/shuffle-string/
public class _13ShuffleString {

    public static String restoreString(String s, int[] indices) {
        if (s == null || indices == null)
            return null;
        char[] chars = new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
            int index = indices[i];
            chars[index] = s.charAt(i);
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println("yup: restoreString: " + restoreString("codeleet", new int[]{4, 5, 6, 7, 0, 2, 1, 3}));
    }
}
