package _0medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//  https://www.lintcode.com/problem/434/
/*
* Given a n,m which means the row and column of the 2D matrix and an array of pair A( size k).
* Originally, the 2D matrix is all 0 which means there is only sea in the matrix.
* The list pair has k operator and each operator has two integer A[i].x, A[i].y means that you can change the grid matrix[A[i].x][A[i].y] from sea to island.
* Return how many island are there in the matrix after each operator.You need to return an array of size K.
*
0 is represented as the sea, 1 is represented as the island. If two 1 is adjacent, we consider them in the same island. We only consider up/down/left/right adjacent.
*
* https://www.youtube.com/watch?v=PcYCkgYu6uc - using disjoin set union
* */

//  we are solving with DisJoint Set Union
public class IslandCount2 {

    static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    //  m = rows, n = cols
    public static List<Integer> numIslands2(int n, int m, Point[] operators) {
        List<Integer> numOfIslands = new ArrayList<>();
        int[] parents = new int[m * n];
        Arrays.fill(parents, -1);
        int[] rank = new int[m * n];
        int count = 0;
        int[] dirX = {-1, 0, 1, 0};    //  l u r d
        int[] dirY = {0, -1, 0, 1};    //  l u r d
        for (Point operator : operators) {
            int row = operator.x;
            int col = operator.y;

            int cellNo = row * n + col;

            //  if already processed
            if (parents[cellNo] != -1) {
                numOfIslands.add(count);
                continue;
            }

            parents[cellNo] = cellNo;
            rank[cellNo] = 1;

            //  increase island count
            count++;

            //  check l u r d neighbours - is belong to same parent or not
            for (int j = 0; j < 4; j++) {
                int rowDash = row + dirX[j];
                int colDash = col + dirY[j];

                int cellNoDash = rowDash * n + colDash;

                if (rowDash < 0 || rowDash >= m || colDash < 0 || colDash >= n || parents[cellNoDash] == -1)    //  parents[cellNoDash] == -1 -> it's not yet marked as island, continue loop
                    continue;

                int setOfCell = findSet(cellNo, parents);
                int setOfCellDash = findSet(cellNoDash, parents);

                //  merge
                if (setOfCell != setOfCellDash) {
                    if (rank[setOfCell] < rank[setOfCellDash]) {
                        parents[setOfCell] = setOfCellDash;
                    } else if (rank[setOfCell] > rank[setOfCellDash]) {
                        parents[setOfCellDash] = setOfCell;
                    } else {
                        parents[setOfCell] = setOfCellDash;
                        rank[setOfCellDash]++;
                    }
                    count--;
                }
            }
            numOfIslands.add(count);
        }
        return numOfIslands;
    }

    //  returns parent of the set
    private static int findSet(int cellNo, int[] parents) {
        if (cellNo == parents[cellNo])
            return cellNo;
        return parents[cellNo] = findSet(parents[cellNo], parents);
    }

    public static void main(String[] args) {
//        Point[] points = new Point[]{
//                new Point(0, 3),
//                new Point(1, 2),
//                new Point(0, 2),
//                new Point(1, 4),
//                new Point(2, 3),
//                new Point(1, 3)
//        };
//        System.out.println("yup: no of islands: " + numIslands2(3, 5, points));

//        Point[] points = new Point[]{
//                new Point(1, 1),
//                new Point(0, 1),
//                new Point(3, 3),
//                new Point(3, 4)
//        };
//        System.out.println("yup: no of islands: " + numIslands2(4, 5, points));

        Point[] points = new Point[]{
                new Point(0, 0),
                new Point(0, 1),
                new Point(2, 2),
                new Point(2, 1)
        };
        System.out.println("yup: no of islands: " + numIslands2(3, 3, points));
    }
}
