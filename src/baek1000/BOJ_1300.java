package baek1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1300 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        solution(n, k);
        System.out.print(sb);
    }

    private static void solution(int n, int k) {
    }
}
