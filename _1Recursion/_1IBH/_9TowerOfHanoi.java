package ds_algo._1Recursion._1IBH;

//  https://youtu.be/l45md3RYX7c?list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY
public class _9TowerOfHanoi {

    private static int solve(int sTower, int dTower, int hTower, int n) {
        int count = 1;
        //  bc
        if (n == 1) {
            System.out.println("move plate: " + n + " from: src: " + sTower + " to dest: " + dTower + " noOfSteps: " + count);
            return count;
        }

        //  hypothesis
        count += solve(sTower, hTower, dTower, n - 1);  //  move n-1 discs from s to h

        //  induction
        System.out.println("move plate: " + n + " from: src: " + sTower + " to dest: " + dTower + " noOfSteps: " + count);   //  moving last(bigger) plate to dest tower from src tower
        count += solve(hTower, dTower, sTower, n - 1);  //  move n-1 discs from h to d
        return count;
    }

    public static void main(String[] args) {
        int sTower = 1, hTower = 2, dTower = 3;
        int noOfPlates = 3;
        System.out.println("yup: noOfSteps involved: " + solve(sTower, dTower, hTower, noOfPlates));
    }
}
