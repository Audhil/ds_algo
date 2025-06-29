package _4Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

//  https://youtu.be/XC4EotTewro?list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9
public class _7KClosestPointsToOrigin {

    /*
     * distance b/w 2 points,
     * sqrt((x1 - x2)^2 + (y1 - y2)^2)   -> eq1
     *
     * since we need to calculate distance from origin (0,0)
     * sqrt(x^2 + y^2)
     *
     * for ease, we'll assume
     * (sqrt(x^2 + y^2))^2 = x^2 + y^2 - this will be our key
     * */

    private int[][] points = {{1, 3}, {-2, 2}, {5, 8}, {0, 1}};
    private int k = 2;  //  2 closest points

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    private static class PointWithDistance implements Comparator<PointWithDistance> {

        Point point;
        int distance;

        public PointWithDistance() {
        }

        public PointWithDistance(Point point, int distance) {
            this.point = point;
            this.distance = distance;
        }

        @Override
        public int compare(PointWithDistance o1, PointWithDistance o2) {
            if (o1.distance == o2.distance)
                return 0;
            else if (o1.distance < o2.distance)
                return 1;
            return -1;
        }

        @Override
        public String toString() {
            return "PointWithDistance{" +
                    "point=" + point +
                    ", distance=" + distance +
                    '}';
        }
    }

    private void solveClosestPoints() {
        PriorityQueue<PointWithDistance> maxHeap = new PriorityQueue<>(new PointWithDistance());
        for (int row = 0; row < points.length; row++) {
            maxHeap.add(new PointWithDistance(
                    new Point(points[row][0], points[row][1]),
                    points[row][0] * points[row][0] + points[row][1] * points[row][1]   //  distance = x^2 + y^2
            ));

            if (maxHeap.size() > k)
                maxHeap.poll();
        }
        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.poll());
        }
    }

    public static void main(String[] args) {
        _7KClosestPointsToOrigin prob = new _7KClosestPointsToOrigin();
        prob.solveClosestPoints();
    }
}
