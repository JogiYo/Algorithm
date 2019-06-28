package baek1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek1912 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int[] dp = new int[n+1];
		int[] order = new int[n+1];
		int max = -1001;
		
		dp[0] = -1001;
		
		for(int i = 1; i <= n; i++) {
			order[i] = Integer.parseInt(input[i-1]);
			dp[i] = Math.max(order[i], order[i] + dp[i-1]);
			if(dp[i] > max) max = dp[i];
		}
		
		sb.append(max);
		System.out.println(sb);
	}
}