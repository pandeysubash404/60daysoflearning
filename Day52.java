
/* Nth Fibonacci Number using heap */

public class Day52 {

    static int[][] multiply(int[][] a, int[][] b, int m) {
        int rowA = a.length;
        int colA = a[0].length;
        int colB = b[0].length;

        int[][] result = new int[rowA][colB];

        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < colB; j++) {
                for (int k = 0; k < colA; k++) {
                    result[i][j] = (result[i][j] + (int) ((long) a[i][k] * b[k][j] % m)) % m;
                }
            }
        }

        return result;
    }

    static int[][] power(int[][] matrix, int n, int m) {
        int size = matrix.length;
        int[][] result = new int[size][size];

        for (int i = 0; i < size; i++) {
            result[i][i] = 1;
        }

        while (n > 0) {
            if (n % 2 == 1) {
                result = multiply(result, matrix, m);
            }

            matrix = multiply(matrix, matrix, m);
            n /= 2;
        }

        return result;
    }

    static int nthFibonacci(int n) {
        if (n <= 0) {
            return 0;
        }

        int[][] baseMatrix = {{1, 1}, {1, 0}};
        int[][] resultMatrix = power(baseMatrix, n - 1, 1000000007);

        return resultMatrix[0][0];
    }

    public static void main(String[] args) {
        int n = 10; // nth Fibonacci numbers

        int nthFib = nthFibonacci(n);
        System.out.println("The " + n + "th Fibonacci number modulo 1000000007 is: " + nthFib);
    }
}
