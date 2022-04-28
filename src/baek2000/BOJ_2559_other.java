package baek2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ 2559 : Sequence
// use two pointers
public class BOJ_2559_other {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[] arr = new int[n];

        int max = 0;

        String[] input_arr = br.readLine().split(" ");
        for(int i = 0; i < n; ++i) {
            arr[i] = Integer.parseInt(input_arr[i]);
        }

        // Priority addition of temperature intervals from 0 to K.
        // put it to max first
        for(int i = 0; i < k; ++i) {
            max += arr[i];
        }

        // Sum of section temperatures. Do the following calculations with temp
        int temp = max;
        // 1st to K temperature interval: 0th to K temperature interval - 0th + Kth
        for(int i = k; i < n; ++i) {
            temp = temp - arr[i - k] + arr[i];
            max = Math.max(max, temp);
        }

        sb.append(max + "");
        System.out.print(sb);
    }
}
