package baek25000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// BOJ 25305 : Cut line
public class BOJ_25305 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        solution(n,k);
        System.out.print(sb);
    }

    private static void solution(int n, int k) throws IOException {
        Integer[] arr = new Integer[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Comparator.reverseOrder());
        sb.append(arr[k-1]);
    }
}