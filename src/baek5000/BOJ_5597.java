package baek5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// BOJ 5597 : Those who did not submit assignments..?
public class BOJ_5597 {
    static BufferedReader br;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        solution();
        System.out.print(sb);
    }

    private static void solution() throws IOException {
        int[] arr = new int[31];

        int t = 28;
        while(t-- > 0) {
            int student = Integer.parseInt(br.readLine());
            arr[student] = 1;
        }

        for(int i = 1; i < 31; ++i) {
            if(arr[i] == 0) sb.append(i).append("\n");
        }
    }
}