package _0REVISION.easy.strings;

//  https://leetcode.com/problems/remove-outermost-parentheses/
public class _33RemoveOutermostParanthesis {

    public static String removeOuterParentheses(String s) {
        if (s == null)
            return null;

        int count = 0;
        StringBuilder sBuilder = new StringBuilder();
        StringBuilder resBuilder = new StringBuilder();
        for (char ch : s.toCharArray()) {
            sBuilder.append(ch);
            if (ch == '(')
                count++;
            else if (ch == ')')
                count--;
            if (count == 0) {
                resBuilder.append(sBuilder.substring(1, sBuilder.length() - 1));
                sBuilder = new StringBuilder();
            }
        }
        return resBuilder.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println("yup: "+removeOuterParentheses("(()())(())"));   //  yup: ()()()
        System.out.println("yup: "+removeOuterParentheses("(()())(())(()(()))"));   //  yup: ()()()()(())
        System.out.println("yup: "+removeOuterParentheses("()()"));   //  yup:
    }
}
