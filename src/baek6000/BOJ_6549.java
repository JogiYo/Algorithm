package baek6000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6549 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    static int[] histogram;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        while(true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            if(n == 0) break;

            histogram = new int[n];

            for(int i = 0; i < n; ++i) {
                histogram[i] = Integer.parseInt(st.nextToken());
            }

            // solution

            histogram = null;
        }
        System.out.print(sb);
    }
}
