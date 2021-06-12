package _0easy;

//  https://leetcode.com/problems/add-binary/
public class AddBinary {

    public static String addBinary(String a, String b) {
        int indexA = a.length() - 1, indexB = b.length() - 1;
        int sum, carry = 0;
        StringBuilder builder = new StringBuilder();
        while (indexA >= 0 || indexB >= 0) {
            sum = carry;
            if (indexA >= 0)
                sum += a.charAt(indexA--) - '0';
            if (indexB >= 0)
                sum += b.charAt(indexB--) - '0';
            carry = sum > 1 ? 1 : 0;
            builder.append(sum % 2);
        }
        if (carry == 1)
            builder.append(1);
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println("yup: " + addBinary("11", "10"));
    }
}
