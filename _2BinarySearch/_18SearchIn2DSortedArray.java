package _2BinarySearch;

//  https://youtu.be/VS0BcOiKaGI?list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2
public class _18SearchIn2DSortedArray {

    //  worst case complexity: O (n+m)

    private static int[][] matrix = {{10, 20, 30, 40}, {15, 25, 35, 45}, {27, 29, 37, 45}, {32, 33, 39, 50}};

    private static class HelperClass {
        int i, j;

        public HelperClass(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "HelperClass{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }

    private static HelperClass findKeyPos(int key) {
        //  matrix is of m x n
        int n = matrix.length;
        int m = matrix[0].length;
        int i = 0, j = m - 1;    //  pointing to last item in first row
        //  traversing
        while (i >= 0 && i < n && j >= 0 && j < m) {
            if (matrix[i][j] == key)
                return new HelperClass(i, j);
            else if (matrix[i][j] > key)
                j--;
            else if (matrix[i][j] < key)
                i++;
        }
        return new HelperClass(-1, -1);
    }

    public static void main(String[] args) {
        System.out.println("yup: 2D array is: ");
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(" " + matrix[row][col]);
            }
            System.out.println();
        }
        System.out.println("yup: index of key is : " + findKeyPos(29));
    }
}
