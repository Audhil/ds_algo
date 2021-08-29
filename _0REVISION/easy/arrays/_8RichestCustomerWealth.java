package _0REVISION.easy.arrays;

//  https://leetcode.com/problems/richest-customer-wealth/
public class _8RichestCustomerWealth {

    public static int maximumWealth(int[][] accounts) {
        if (accounts == null)
            return 0;

        int maxWealth = Integer.MIN_VALUE;
        for (int i = 0; i < accounts.length; i++) {
            int currWealth = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                currWealth += accounts[i][j];
            }
            maxWealth = Math.max(maxWealth, currWealth);
        }
        return maxWealth;
    }

    public static void main(String[] args) {
        System.out.println("yup: " + maximumWealth(new int[][]{{1, 2, 3}, {3, 2, 1}}));
        System.out.println("yup: " + maximumWealth(new int[][]{{1, 5}, {7, 3}, {3, 5}}));
        System.out.println("yup: " + maximumWealth(new int[][]{{2, 8, 7}, {7, 1, 3}, {1, 9, 5}}));
    }
}
