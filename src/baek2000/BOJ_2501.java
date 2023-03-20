package baek2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 2501 : Find the kth divisor
public class BOJ_2501 {
    static BufferedReader br;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int result = solution(n, k);
        sb.append(result);
        System.out.print(sb);
    }

    private static int solution(int n, int k) {
        int count = 0;

        for(int i = 1; i <= n; ++i) {
            if(n % i == 0) {
                count++;
                if(count == k) return i;
            }
        }

        return 0;
    }
}