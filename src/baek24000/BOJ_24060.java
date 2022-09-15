package baek24000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 24060 : merge sort 1
// Understand the mechanism of merge sort.
public class BOJ_24060 {
    static BufferedReader br;
    static StringBuilder sb;
    static int k;
    static int count;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st= new StringTokenizer(br.readLine());

        int len = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        int[] A = new int[len];
        
        for(int i = 0; i < len; ++i) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        solution(A);
        System.out.print(sb);
    }

    private static void solution(int[] a) {
        count = 0;
        merge_sort(a, 0, a.length-1);
        if(count < k) sb.append(-1);
    }

    private static void merge_sort(int[] a, int left, int right) {
        if(left < right) {
            int mid = (left + right) / 2;
            merge_sort(a, left, mid);
            merge_sort(a, mid + 1, right);
            merge(a, left, mid, right);
        }
    }

    private static void merge(int[] a, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        int[] temp = new int[right - left + 1];

        while(i <= mid && j <= right) {
            if(a[i] <= a[j]) {
                temp[t++] = a[i++];
            }
            else temp[t++] = a[j++];
        }

        while(i <= mid) temp[t++] = a[i++];
        while(j <= right) temp[t++] = a[j++];

        i = left;
        t = 0;

        while(i <= right) {
            count++;

            a[i] = temp[t];
            if(count == k) sb.append(a[i]);
            i++;
            t++;
        }
    }
}