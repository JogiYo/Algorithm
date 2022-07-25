package baek1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://onejunu.tistory.com/112
public class BOJ_1707 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    static int K, V, E;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        K = Integer.parseInt(br.readLine());

        while(K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
        }
        System.out.print(sb);
    }

    private static void solution(int n, int m) throws IOException {

    }
}
