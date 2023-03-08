package baek25000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ 25314 : Coding is a physical education subject
public class BOJ_25314 {
    static BufferedReader br;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int quotient = n / 4;

        while(quotient-- > 0) {
            sb.append("long ");
        }
        sb.append("int");
        System.out.print(sb);
    }
}