package _0easy;

//  https://www.youtube.com/watch?v=JyLrPSJNfYw
public class IntToRoman {

    private static String intToRoman(int number) {
        String[] units = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] thousands = {"", "M", "MM", "MMM"};
        return thousands[(number / 1000) % 10] +
                hundreds[(number / 100) % 10] +
                tens[(number / 10) % 10] +
                units[number % 10];
    }

    public static void main(String[] args) {
        System.out.println("yup: " + intToRoman(2234)); //  MMCCXXXIV
        System.out.println("yup: " + intToRoman(223)); //  CCXXIII
        System.out.println("yup: " + intToRoman(408)); //  CDVIII
    }
}
