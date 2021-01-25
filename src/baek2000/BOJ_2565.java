package baek2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

// BOJ 2565 : Electric wire
// using dynamic programming and LIS (longest Increasing Sequence)
public class BOJ_2565 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[n];
		int[][] line = new int[n][2];
		
		for(int i = 0; i < n; ++i) {
			String[] input = br.readLine().split(" ");
			line[i][0] = Integer.parseInt(input[0]);
			line[i][1] = Integer.parseInt(input[1]);
		}
		
		// Sorted by A-pole
		Arrays.sort(line, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}
		});
		
		int max = 0;
		
		/*
		 * The value of the B pole connected to the i-th pole
		 * must be larger than the B pole connected to the j-th pole to be searched.
		 */
		for(int i = 0; i < dp.length; ++i) {
			dp[i] = 1;
			
			for(int j = 0; j < i; ++j) {
				if(line[i][1] > line[j][1]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					max = Math.max(max, dp[i]);
				}
			}
		}
		// Minimum number of demolition = total number - installable electric wire
		sb.append(n-max + "");
		System.out.print(sb);
	}
}