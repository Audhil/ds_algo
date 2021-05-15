package _3Stack;

//  https://youtu.be/FbGG2qpNp4U?list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd
public class _8RainWaterTrapping {

    //  img @ https://photos.google.com/photo/AF1QipOkvnqj0tDrWWJHdlt0Rfz_YZuYpsstQIwzaoU-

    private int[] arr = {3, 0, 0, 2, 0, 4};  //  heights of buildings

    private int solve() {
        int[] mxL = new int[arr.length];
        int[] mxR = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (i == 0)
                mxL[i] = arr[i];
            else
                mxL[i] = Math.max(mxL[i - 1], arr[i]);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            if (i == arr.length - 1)
                mxR[i] = arr[i];
            else
                mxR[i] = Math.max(mxR[i + 1], arr[i]);
        }

        int[] waterArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            waterArr[i] = Math.min(mxL[i], mxR[i]) - arr[i];   //  top building - actual height of building

        int totWaterTrapped = 0;
        for (int value : waterArr) {
            totWaterTrapped += value;
        }
        return totWaterTrapped;
    }

    public static void main(String[] args) {
        _8RainWaterTrapping prob = new _8RainWaterTrapping();
        System.out.println("yup: tot water trapped: " + prob.solve());
    }
}
