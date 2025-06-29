package _0medium;

import java.util.HashMap;
import java.util.Map;

//  https://leetcode.com/problems/number-of-boomerangs/
/*
* You are given n points in the plane that are all distinct, where points[i] = [xi, yi]. A boomerang is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

Return the number of boomerangs.



Example 1:

Input: points = [[0,0],[1,0],[2,0]]
Output: 2
Explanation: The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]].
Example 2:

Input: points = [[1,1],[2,2],[3,3]]
Output: 2
Example 3:

Input: points = [[1,1]]
Output: 0


Constraints:

n == points.length
1 <= n <= 500
points[i].length == 2
-104 <= xi, yi <= 104
All the points are unique.
* */
public class NumOfBoomerangs {

    public static int numberOfBoomerangs(int[][] points) {
        if (points == null)
            return 0;

        int res = 0;
        Map<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            map.clear();
            for (int j = 0; j < points.length; j++) {
                if (i == j)
                    continue;
                double distance = distance(points[i], points[j]);
                if (map.containsKey(distance)) {
                    map.put(distance, map.get(distance) + 1);
                } else {
                    map.put(distance, 1);
                }
            }
            for (Map.Entry<Double, Integer> entry : map.entrySet()) {
                int count = entry.getValue();
                res += (count * (count - 1));
            }
        }
        return res;
    }

    private static double distance(int[] p1, int[] p2) {
        return Math.sqrt(
                (p2[0] - p1[0]) * (p2[0] - p1[0]) +
                        (p2[1] - p1[1]) * (p2[1] - p1[1])
        );
    }

    public static void main(String[] args) {
        System.out.println("yup: " + numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {2, 0}}));
    }
}
