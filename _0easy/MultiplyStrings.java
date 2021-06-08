package _0easy;

//  https://leetcode.com/problems/multiply-strings/
//  https://leetcode.com/problems/multiply-strings/discuss/1259111/Java-Solution-with-Strong-Explained
//  time comp: O(m * n); space comp: O(m * n)
public class MultiplyStrings {

    public static String multiply(String num1, String num2) {
        if (num1 == null
                || num2 == null
                || num1.equals("0")
                || num2.equals("0"))
            return "0";

        int m = num1.length(), n = num2.length();
        int[] res = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                //  product of 2 numbers
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                // index in the res[], p1 = high position(e.g. ten digit), p2 = like units digit
                int p1 = i + j, p2 = i + j + 1;
                // add the multiply result to res[p2] postion. (first time, the res[p2] is 0).
                int sum = mul + res[p2];
                // add the units digit of sum to res[p2] position
                res[p2] = sum % 10;
                // res[p1] is the carry digit, so should be +=.
                res[p1] += sum / 10;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (res[i] == 0) {
            i++;
        }
        while (i < res.length) {
            stringBuilder.append(res[i]);
            i++;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
//        System.out.println("yup: multiply: " + multiply("12", "3"));
//        System.out.println("yup: multiply: " + multiply("48", "8"));
        System.out.println("yup: multiply: " + multiply("123456", "123456"));
    }
}
