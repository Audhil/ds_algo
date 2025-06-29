package _10bit_manipulations;

//  https://www.educative.io/blog/bit-manipulation-in-java
public class Tutorial {

    //  AND - & =>
    //  1. to check particular bit is set(1) or clear(0) of a register?
    //  2. used to clear selected bits of a register
    public static void mainn(String[] args) {
        int x = 12; //  1100
        int y = 10; //  1010
        //  1000
        System.out.println("x & y : " + (x & y));   //  8
    }

    //  OR - | =>
    //  used as an interim logic step for solving other problems.
    public static void mainnn(String[] args) {
        int x = 12;
        int y = 10;
        System.out.println("x & y : " + (x | y));   //  14
    }

    //  NOT - ~ =>
    //  NOT is useful for flipping unsigned numbers to the mirrored value on the opposite side of their mid point.
    public static void mainnnn(String args[]) {
        int a = 1;
        System.out.println("Bitwise NOT of a is : " + ~a);
    }

    //  XOR Operator
    /*
    * XOR is used to invert selected individual bits in a register or manipulate bit patterns that represent Boolean states.
        XOR is also sometimes used to set the value of a registry to zero as XOR with two of the same input will always result in 0.
    * */
    public static void mainnnnn(String args[]) {
        int x = 12;
        int y = 10;
        System.out.println("Bitwise XOR of (x , y) is : " + (x ^ y)); // yields to 6
    }

    //  Left & Right shift
    //  << - arithmetic & logic shift
    //  >> - arithmetic or signed right shift operator
    //  >>> - logical or unsigned right shift operator
    /*
     * 6 << 1 = 6 * 2^1 = 12
     * 6 << 3 = 6 * 2^3 = 48
     * Well-optimized compilers will use this rule to replace multiplication with shifts whenever possible, as shifts are faster.
     * */
    private static int shiftHelper(int num, int i) {
        return num << i;
    }

    public static void mainnnnnn(String[] args) {
        System.out.println("yup: " + shiftHelper(100, 1));
        System.out.println("yup: " + shiftHelper(100, 2));
        System.out.println("yup: " + shiftHelper(100, 3));
        System.out.println("yup: " + shiftHelper(100, 4));
    }

    /*
    * 1. With right shift, you can either do arithmetic (>>) or logical (>>) shift.
    The difference is that arithmetic shifts maintain the same most significant bit (MSB) or sign bit,
    * the leftmost bit which determines if a number is positive or negative.
    *
    *
    * 10110101 >> 1= 1101 1010
    * x >> y = x / 2^y
    *
    * 2. On the other hand, a logical shift simply moves everything to the right and replaces the MSB with a 0.
    *
    * 10110101 >>> 1= 0101 1010
    * a >>> b = a/2^b
    * */

    /*
     * tricks in Bit manipulation
     * */
    //  1. Check if a number is even
    /*
            (x & 1 ) == 0
              0110 (6)
            & 0001
            = 0000 TRUE

            This solution relies on two things:

        2 equates to 0001
        The rightmost number for all odd numbers greater than 2 is 1
        Any time the final bit evaluates to 1, you know that it matched and is, therefore, an odd number.
        If it instead evaluates to 0, you know that no numbers matched and therefore it’s even.
    * */

    /*
    * 2. Convert characters to uppercase or lowercase
        This trick tests your knowledge of uppercase and lowercase characters in binary.
        You can convert any character, ch, to the opposite case using ch ^= 32.
        * */
    private static String toggleCase(char[] a) {
        for (int i = 0; i < a.length; i++)
            a[i] ^= 32;
        return new String(a);
    }

    public static void main1(String[] args) {
        String str = "jack And JILl WeNT uPTo HILL to FeTCH a PaIL oF WaTeR";
        System.out.println("toggle case: ");
        str = toggleCase(str.toCharArray());
        System.out.println(str);
        System.out.println("original str: ");
        str = toggleCase(str.toCharArray());
        System.out.println(str);
    }

    /*
     * 3. AND Challenge: Count set bits
     * Write a Java program to count the number of bits set to 1 (set bits) of an integer.
     */
    private static String convertToBinary(int num) {
        StringBuilder sBuilder = new StringBuilder();
        while (num > 0) {
            sBuilder.append(num % 2);
            num /= 2;
        }
        return sBuilder.reverse().toString();
    }

    /*
    * In this approach, we count only the set bits. So,

        If a number has 2 set bits, then the while loop runs two times.
        If a number has 4 set bits, then the while loop runs four times.
        Our while loop iterates until n = 0,
        * dividing by 2 each time via the AND operator.
        * On pass 1, 125 becomes 62, and count increases by 1.
        * On the second pass, 62 becomes 31, and the count increases to 2.
        * This continues until n becomes 0 and the count is then returned.
    * */
    private static int countSetBit(int num) {
        int count = 0;
        while (num > 0) {
            num &= (num - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("yup: " + convertToBinary(50));  //  it is '110010' -  has 3 set bit
        System.out.println("yup: no Of set bits : " + countSetBit(50)); //  returns 3
    }
}
