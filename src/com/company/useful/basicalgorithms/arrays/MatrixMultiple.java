package company.useful.basicalgorithms.arrays;

/**
 * Created by OPER on 19.04.2017.
 */
public class MatrixMultiple {
    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        };
        int[][] b = {
                {1, 2},
                {3, 4},
                {5, 6}
        };

        int[][] c = multiple(a, b);
        printMatrix(a);
        printMatrix(b);
        printMatrix(c);

    }

    private static void printMatrix(int[][] a) {
        for (int[] row : a) {
            for (int elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int[][] multiple(int[][] a, int[][] b) {
        int[][] c = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < b.length; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }
}
