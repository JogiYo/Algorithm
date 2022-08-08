package baek10000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 10942 : palindrome?
// use Dynamic Programming
public class BOJ_10942 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    static boolean[][] dp;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n+1];
        dp = new boolean[n+1][n+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; ++i) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        solution(num, n);

        int m = Integer.parseInt(br.readLine());
        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(dp[start][end] ? "1" : "0").append("\n");
        }

        System.out.print(sb);
    }

    private static void solution(int[] num, int n) {
        /*
         * A case of length 1 is always a palindrome.
         * A case of length 2 is a palindrome if both numbers are equal.
         */
        for(int i = 1; i <= n-1; ++i) {
            dp[i][i] = true;
            if(num[i] == num[i+1]) dp[i][i+1] = true;
        }

        dp[n][n] = true;

        /*
         * If the length is 3 or more,
         * the index from (start point + 1) to (end - 1) is a palindrome,
         * and if the value of the start point = the end value,
         * it is a palindrome.
         */
        for(int i = 2; i < n; ++i) {
            for(int j = 1; j <= n-i; ++j) {
                if(num[j] == num[j+i] && dp[j+1][j+i-1]) dp[j][j+i] = true;
            }
        }
    }
}