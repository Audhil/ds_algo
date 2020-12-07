package _2BinarySearch;

//  https://youtu.be/2JSQIhPcHQg?list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2
public class _19AllocateMinNoOfPages {

    //  books to be distributed to students
    private int[] bookWithPages = {10, 20, 30, 40};
    private int k = 2;  //  no of students

    private int solve() {
        int startIndex = -1, endIndex = 0, res = -1;
        int noOfBooks = bookWithPages.length;
        //  each student should get at least 1 book
        if (k > noOfBooks)
            return res;
        for (int i = 0; i < bookWithPages.length; i++) {
            //  startIndex should be book with max pages - since we should give 1 book to each student
            if (bookWithPages[i] > startIndex)
                startIndex = bookWithPages[i];
            //  endIndex is some of pages of total books
            endIndex += bookWithPages[i];
        }

        //  doing binary search
        while (startIndex <= endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;
            //  is valid pages selected, search backwards to get optimized value
            if (isValid(mid, bookWithPages)) {
                res = mid;
                endIndex = mid - 1;
            }
            //  do searching for other values
            else
                startIndex = mid + 1;
        }
        return res;
    }

    private boolean isValid(int maxPagesToBeDistributed, int[] bookWithPages) {
        int student = 1;    //  starting from student count 1
        int sum = 0;
        for (int bookPages : bookWithPages) {
            sum += bookPages;
            if (sum > maxPagesToBeDistributed) {
                student++;
                sum = bookPages;
            }
            if (student > k)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        _19AllocateMinNoOfPages prob = new _19AllocateMinNoOfPages();
        System.out.println("yup: minOfMaxPages allocated: " + prob.solve());
    }

    /*
    * related probs to practice
    *
    * Related Problems For Practice :
        Book Allocation Problem (GFG)
        Aggressive cow (spoj)
        Prata and roti (spoj)
        EKO (spoj)
        Google kickstart A Q-3 2020
        Painter Partition Problem
        *
        * leetcode probs
        1482 Minimum Number of Days to Make m Bouquets
        1283 Find the Smallest Divisor Given a Threshold
        1231 Divide Chocolate
        1011 Capacity To Ship Packages In N Days
        875 Koko Eating Bananas
        Minimize
        774 Max Distance to Gas Station
        410 Split Array Largest Sum


    * */
}
