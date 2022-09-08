package baek1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1654 {
    static BufferedReader br;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st= new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        solution(k, n);
        System.out.print(sb);
    }

    private static void solution(int k, int n) throws IOException {
        int[] arr = new int[k];

        long max = 0;

        for(int i = 0; i < k; ++i) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

    }
}
