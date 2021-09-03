package _0REVISION.easy.dp;

import java.util.ArrayList;
import java.util.List;

//  https://leetcode.com/problems/pascals-triangle/
//  https://www.youtube.com/watch?v=icoql2WKmbA
public class _37PascalsTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows == 0)
            return triangle;

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);

        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = triangle.get(i - 1);
            List<Integer> currRow = new ArrayList<>();
            currRow.add(1);
            for (int j = 1; j < i; j++) {   //  row1 will have 1 item, row2 will have 2 items, row3 will have 3 items
                currRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            currRow.add(1);
            triangle.add(currRow);
        }
        return triangle;
    }

    public static void main(String[] args) {
        System.out.println("yup: pascal triangle: " + generate(5)); //  yup: pascal triangle: [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]
        /*
        *
        *       1
        *      1 1
        *     1 2 1
        *    1 3 3 1
        *   1 4 6 4 1
        * */
    }
}
