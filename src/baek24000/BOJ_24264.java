package baek24000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ 24264 : Algorithm Lesson - Running Time of Algorithms 3
// Pay attention to the range of numbers
public class BOJ_24264 {
    static BufferedReader br;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        sb.append((long)n*n).append("\n2");
        System.out.print(sb);
    }
}