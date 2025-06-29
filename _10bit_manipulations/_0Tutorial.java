package _10bit_manipulations;

public class _0Tutorial {

    //  https://www.youtube.com/watch?v=Db8OmMfzwl8
    //  >> , <<
    /*
        div/ mul
    * 5 >> 1 = 101 >> 1 = 010 = 5/2 = 2
    * 5 << 1 = 101 << 1 = 1010 = 5 * 2 = 10
    *
    * odd/even - with bit masking
    * if(a & 1 == 0){
    *       //  it is even number - for eg: 0100 & 0001 = 0000
    * }
    * else if(a & 1 == 1){
    *       //  it is odd number - for eg: 0111 & 0001 = 0001
    * }
    *
    * swap 2 numbers
        int a = 5 , b = 7;
        a = a ^ b;  a = 101 ^ 111 = 010
        b = a ^ b;  b = 010 ^ 111 = 101 = 5
        a = a ^ b;  a = 010 ^ 101 = 111 = 7
        so, b = 5; a = 7; both are swapped!
    * */

    //  start
    //  https://www.youtube.com/watch?v=h7meukyY_bQ

    private static int findIthBit(int n, int i) {
        int mask = 1 << i;
        if ((n & mask) != 0)
            return 1;
        else
            return 0;
    }

    private static int setIthBit(int n, int i) {
        int mask = 1 << i;
        return n | mask;
    }

    private static int clearIthBit(int n, int i) {
        int mask = 1 << i;
        return n & ~mask;
    }

    private static int noOfSetBitsInNumber(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("find 2nd bit: 100110101: " + findIthBit(0b00110101, 2));    //  find 2nd bit: 100110101: 1
        System.out.println("set 3rd bit: 0111: " + setIthBit(0b0111, 3));   //  set 3rd bit: 0111: 15->(1111)
        System.out.println("clear 1st bit: 0111: " + clearIthBit(0b0111, 1));   //  clear 1st bit: 0111: 5->(0101)
        System.out.println("yup: noOfSetBitsInNumber: " + noOfSetBitsInNumber(15));   //  yup: noOfSetBitsInNumber: 4

        System.out.println("yup: convertDecimalToBinary: " + convertDecimalToBinary(8));    //  yup: convertDecimalToBinary: 1000
        System.out.println("yup: convertBinaryToDecimal: " + convertBinaryToDecimal(1110));    //  yup: convertBinaryToDecimal: 14
        System.out.println("yup: addition(0b1010, 0b0001): " + addBinary(0b1010, 0b0011));  //  yup: addition(0b1010, 0b0001): 13
        System.out.println("yup: subtractBinary(0b1010, 0b0001): " + subtractBinary(0b1010, 0b0011));  //  yup: subtractBinary(0b1010, 0b0001): 7
    }
    //  end

    private static int convertDecimalToBinary(int number) {
        int quotient = number;
        StringBuilder stringBuilder = new StringBuilder();
        while (quotient > 0) {
            stringBuilder.append(quotient % 2);
            quotient /= 2;
        }
        return Integer.parseInt(stringBuilder.reverse().toString());
    }

    private static int convertBinaryToDecimal(int number) {
        int decimal = 0, power = 1;
        while (number > 0) {
            decimal += (number % 10) * power;
            number /= 10;
            power *= 2;
        }
        return decimal;
    }

    private static int addBinary(int a, int b) {
        return a + b;
    }

    private static int subtractBinary(int a, int b) {
        return a - b;
    }
}
