package _0REVISION.easy.dp;

//  https://leetcode.com/problems/pascals-triangle-ii/
//  https://www.youtube.com/watch?v=IWXZAvBIuyE

import java.util.ArrayList;
import java.util.List;

/*
* Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
*
*
* Example 1:

Input: rowIndex = 3
Output: [1,3,3,1]
Example 2:

Input: rowIndex = 0
Output: [1]
Example 3:

Input: rowIndex = 1
Output: [1,1]
 */
//  TC: O(n^2); SC: O(k)
public class _38PascalsTriangleII {

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i++) {
            row.add(1);
        }
        for (int i = 1; i < rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;
    }

    public static void main(String[] args) {
        System.out.println("yup: row: " + getRow(3));
    }
}
