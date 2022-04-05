package baek11000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_11444 {
    final static long MOD = 1000000007;
    static long[][] origin = {{1, 1}, {1, 0}};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long N = Long.parseLong(br.readLine());
        long[][] A = {{1, 1}, {1, 0}};

        long[][] result = solution(A, N - 1);
        sb.append(result[0][0] + "");
        System.out.print(sb);
    }

    private static long[][] solution(long[][] A, long exponent) {
        // Returns as it is when the exponent is 1
        if(exponent == 1) {
            return A;
        }

        long[][] half_mat = solution(A, exponent/2);

        // Square the obtained matrix.
        half_mat = matrixMultiply(half_mat, half_mat);

        // If the exponent is odd
        if(exponent % 2 == 1) {
            half_mat = matrixMultiply(half_mat, origin);
        }

        return half_mat;
    }

    private static long[][] matrixMultiply(long[][] m1, long[][] m2) {
        long[][] mat = new long[2][2];

        for(int i = 0; i < 2; ++i) {
            for(int j = 0; j < 2; ++j) {
                for(int k = 0; k < 2; ++k) {
                    mat[i][j] += m1[i][k] * m2[k][j];
                    mat[i][j] %= MOD;
                }
            }
        }

        return mat;
    }
}
