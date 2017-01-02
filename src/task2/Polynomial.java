package task2;

public class Polynomial {
    static int a = 3, b = 5, n = 4;
    String abc[];
    static String[] row = new String[1 + n];
    static int size = row.length;

    public static void main(String[] args) {


        for (int i = 0; i < size; i++) {

            row[i] = poly(n, i) +mult(i)+ a(i)+mult(i)+p(size-i) + b(i);
        }

        for (int i = 0; i < size; i++) {
            System.out.println(row[i]);
        }

    }
static String mult(int index){
    return (poly(n, index).equals(""))?"":"*";
}
    static String a(int index) {
        return (row.length - 1 > index) ? "a" : "";
    }

    static String b(int index) {
        return (index > 0) ? "b" : "";
    }
    static String p(int index) {
        return (index > 2) ? "^"+(index-1) : "";
    }

/*
    static String[] result(String[] s) {
       // int size = s.length;

        for (int i = 0; i < size - 1; i++) {
            s[i] += "a"+p(size)[i];
        }

        for (int i = 1; i < size; i++) {
            s[i] += "b";
        }

        for (int i = 0; i < size; i++) {
            System.out.println(s[i]);
        }
        return s;
    }



    static boolean last(int i){
        return (i>size-2);
    }
*/


    private static String poly(int n, int m) {
        long i = factorial(n) / (factorial(m) * factorial(n - m));
        return (i == 1) ? "" : i + "";
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
