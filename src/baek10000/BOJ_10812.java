package baek10000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 10812 : Change basket order
// use arraycopy
public class BOJ_10812 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        solution(n, m);
        System.out.print(sb);
    }

    private static void solution(int n, int m) throws IOException {
        int[] arr = new int[n];
        for(int i = 0; i < n; ++i) {
            arr[i] = i+1;
        }

        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;
            int k = Integer.parseInt(st.nextToken()) - 1;

            int[] arr1 = new int[k-i];
            System.arraycopy(arr, i, arr1, 0, k-i);
            int[] arr2 = new int[j-k+1];
            System.arraycopy(arr, k, arr2, 0, j-k+1);

            System.arraycopy(arr2, 0, arr, i, j-k+1);
            System.arraycopy(arr1, 0, arr,i+j-k+1,k-i);
        }

        sb.append(arr[0]);
        for(int i = 1; i < n; ++i) {
            sb.append(" ").append(arr[i]);
        }
    }
}