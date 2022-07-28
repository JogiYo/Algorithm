package baek10000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10942 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    static boolean[][] dp;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] num = new int[n+1];
        dp = new boolean[n+1][n+1];

        for(int i = 1; i <= n; ++i) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        solution(num, n);

        int m = Integer.parseInt(st.nextToken());

        System.out.print(sb);
    }

    private static void solution(int[] num, int n) {
        for(int i = 1; i <= n-1; ++i) {
            dp[i][i] = true;
            if(num[i] == num[i+1]) dp[i][i+1] = true;
        }

        dp[n][n] = true;
    }
}
