package task2;

import java.util.Scanner;

public class Polynomial {
    private int degree;
    private int[] coefficients;

    public Polynomial(int nn) {
        degree = nn;
        coefficients = new int[degree + 1];
    }

    public int getCoefficient(int power) {
        if(power > degree){
            return 0;
        }
        return coefficients[power];
    }

    public void setCoefficient(int power, int value) {
        coefficients[power] = value;
    }

    public static Polynomial add(Polynomial p1, Polynomial p2) {
        int max = Math.max(p1.degree, p2.degree);
        Polynomial sum = new Polynomial(max);
        for (int i = 0; i < max + 1; i++) {
            sum.setCoefficient(i, p1.getCoefficient(i) + p2.getCoefficient(i));
        }
        return sum;
    }

    public static Polynomial mult(Polynomial p1, Polynomial p2) {
        int newSize = p1.degree + p2.degree;
        Polynomial mult = new Polynomial(newSize);
        for (int i = 0; i <= p1.degree; i++) {
            for (int j = 0; j <= p2.degree; j++) {
                mult.setCoefficient(i + j, p1.getCoefficient(i) * p2.getCoefficient(j));
            }
        }
        return mult;
    }


    public static Polynomial input() {
        Scanner inp = new Scanner(System.in);
        System.out.println("Введите степень многочлена:");
        int size = inp.nextInt();
        Polynomial polynomial = new Polynomial(size);

        System.out.println("Введите коэфиценты многочлена:");
        for (int i = 0; i <= size; i++) {
            System.out.println("Введите степень " + i);
            polynomial.setCoefficient(i, inp.nextInt());
        }
        return polynomial;
    }

    public void output() {
        boolean empty = true;
        StringBuilder sb = new StringBuilder();
        for (int i = degree; i > 0; i--) {
            int value = coefficients[i];
            if(value != 0){
                if(value > 0){
                    sb.append(value);
                } else {
                    sb.append("(").append(value).append(")");
                }
                empty = false;
                sb.append(" * ").append("x^").append(i).append(" + ");
            }
        }
        if(empty || coefficients[0] != 0){
            sb.append(coefficients[0]);
        } else {
            sb.delete(sb.length() - 2, sb.length());
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Polynomial p = input();
        Polynomial q = input();
        System.out.print("P(x) = ");
        p.output();
        System.out.println();
        System.out.print("Q(x) = ");
        q.output();
        System.out.println();
        System.out.print("P(x)+Q(x)=");
        add(p, q).output();
        System.out.println();
        System.out.print("P(x)*Q(x)=");
        mult(p, q).output();
    }
}
