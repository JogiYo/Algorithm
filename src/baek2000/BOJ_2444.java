package baek2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ 2444 :Star Print - 7
public class BOJ_2444 {
    static BufferedReader br;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        solution(n);
        System.out.print(sb);
    }

    private static void solution(int n) {
        for(int i = 1; i <= 2*n-1; ++i) {
            String blank = "";
            String star = "";
            if(i <= n) {
                for(int j = 1; j <= n-i; ++j) {
                    blank += " ";
                }
                for(int j = n-i+1; j < n; ++j) {
                    star += "*";
                }
            }
            else {
                for(int j = 1; j <= n-(2*n-i); ++j) {
                    blank += " ";
                }
                for(int j = n-(2*n-i)+1; j < n; ++j) {
                    star += "*";
                }
            }
            sb.append(blank).append(star).append("*").append(star);
            if(i != 2*n-1) sb.append("\n");
        }
    }
}