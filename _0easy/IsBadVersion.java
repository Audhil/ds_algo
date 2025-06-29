package _0easy;

//  https://leetcode.com/problems/first-bad-version/submissions/
public class IsBadVersion {

    public boolean isBadVersion(int version) {
        return version >= 2;    //  from version 2, it is defective/bad version
    }

    public int firstBadVersion(int n) {
        if (n == 0 || n < 0) return 0;
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid))
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }

    public static void main(String[] args) {
        IsBadVersion prob = new IsBadVersion();
        System.out.println("yup: " + prob.firstBadVersion(10)); //  o/p -> yup: 2
    }
}
