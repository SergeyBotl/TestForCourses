package task2;

public class Polynomial2 {
    public static void main(String[] args) {
        calculate(3, 5, 4);
    }

    private static void calculate(int memA, int memB, int n) {
        for (int index = 0; index < n + 1; index++) {
            long polynResult = factorial(n) / (factorial(index) * factorial(n - index));
            String a = (n > index) ? "a" : "",
                    b = (index > 0) ? "b" : "",
                    powerB = (index > 1) ? "^" + (index) : "",
                    powerA = (n - 1 > index) ? "^" + (n - index) : "",
                    add = (n > index) ? "+" : "",
                    poly = (polynResult == 1) ? "" : polynResult + "",
                    mult = (polynResult == 1) ? "" : "*";

            System.out.print(poly + mult + a + powerA + mult + b + powerB + add);
        }
        System.out.printf("=%.0f", +Math.pow((memA + memB), n));
    }

    private static long factorial(long n) {
        if (n == 0)
            return 1;
        return n * factorial(n - 1);
    }
}
