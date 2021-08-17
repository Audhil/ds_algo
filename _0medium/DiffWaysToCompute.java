package _0medium;

import java.util.ArrayList;
import java.util.List;

//  https://www.youtube.com/watch?v=binXv9-uT3A
//  https://leetcode.com/problems/different-ways-to-add-parentheses/submissions/
//  notes @ https://photos.google.com/photo/AF1QipPbbvW1pfgNa20UbdRYin_8DzJzHXFX8zf0wBnh
public class DiffWaysToCompute {

    public static List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        for (int c = 0; c < expression.length(); c++) {
            char ch = expression.charAt(c);
            if (ch == '+' || ch == '-' || ch == '*') {
                String a = expression.substring(0, c);
                String b = expression.substring(c + 1);

                List<Integer> aList = diffWaysToCompute(a);
                List<Integer> bList = diffWaysToCompute(b);

                for (Integer aInteger : aList) {
                    for (Integer bInteger : bList) {
                        if (ch == '+')
                            res.add(aInteger + bInteger);
                        if (ch == '-')
                            res.add(aInteger - bInteger);
                        if (ch == '*')
                            res.add(aInteger * bInteger);
                    }
                }
            }
        }
        if (res.size() == 0)
            res.add(Integer.valueOf(expression));
        return res;
    }

    public static void main(String[] args) {
        System.out.println("yup: DiffWaysToCompute with parenthesis: " + diffWaysToCompute("2*3*4-5+1"));
        //  o/p: yup: DiffWaysToCompute with parenthesis: [-12, 0, 12, -4, 16, -12, 0, 18, 18, -5, 15, -5, 20, 20]
    }
}
