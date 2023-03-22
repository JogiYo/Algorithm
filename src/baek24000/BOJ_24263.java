package baek24000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ 24263 : Algorithm Lesson - Running Time of Algorithm 2
public class BOJ_24263 {
    static BufferedReader br;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        sb.append(n).append("\n1");
        System.out.print(sb);
    }
}