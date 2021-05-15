package ds_algo._0dynamic_programming._1_01KnapSack;

//  https://www.youtube.com/watch?v=UmMh7xp07kY&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=8&ab_channel=AdityaVerma
public class _4EqualSumPartitionProb {

    private int[] arr = new int[]{2, 3, 7, 8, 10};  //  {2, 3, 10} & {7, 8} => true, both has sum = 15
//    private int[] arr = new int[]{1, 5, 11, 5, 1};  // total sum is 23 it is odd, hence we cannot have equalSumPartition()

    private boolean isSubsetAvailable(int sum) {
        boolean[][] t = new boolean[arr.length + 1][sum + 1];
        for (int i = 0; i < arr.length + 1; i++) {  //  array in top-down side |
            for (int j = 0; j < sum + 1; j++) { //  sum or weight in  left-right side ->
                //  initialization
                if (i == 0 && j == 0)
                    t[i][j] = true;
                else if (i == 0)
                    t[i][j] = false;    //  if nothing is
                else if (j == 0)
                    t[i][j] = true;
                    //  choice diagram
                    //  item is chosen or not
                else if (arr[i - 1] <= j)
                    t[i][j] = t[i - 1][j - arr[i - 1]]    //  when the item is chosen
                            ||
                            t[i - 1][j];   //  when the item not chosen
                    //  I'm not going to choose this item - since it's bigger than the sum
                else if (arr[i - 1] > j)
                    t[i][j] = t[i - 1][j];
            }
        }

        for (int i = 0; i < arr.length + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                System.out.print(" " + t[i][j] + " ");
            }
            System.out.println();
        }

        //  we'll get solution at last index
        return t[arr.length][sum];
    }

    private boolean isEqualSumPartitionAvailable() {
        //  the shortcut way
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i];

        //  if total sum is even, we have equal subsets, but again we need to check is it matches sum or not
        if (sum % 2 == 0)
            return isSubsetAvailable(sum / 2);
            //  if total sum is odd, we cannot have equal subsets with same sum
        else
            return false;
    }

    public static void main(String[] args) {
        _4EqualSumPartitionProb prob = new _4EqualSumPartitionProb();
        System.out.println("yup: isEqualSumPartitionAvailable: " + prob.isEqualSumPartitionAvailable());
    }
}
