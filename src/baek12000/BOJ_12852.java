package baek12000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// BOJ 12852 : Make it 1 (2)
// use Dynamic Programming
public class BOJ_12852 {
    static BufferedReader br;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        solution(n);
        System.out.print(sb);
    }

    private static void solution(int n) {
        int[] dp = new int[n+1];
        int[] path = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[1] = 0;
        for(int i = 2; i <= n; ++i) {
            if(i%3 == 0) {
                if(dp[i/3] + 1 < dp[i]) {
                    dp[i] = dp[i/3] + 1;
                    path[i] = i / 3;
                }
            }
            if(i%2 == 0) {
                if(dp[i/2] + 1 < dp[i]) {
                    dp[i] = dp[i/2] + 1;
                    path[i] = i / 2;
                }
            }

            if(dp[i - 1] + 1 < dp[i]) {
                dp[i] = dp[i-1] + 1;
                path[i] = i - 1;
            }
        }

        sb.append(dp[n]).append("\n");

        int now = n;
        while(now > 0) {
            sb.append(now).append(" ");
            now = path[now];
        }
    }
}