package baek11000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ 11660 : Find the sum of intervals 5
// 11660 Application
public class BOJ_11660 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[][] sum = new int[n+1][n+1];

        for(int i = 1; i <= n; ++i) {
            String[] arr = br.readLine().split(" ");
            for(int j = 1; j <= n; ++j) {
                sum[i][j] = sum[i][j-1] + Integer.parseInt(arr[j-1]);
            }
        }

        for(int i = 0; i < m; ++i) {
            String[] section = br.readLine().split(" ");
            int x1 = Integer.parseInt(section[0]);
            int y1 = Integer.parseInt(section[1]);
            int x2 = Integer.parseInt(section[2]);
            int y2 = Integer.parseInt(section[3]);
            int sum_num = 0;
            // array[b] - array[a-1]
            for(int j = x1; j <= x2; ++j) {
                sum_num += sum[j][y2] - sum[j][y1-1];
            }
            sb.append(sum_num + "\n");
        }

        System.out.print(sb);
    }
}
