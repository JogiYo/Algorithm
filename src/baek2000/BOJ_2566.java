package baek2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 2566 : Maximum
public class BOJ_2566 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        solution();
        System.out.print(sb);
    }

    private static void solution() throws IOException {
        int max = 0;
        int max_row = 1;
        int max_col = 1;

        for(int i = 0; i < 9; ++i) {
            st = new StringTokenizer(br.readLine());
            int num;
            for(int j = 0; j < 9; ++j) {
                num = Integer.parseInt(st.nextToken());
                if(num > max) {
                    max = num;
                    max_row = i + 1;
                    max_col = j + 1;
                }
            }
        }

        sb.append(max).append("\n");
        sb.append(max_row).append(" ").append(max_col);
    }
}