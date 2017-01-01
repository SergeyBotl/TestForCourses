package task1;

public class Main {
    public static void main(String[] args) {
        int row = 5;
        int massive[] = {1, 0};
        int[] triangle = {0, 0};

        for (int i = 0; i < row; i++) {
            triangle = new int[massive.length + 1];
            triangle[triangle.length - 1] = 0;
            for (int k = 0; k < massive.length; k++) {
                triangle[k] = massive[k] + massive[massive.length - 1 - k];
            }
            massive = triangle;
        }
        print(triangle);
    }

    private static void print(int[] ints) {
        for (int i : ints) {
            if (i != 0) {
                System.out.print(i + " ");
            }
        }

    }

}
