package _0REVISION.easy.arrays;

import java.util.Arrays;

//  https://leetcode.com/problems/decode-xored-array/
public class DecodeXORedArray {

    public static int[] decode(int[] encoded, int first) {
        if (encoded == null)
            return null;
        int[] decoded = new int[encoded.length + 1];    //  as per question
        decoded[0] = first;
        int index = 1;
        for (int i = 0; i < encoded.length; i++)
            decoded[index++] = decoded[i] ^ encoded[i];
        return decoded;
    }

    public static void main(String[] args) {
        System.out.println("yup: decoded array is : " + Arrays.toString(decode(new int[]{1, 2, 3}, 1)));
        System.out.println("yup: decoded array is : " + Arrays.toString(decode(new int[]{6, 2, 7, 3}, 4)));
    }
}
