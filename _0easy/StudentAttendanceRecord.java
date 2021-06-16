package _0easy;

//  https://leetcode.com/problems/student-attendance-record-i/
/*
* You are given a string s representing an attendance record for a student where each character signifies whether the student was absent, late, or present on that day. The record only contains the following three characters:

'A': Absent.
'L': Late.
'P': Present.
The student is eligible for an attendance award if they meet both of the following criteria:

The student was absent ('A') for strictly fewer than 2 days total.
The student was never late ('L') for 3 or more consecutive days.
Return true if the student is eligible for an attendance award, or false otherwise.



Example 1:

Input: s = "PPALLP"
Output: true
Explanation: The student has fewer than 2 absences and was never late 3 or more consecutive days.
Example 2:

Input: s = "PPALLL"
Output: false
Explanation: The student was late 3 consecutive days in the last 3 days, so is not eligible for the award.


Constraints:

1 <= s.length <= 1000
s[i] is either 'A', 'L', or 'P'.
* */
public class StudentAttendanceRecord {

    public static boolean checkRecord(String s) {
        if (s == null)
            return false;

        int lateCount = 0, absentCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'A') {
                lateCount = 0;
                absentCount++;
                if (absentCount >= 2)
                    return false;
            } else if (ch == 'L') {
                lateCount++;
                if (lateCount >= 3)
                    return false;
            }
            else
                lateCount = 0;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("yup: PPALLP: " + checkRecord("PPALLP"));
        System.out.println("yup: PPALLL: " + checkRecord("PPALLL"));
        System.out.println("yup: LALL: " + checkRecord("LALL"));
    }
}
