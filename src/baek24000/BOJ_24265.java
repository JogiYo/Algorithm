package baek24000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ 24265 : Algorithm Lesson - Running Time of Algorithms 4
// Pay attention to the range of numbers
public class BOJ_24265 {
    static BufferedReader br;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        sb.append(1l*n*(n-1)/2).append("\n2");
        System.out.print(sb);
    }
}