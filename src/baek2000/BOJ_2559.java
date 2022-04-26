package baek2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ 2559 : Sequence
// using for loop ver
public class BOJ_2559 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[] arr = new int[n];

        int max = Integer.MIN_VALUE;
        String[] input_arr = br.readLine().split(" ");
        for(int i = 0; i < n; ++i) {
            arr[i] = Integer.parseInt(input_arr[i]);
        }

        for(int i = 0; i <= n-k; ++i) {
            int sum = 0;
            for(int j = i; j < i+k; ++j) {
                sum += arr[j];
            }
            max = Math.max(max, sum);
        }

        sb.append(max + "");
        System.out.print(sb);
    }
}
