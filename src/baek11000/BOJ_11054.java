package baek11000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
// BOJ 11054 : Longest bitonic partial sequence
// using dynamic programming
public class BOJ_11054 {
	static int N;
	static int[] r_dp;
	static int[] l_dp;
	static int[] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		arr = new int[input.length];
		
		for(int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(input[i]);
		}
		
		r_dp = new int[N]; // proceed to the right ->
		l_dp = new int[N]; // proceed to the left <-
		
		LIS(); // Longest Increasing Sequence
		LDS(); // Longest Decreasing Sequence
		
		int max = 0;
		// Arrays are simply concatenated, 
		// so each element is duplicated. 
		// Therefore, the real final result should be -1.
		for(int i = 0; i < N; ++i) {
			max = Math.max(max, r_dp[i] + l_dp[i] - 1);
		}
		
 		System.out.print(max);
	}

	private static void LIS() {
		for(int i = 0; i < N; ++i) {
			r_dp[i] = 1;
			
			for(int j = 0; j < i; j++) {
				if(arr[j] < arr[i] && r_dp[i] < r_dp[j] + 1) {
					r_dp[i] = r_dp[j] + 1;
				}
			}
		}
	}
	
	private static void LDS() {
		for(int i = N-1; i >= 0; --i) {
			l_dp[i] = 1;
			
			for(int j = N-1; j > i; --j) {
				if(arr[j] < arr[i] && l_dp[i] < l_dp[j] + 1) {
					l_dp[i] = l_dp[j] + 1;
				}
			}
		}
	}
}