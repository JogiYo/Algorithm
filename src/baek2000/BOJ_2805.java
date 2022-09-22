package baek2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 2805 : Cutting trees
// use Binary Search, upper bound
public class BOJ_2805 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st= new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        solution(n, m);
        System.out.print(sb);
    }

    private static void solution(int n, int m) throws IOException {
        int[] arr = new int[n];
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        int min = 0;

        // binary search (upper bound)
        while(min < max) {
            /*
             * Cut length of tree = Height of tree - Cut position (mid)
             * Sum the cut lengths of the tree.
             */
            int mid = (min + max) / 2;
            long sum = 0;

            for(int treeHeight : arr) {
                if(treeHeight - mid > 0) {
                    sum += (treeHeight - mid);
                }
            }

            /*
             * If the sum of the cut parts of the tree is less than m,
             * it means that the cutting position is high.
             * Therefore, the height must be decreased.
             * That is, the upper limit(max) should be lowered.
             */
            if(sum < m) max = mid;

            /*
             * If the sum of the cut parts of the tree is greater than m,
             * it means that the cutting position is low.
             * Therefore, the height must be increased.
             * That is, the lower limit(mid) should be raised.
             * */
            else min = mid + 1;
        }

        sb.append(min - 1);
    }
}