package baek15000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ 15894 : Mathematics is a physical education subject.
// Paying attention to ranges of numbers, looking for rules
public class BOJ_15894 {
    static BufferedReader br;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        long n = Long.parseLong(br.readLine());
        sb.append(4*n);
        System.out.print(sb);
    }
}