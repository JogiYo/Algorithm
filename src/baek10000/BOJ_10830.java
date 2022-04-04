package baek10000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ 10830 : matrix square
// use divide and conquer
// Using problem 1629 (squaring a number)
public class BOJ_10830 {
    final static int MOD = 1000;
    static int N;
    static int[][] origin;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        long B = Long.parseLong(input[1]);

        origin = new int[N][N];

        for(int i = 0; i < N; ++i) {
            String[] num = br.readLine().split(" ");
            for(int j = 0; j < N; ++j) {
                // It exists even when 1000 is input.
                origin[i][j] = Integer.parseInt(num[j]) % 1000;
            }
        }

        int[][] result = solution(origin, B);

        for(int i = 0; i < N; ++i) {
            for(int j = 0; j < N; ++j) {
                sb.append(result[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static int[][] solution(int[][] matrix, long exponent) {
        // Returns as it is when the exponent is 1
        if(exponent == 1) {
            return matrix;
        }

        int[][] half_mat = solution(matrix, exponent/2);

        // Square the obtained matrix.
        half_mat = matrixMultiply(half_mat, half_mat);

        // If the exponent is odd
        if(exponent % 2 == 1) {
            half_mat = matrixMultiply(half_mat, origin);
        }

        return half_mat;
    }

    private static int[][] matrixMultiply(int[][] m1, int[][] m2) {
        int[][] mat = new int[N][N];

        for(int i = 0; i < N; ++i) {
            for(int j = 0; j < N; ++j) {
                for(int k = 0; k < N; ++k) {
                    mat[i][j] += m1[i][k] * m2[k][j];
                    mat[i][j] %= MOD;
                }
            }
        }

        return mat;
    }
}
