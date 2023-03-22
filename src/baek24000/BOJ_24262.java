package baek24000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ 24262 : Algorithm Lesson - Running Time of Algorithm 1
public class BOJ_24262 {
    static BufferedReader br;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        sb.append("1\n0");
        System.out.print(sb);
    }
}