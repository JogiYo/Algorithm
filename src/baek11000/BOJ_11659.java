package baek11000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ 11659 : Find the sum of intervals
// array[b] - array[a-1]
public class BOJ_11659 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[] sum = new int[n+1];

        String[] arr = br.readLine().split(" ");
        /* Find the cumulative sum
         * 5 4 3 2 1
         * 0 5 9 12 14 15
         */
        for(int i = 1; i <= n; ++i) {
            sum[i] = sum[i-1] + Integer.parseInt(arr[i-1]);
        }

        for(int i = 0; i < m; ++i) {
            String[] section = br.readLine().split(" ");
            int a = Integer.parseInt(section[0]);
            int b = Integer.parseInt(section[1]);
            sb.append((sum[b] - sum[a-1]) + "\n");
        }

        System.out.print(sb);
    }
}
