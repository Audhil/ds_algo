package _11backtracking;

//  https://www.youtube.com/watch?v=kxpQk_IP6bY&list=PLNxqWc8Uj2LTaaxs-8vzK0Ft47rMggFnN&index=14
/*
 * string: summer
 * pattern: s * e ? -> whereas, * - any length of chars(string) including empty string, ? - will place only one char
 *
 * sample code: https://github.com/kashish098/Data-Structures-and-Algorithms/blob/master/Backtracking/11)Pattern_matching.cpp
 * */
public class _11StringWildCardPatternMatching {

    public static void main(String[] args) {
        String str = "summer";
//        String pattern = "s*e??*?r";    //  false
        String pattern = "s*e?";    //  false
        System.out.println("yup: is pattern matches: " + isWildCardPatternMatching(0, 0, str, pattern));
    }

    private static boolean isWildCardPatternMatching(int i, int j, String str, String pattern) { //  i - str ptr, j - pattern ptr
        //  iteration is successful
        //  b1
        if (i == str.length() && j == pattern.length())
            return true;

        //  b2
        if (i == str.length()) {
            for (int k = i; k < pattern.length(); k++)
                if (pattern.charAt(k) != '*')
                    return false;
            return true;
        }

        //  b3
        if (j == pattern.length())
            return false;

        if (pattern.charAt(j) == '?')
            return isWildCardPatternMatching(i + 1, j + 1, str, pattern);

        if (pattern.charAt(j) == '*')
            return isWildCardPatternMatching(i + 1, j, str, pattern) || isWildCardPatternMatching(i, j + 1, str, pattern);

        //  if first char itself not
        if (str.charAt(i) != pattern.charAt(j))
            return false;

        return isWildCardPatternMatching(i + 1, j + 1, str, pattern);
    }
}
