package baek10000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 10986 : remainder of interval
public class BOJ_10986 {
    static BufferedReader br;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        /*
         * {S(j) - S(i-1)} % m = 0
         * => S(j) % m = S(i-1) % m
         * Just add 2 out of the sum of the intervals with the same remainder.
         */
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long sum = 0;
        long[] count = new long[m];
        long result = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < n+1; ++i) {
            sum += Integer.parseInt(st.nextToken());
            sum %= m;
            count[(int)sum]++;
        }

        result += count[0]; // A point where the remainder of the interval sum is 0 can be counted by itself.
        // combination of two
        for(int i = 0; i < m; ++i) {
            result += (count[i]*(count[i] - 1)) / 2;
        }

        sb.append(result);
        System.out.print(sb);
    }
}
