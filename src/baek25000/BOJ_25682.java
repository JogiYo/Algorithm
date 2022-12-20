package baek25000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_25682 {
    static BufferedReader br;
    static StringBuilder sb;

    static int n, m, k;
    static char[][] chess;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        chess = new char[n][m];
        String line;
        for(int i = 0; i < n; ++i) {
            line = br.readLine();
            for(int j = 0; j < m; ++j) chess[i][j] = line.charAt(j);
        }

        sb.append(Math.min(solution('B'), solution('W')));
        System.out.print(sb);
    }

    private static int solution(char color) {
        int count = Integer.MAX_VALUE;
        int sameColor;
        int[][] prefixSum = new int[n+1][m+1];

        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < m; ++j) {
                if((i+j)%2 == 0) {
                    sameColor = chess[i][j] != color ? 1 : 0;
                }
                else {
                    sameColor = chess[i][j] == color ? 1 : 0;
                }

                prefixSum[i+1][j+1] = prefixSum[i][j+1] + prefixSum[i+1][j] - prefixSum[i][j] + sameColor;
            }
        }


    }
}