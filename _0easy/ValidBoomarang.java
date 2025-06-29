package _0easy;

//  https://www.youtube.com/watch?v=Jx-5bKbAYIc
/*
 * A boomerang is a set of 3 points that are all distinct and not in single line.
 * Given a list of 3 points in the plane, return whether these points are boomerang
 *
 * eg1:
 * i/p : [[1,1][2,3][3,2]] o/p: true
 *
 * eg2:
 * i/p : [[1,1][2,2][3,3]] o/p: false
 *
 * constraints:
 * 1. points.length = 3
 * 2. points[i].length = 2
 * 3. 0 <= points[i][j] <= 100
 * */
public class ValidBoomarang {

    public static boolean isBoomerang(int[][] points) {
        int x1 = points[0][0], x2 = points[1][0], x3 = points[2][0];
        int y1 = points[0][1], y2 = points[1][1], y3 = points[2][1];
        double distAB = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        double distBC = Math.sqrt((x3 - x2) * (x3 - x2) + (y3 - y2) * (y3 - y2));
        double distCA = Math.sqrt((x1 - x3) * (x1 - x3) + (y1 - y3) * (y1 - y3));
        //  {a + b = c} or {b + c = a} or {c + a = b} - all 3 points lie in straight line
        return distAB + distBC != distCA && distBC + distCA != distAB && distCA + distAB != distBC;
    }

    public static void main(String[] args) {
        System.out.println("yup isBoomerang : " + isBoomerang(new int[][]{{1, 1}, {2, 3}, {3, 2}}));
        System.out.println("yup isBoomerang : " + isBoomerang(new int[][]{{1, 1}, {2, 2}, {3, 3}}));
    }
}
