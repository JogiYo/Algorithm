package baek24000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ 24266 : Algorithm Lesson - Running Time of Algorithms 5
// Pay attention to the range of numbers
public class BOJ_24266 {
    static BufferedReader br;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        sb.append(1l*n*n*n).append("\n3");
        System.out.print(sb);
    }
}