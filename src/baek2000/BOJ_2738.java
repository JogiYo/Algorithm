package baek2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 2738 : Matrix addition
public class BOJ_2738 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] a = new int[n][m];
        int[][] b = new int[n][m];

        for(int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; ++j) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; ++j) {
                b[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(a, b);
        System.out.print(sb);
    }

    private static void solution(int[][] a, int[][] b) {
        for(int i = 0; i <  a.length; ++i) {
            for(int j = 0; j < a[0].length; ++j) {
                if(j == 0) sb.append(a[i][j] + b[i][j]);
                else sb.append(" ").append(a[i][j] + b[i][j]);
            }

            if(i != a.length - 1) sb.append("\n");
        }
    }
}