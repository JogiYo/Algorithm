package baek2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2740_DC {
    static int N;
    static int M;
    static int K;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input_1 = br.readLine().split(" ");
        N = Integer.parseInt(input_1[0]);
        M = Integer.parseInt(input_1[1]);

        int[][] A = new int[N][M];

        for(int i = 0; i < N; ++i) {
            String[] str = br.readLine().split(" ");
            for(int j = 0; j < M; ++j) {
                A[i][j] = Integer.parseInt(str[j]);
            }
        }

        String[] input_2 = br.readLine().split(" ");
        K = Integer.parseInt(input_2[1]);

        int[][] B = new int[M][K];
        int[][] C = new int[N][K];

        for(int i = 0; i < M; ++i) {
            String[] str = br.readLine().split(" ");
            for(int j = 0; j < K; ++j) {
                B[i][j] = Integer.parseInt(str[j]);
            }
        }

        for(int k = 0; k < M; ++k) {
            for(int i = 0; i < N; ++i) {
                int r = A[i][k];
                for(int j = 0; j < K; ++j) {
                    C[i][j] += r * B[k][j];
                }
            }
        }

        for(int i = 0; i < N; ++i) {
            for(int j = 0; j < K; ++j) {
                sb.append(C[i][j] + " ");
            }
            if(i != (N-1))sb.append("\n");
        }
        System.out.print(sb);
    }
}
