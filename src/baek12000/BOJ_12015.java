package baek12000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12015 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        solution(n);
        System.out.print(sb);
    }

    private static void solution(int n) throws IOException {
        st = new StringTokenizer(br.readLine());
        int[] seq = new int[n];
        int[] LIS = new int[n];

        for(int i = 0; i < n; ++i) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
    }
}
