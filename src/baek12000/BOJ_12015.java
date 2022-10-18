package baek12000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 12015 : Longest Increasing Subsequence(LIS) 2
// use Binary Search
public class BOJ_12015 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        solution(n);
        System.out.print(sb);
    }

    private static void solution(int n) throws IOException {
        st = new StringTokenizer(br.readLine());
        int[] seq = new int[n];
        int[] LIS = new int[n];

        for(int i = 0; i < n; ++i) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        // It has the value of the first sequence as the initial value of LIS
        LIS[0] = seq[0];
        int LIS_length = 1;

        for(int i = 1; i < n; ++i) {
            int key = seq[i];

            // If key is greater than the last value of LIS, it is added.
            if(LIS[LIS_length-1] < key) {
                LIS_length++;
                LIS[LIS_length-1] = key;
            }
            else {
                // Binary search with Lower Bound.
                int left = 0;
                int right = LIS_length;

                while(left < right) {
                    int mid = (left + right) / 2;
                    if(LIS[mid] < key) {
                        left = mid + 1;
                    }
                    else right = mid;
                }
                /*
                 * left will be the position of the element to be replaced in LIS,
                 * The element is replaced with a key value at the corresponding position.
                 */
                LIS[left] = key;
            }
        }

        sb.append(LIS_length);
    }
}