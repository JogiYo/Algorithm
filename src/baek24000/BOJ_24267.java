package baek24000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ 24267 : Algorithm Lesson - Running Time of Algorithms 6
// Pay attention to the range of numbers
public class BOJ_24267 {
    static BufferedReader br;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        // The given sentence is equivalent to nC3.
        sb.append(1l*n*(n-1)*(n-2)/6).append("\n3");
        System.out.print(sb);
    }
}