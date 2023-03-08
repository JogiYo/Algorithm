package baek10000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 10810 : Put the ball
public class BOJ_10810 {
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
        int i, j, k;

        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            for(int x = i - 1; x < j; ++x) {
                balls[x] = k;
            }
        }

        sb.append(balls[0]);
        for(int x = 1; x < n; ++x) {
            sb.append(" ").append(balls[x]);
        }
    }
}