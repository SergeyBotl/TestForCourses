package tasr1;

public class Main {
    public static void main(String[] args) {

        int massive[] = {1, 0};
        int row = 10;
        int[] triangle = {0, 0};

        for (int i = 0; i < row; i++) {
            triangle = new int[massive.length + 1];
            triangle[triangle.length - 1] = 0;
            for (int k = 0; k < massive.length; k++) {
                int last = massive.length - 1;
                triangle[k] = massive[k] + massive[last - k];
            }

            massive = new int[triangle.length];
            massive = triangle;
        }
        print(triangle);
    }

    static void print(int[] ints) {
        for (int i : ints) {
            if (i != 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

}
