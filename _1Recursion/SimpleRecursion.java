package _1Recursion;

public class SimpleRecursion {

    private static int recursiveMethod(int value) {
        if (value <= 0)
            return value;
        return recursiveMethod(value - 1);
    }

    private static int fib(int n) {
        if (n == 0 || n == 1)
            return 1;
        return fib(n - 1) + fib(n - 2);
    }

    private static int n1 = 0, n2 = 1, n3;

    private static void fibByPrinting(int n) {
        if (n > 0) {
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
            System.out.print(n3 + " ");
            fibByPrinting(n - 1);
        }
    }

    private static int sum(int n) {
        if (n <= 0)
            return 0;
        int s = n + sum(n - 1);
        return s;
    }

    public static void main(String[] args) {
        System.out.println("yup: final value: " + recursiveMethod(5));
        fib(5);
        fibByPrinting(5);
        System.out.println();
        System.out.println("yup: sum of 5: " + sum(5));
    }
}
