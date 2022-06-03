package baek16000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16139 {
    static BufferedReader br;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        String s = br.readLine();
        solution(s);

        System.out.print(sb);
    }

    private static void solution(String s) throws IOException {
//        int n = Integer.parseInt(input[0]);
//        int m = Integer.parseInt(input[1]);
//        int[] sum = new int[n+1];
//
//        String[] arr = br.readLine().split(" ");
        /* Find the cumulative sum
         * 5 4 3 2 1
         * 0 5 9 12 14 15
         */
//        for(int i = 1; i <= n; ++i) {
//            sum[i] = sum[i-1] + Integer.parseInt(arr[i-1]);
//        }
//
//        for(int i = 0; i < m; ++i) {
//            String[] section = br.readLine().split(" ");
//            int a = Integer.parseInt(section[0]);
//            int b = Integer.parseInt(section[1]);
//            sb.append((sum[b] - sum[a-1]) + "\n");
//        }

        int q = Integer.parseInt(br.readLine());
        int[][] sum = new int[s.length()][26];

        sum[0][s.charAt(0) - 'a']++;

        for(int i = 1; i < s.length(); ++i) {
            int temp = s.charAt(i) - 'a';

            for(int j = 0; j < 26; ++j) {
                sum[i][j] = sum[i-1][j];
            }
            sum[i][temp]++;
        }

        while(q-- >  0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char ch = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            if(l == 0) {
                sb.append(sum[r][ch - 'a']).append("\n");
            }
            else {
                sb.append(sum[r][ch - 'a'] - sum[l - 1][ch - 'a']).append("\n");
            }
        }
    }
}