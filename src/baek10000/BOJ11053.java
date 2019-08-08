package baek10000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ11053, Dynamic Programming
// Consider DP[i] as the 'Long of the longest incremental sequence using i as the last element when there is a number 1 to i'.
public class BOJ11053 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] base_arr = new int[n];
		int[] dp = new int[n];
		int ans = 0;
		
		for(int i = 0; i < n; i++) {
			base_arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// dp[i] is Length of using i element as the last element when there is number 1 to i
		for(int i = 0; i < n; i++) {
			int max = 0;
			for(int j = i-1; j >= 0; j--) {
				if(base_arr[i] > base_arr[j]) {
					max = Math.max(max, dp[j]);
				}
			}
			dp[i] = max + 1;
			// The maximum value of the dp array = ans.
			ans = Math.max(dp[i], ans);
		}
		
		sb.append(ans + "");
		System.out.print(sb);
	}
}