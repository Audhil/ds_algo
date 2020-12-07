package _6SlidingWindowAlgo;

import java.util.ArrayList;
import java.util.List;

//  https://youtu.be/uUXXEgK2Jh8?list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj
public class _2FindNegNumInEveryWindowOfSizeK {

//    private int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
//    private int size = 8;
//    private int k = 3;  //  window size

    private int[] arr = {-8, 2, 3, -6, 10};
    private int size = 5;
    private int k = 2;  //  window size


    private List<Integer> negNumsInWindowOfSizeK() {
        List<Integer> tempList = new ArrayList<>();
        List<Integer> negNumsList = new ArrayList<>();

        int i = 0, j = 0;
        while (j < size) {
            if (j - i + 1 < k) {
                if (arr[j] < 0)
                    tempList.add(arr[j]);
                j++;
            }
            //  on reaching window bound
            else if (j - i + 1 == k) {
                if (arr[j] < 0)
                    tempList.add(arr[j]);

                //  if there's no -ve no in window
                if (tempList.size() == 0)
                    negNumsList.add(0);
                    //  if there's -ve no in window
                else {
                    negNumsList.add(tempList.get(0));   //  only the first num needed
                    //  on moving window, check tempList too
                    if (arr[i] == tempList.get(0))
                        tempList.remove(0);
                }
                i++;
                j++;
            }
        }
        return negNumsList;
    }

    public static void main(String[] args) {
        _2FindNegNumInEveryWindowOfSizeK prob = new _2FindNegNumInEveryWindowOfSizeK();
        System.out.println("yup: negNums : " + prob.negNumsInWindowOfSizeK());
    }
}
