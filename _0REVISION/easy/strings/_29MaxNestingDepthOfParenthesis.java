package _0REVISION.easy.strings;

//  https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/submissions/
public class _29MaxNestingDepthOfParenthesis {

    public static int maxDepth(String s) {
        if (s == null)
            return 0;

        int maxCount = Integer.MIN_VALUE, count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(')
                count++;
            else if (ch == ')')
                count--;

            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    public static void main(String[] args) {
        System.out.println("yup: " + maxDepth("(1+(2*3)+((8)/4))+1"));  //  yup: 3
        System.out.println("yup: " + maxDepth("(1)+((2))+(((3)))"));    //  yup: 3
        System.out.println("yup: " + maxDepth("1+(2*3)/(2-1)"));        //  yup: 1
        System.out.println("yup: " + maxDepth("1"));                    //  yup: 0
    }
}
