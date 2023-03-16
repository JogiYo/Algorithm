package baek10000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ 10988 : Determination of Palindrome
public class BOJ_10988 {
    static BufferedReader br;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        String s = br.readLine();
        solution(s);
        System.out.print(sb);
    }

    private static void solution(String s) {
        int len = s.length();
        boolean flag = true;

        int mid = len / 2;
        for(int i = 0; i < mid; ++i) {
            if(s.charAt(i) != s.charAt(len-i-1)) {
                flag = false;
                break;
            }
        }

        if(!flag) sb.append(0);
        else sb.append(1);
    }
}