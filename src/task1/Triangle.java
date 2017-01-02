package task1;

public class Triangle {
    public static void main(String[] args) {
        int n = 4;
        for (int i = 0; i < n + 1; i++) {
            System.out.println(formula(n, i));
        }
    }

    private static long formula(int n, int m) {
        return factorial(n) / (factorial(m) * factorial(n - m));
    }

    private static long factorial(long n) {
        long fact = n;
        while (n > 1) {
            n--;
            fact *= n;
        }
        return (fact == 0) ? 1 : fact;
    }

}
