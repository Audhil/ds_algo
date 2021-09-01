package _0REVISION.easy.arrays;

//  https://leetcode.com/problems/defanging-an-ip-address/
public class _25DefangIPAddr {

    public static String defangIPaddr(String address) {
        if (address == null)
            return null;

        StringBuilder str = new StringBuilder();
        for (char ch : address.toCharArray()) {
            if (ch == '.') {
                str.append("[.]");
                continue;
            }
            str.append(ch);
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println("yup: IPaddr: " + defangIPaddr("1.1.1.1"));
        System.out.println("yup: IPaddr: " + defangIPaddr("255.100.50.0"));
    }
}
