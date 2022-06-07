package baek16000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 16139 : human-computer interaction
// cumulative sum
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
        int q = Integer.parseInt(br.readLine());
        int[][] sum = new int[s.length()][26];

        sum[0][s.charAt(0) - 'a']++;

        // Find the cumulative sum of the alphabet
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

            // Find the interval sum
            if(l == 0) {
                sb.append(sum[r][ch - 'a']).append("\n");
            }
            else {
                sb.append(sum[r][ch - 'a'] - sum[l - 1][ch - 'a']).append("\n");
            }
        }
    }
}