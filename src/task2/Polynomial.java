package task2;

public class Polynomial {
    static int a = 3, b = 5, n = 4;
    static int size = n+1;

    public static void main(String[] args) {
        for ( int i = 0; i < size; i++) {
            final int ii=i;
             System.out.println( poly(n, i) + mult(i) + a(i) + power(size - i) + mult(i) + b(i) + power(i + 1) + add(i));
          }

        System.out.printf("=%.0f", +Math.pow((a + b), n));
    }

    static String mult(int index) {
        return (poly(n, index).equals("")) ? "" : "*";
    }

    static String add(int index) {
        return (size - 1 > index) ? "+" : "";
    }

    static String a(int index) {
        return (size - 1 > index) ? "a" : "";
    }

    static String b(int index) {
        return (index > 0) ? "b" : "";
    }

    static String power(int index) {
        return (index > 2) ? "^" + (index - 1) : "";
    }

    private static String poly(int n, int m) {
        long i = factorial(n) / (factorial(m) * factorial(n - m));
        return (i == 1) ? "" : i + "";
    }


   private static long factorial(long n) {
       if (n == 0)
           return 1;
       return n * factorial(n - 1);
   }
}
