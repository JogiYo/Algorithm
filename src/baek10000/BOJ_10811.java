package baek10000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 10811 : Flip the basket
public class BOJ_10811 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        solution(n, m);
        System.out.print(sb);
    }

    private static void solution(int n, int m) throws IOException {
        int[] balls = new int[n];
        int i, j;

        for(int x = 0; x < n; ++x) {
            balls[x] = x + 1;
        }

        for(int a = 0; a < m; ++a) {
            st = new StringTokenizer(br.readLine());
            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());

            if(i == j) continue;

            int s = i - 1;
            int e = s + j - 1;
            for(int x = s; x <= e/2; ++x) {
                int temp = balls[x];
                balls[x] = balls[e - x];
                balls[e - x] = temp;
            }
        }

        sb.append(balls[0]);
        for(int x = 1; x < n; ++x) {
            sb.append(" ").append(balls[x]);
        }
    }
}