package baek25000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 25304 : receipt
public class BOJ_25304 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int X = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        solution(X,N);
        System.out.print(sb);
    }

    private static void solution(int x, int n) throws IOException {
        int sum = 0;
        while(n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sum += a * b;
        }
        sb.append(x == sum ? "Yes" : "No");
    }
}