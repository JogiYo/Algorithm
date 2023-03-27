package baek24000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 24313 : Algorithm Lesson - Asymptotic Notation 1
public class BOJ_24313 {
    static BufferedReader br;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a1 = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());

        int result = solution(a1, a0, c, n0);
        sb.append(result);
        System.out.print(sb);
    }

    private static int solution(int a1, int a0, int c, int n0) {
        // We have to consider the case where a0 is negative!
        // a1 <= c !!
        if(a1*n0+a0 <= c*n0 && a1 <= c) return 1;
        return 0;
    }
}