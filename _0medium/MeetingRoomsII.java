package _0medium;

import java.util.Arrays;

//  https://www.youtube.com/watch?v=FdzJmTCVyJU
/*
 * Given an array of meeting time intervals consisting of start & end times [s1, e1] ... [si, ei]
 *   (s < e)
 * find the min number of conference rooms required.
 *
 * eg: intervals [(0, 30), (5, 10), (15, 20)]
 * op : 2
 * room1 for (0, 30) meeting
 * room2 for (5, 10) & (15, 20) meetings
 *
 * time complexity: O(n log n)
 * space complexity: O (n)
 * */
public class MeetingRoomsII {

    public static int noOfMeetingRooms(int[][] intervals) {
        if (intervals == null)
            return 0;
        int[] startTimeArray = new int[intervals.length];
        int[] endTimeArray = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals[i].length; j++) {
                if (j == 0)
                    startTimeArray[i] = intervals[i][j];
                else
                    endTimeArray[i] = intervals[i][j];
//                System.out.print(intervals[i][j] + " ");
            }
//            System.out.println();
        }

//        System.out.println(Arrays.toString(startTimeArray));    //  [0, 5, 15]
//        System.out.println(Arrays.toString(endTimeArray));  //  [30, 10, 20]

        Arrays.sort(startTimeArray);
        Arrays.sort(endTimeArray);

        int count = 0, startIntervalIndex = 0, endIntervalIndex = 0, res = 0;
        while (startIntervalIndex < intervals.length) {
            //  if start time is less than end time of another meeting; increment count, and move startIndex
            if (startTimeArray[startIntervalIndex] < endTimeArray[endIntervalIndex]) {
                count += 1;
                startIntervalIndex++;
            }
            //  if start time is more than or equal to end time of another meeting; decrement count, and move endIndex
            else {
                count -= 1;
                endIntervalIndex++;
            }
            res = Math.max(res, count);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("yup: no of meeting rooms: " + noOfMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
    }
}
