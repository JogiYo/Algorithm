package baek1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 1654 : Cut LAN cable
// use Binary search, upper bound
public class BOJ_1654 {
    static BufferedReader br;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st= new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        solution(k, n);
        System.out.print(sb);
    }

    private static void solution(int k, int n) throws IOException {
        int[] arr = new int[k];

        long max = 0;

        for(int i = 0; i < k; ++i) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        // Because it is handled with upper bound
        max++;

        long min = 0;
        long mid = 0;

        while(min < max) {
            mid = (max + min) / 2;

            long count = 0;

            // Calculate how many total pieces are made when cut to the obtained intermediate length.
            for (int j : arr) {
                count += (j / mid);
            }

            /*
             * upper bound format
             *
             * If the number when cut to mid length is smaller than the number of LAN wires to be made
             * Decrease the maximum length to reduce the length to be cut.
             *
             * Otherwise, the length you want to cut needs to be increased, so increase the minimum length.
             */
            if(count < n) {
                max = mid;
            }
            else {
                min = mid + 1;
            }
        }

        // 1 to the value (min) obtained by UpperBound becomes the maximum length.
        sb.append(min - 1);
    }
}