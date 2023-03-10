package baek27000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 27866 : Characters and Strings
public class BOJ_27866 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        String s = br.readLine();
        int n = Integer.parseInt(br.readLine());

        sb.append(s.charAt(n-1));
        System.out.print(sb);
    }
}