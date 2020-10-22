package ds_algo._1Recursion;

//    https://youtu.be/qDJJBZAIXIw?list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY
public class _2PrintNto1_Beauty {

    private void print(int n) {
        //  base condition
        if (n == 1) {
            System.out.println(n);
            return;
        }

        //  induction
        System.out.println(n);

        //  hypothesis
        print(n - 1);
    }

    public static void main(String[] args) {
        _2PrintNto1_Beauty prob = new _2PrintNto1_Beauty();
        System.out.println("yup print N to 1");
        prob.print(8);
    }
}
