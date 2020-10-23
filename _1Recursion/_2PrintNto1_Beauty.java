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

    int n1 = 0, n2 = 1, n3 = 0;

    private void printFib(int n) {
        if (n > 0) {
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
            System.out.println(n3);
            printFib(n - 1);
        }
    }

    private int fact(int n) {
        if (n == 0)
            return 1;
        else
            return n * fact(n - 1);
    }

    public static void main(String[] args) {
        _2PrintNto1_Beauty prob = new _2PrintNto1_Beauty();
//        System.out.println("yup print N to 1");
//        prob.print(8);
//        prob.printFib(8);
        System.out.println("yup:  factorial: " + prob.fact(5));
    }
}
