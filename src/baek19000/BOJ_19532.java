package baek19000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_19532 {
    static BufferedReader br;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        sb.append(solution(n));
        System.out.print(sb);
    }
}
