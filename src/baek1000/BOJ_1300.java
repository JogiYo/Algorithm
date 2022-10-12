package baek1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ 1300 : Kth number
// binary search
public class BOJ_1300 {
    static BufferedReader br;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        solution(n, k);
        System.out.print(sb);
    }

    private static void solution(int n, int k) {
        long left = 1;
        long right = k;

        while(left < right) {
            long mid = (left + right) / 2; // Set any x(mid) to the median value
            long count = 0;

            /*
             * The number of elements less than or equal to x by dividing the i-th row for any x
             * Find the cumulative sum.
             * In this case, the number of elements in each row must be summed in a line that does not exceed N (the number of columns).
             */
            for(int i = 1; i <= n; ++i) {
                count += Math.min(mid / i, n);
            }

            // More count means that any number less than x(mid) is greater than B[K]
            if(k <= count) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }

        sb.append(left);
    }
}