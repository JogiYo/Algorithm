package baek2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// oox dp[i-1], oxo dp[i-2] + wine[i], xoo dp[i-3] + wine[i-1] + wine[i] 의 비교가 중요하다.
public class Baek2156 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] wine = new int[n];
		int[] dp = new int[n];
		
		for(int i = 0; i < n; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		
		if(n >= 1) dp[0] = wine[0];
		if(n >= 2) dp[1] = wine[1] + wine[0];
		if(n >= 3) dp[2] = Math.max(dp[1], Math.max(dp[0] + wine[2], wine[1]+wine[2]));
		
		for(int i = 3; i < n; i++) {
			dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + wine[i], dp[i-3] + wine[i-1] + wine[i]));
		}
		
		sb.append(dp[n-1]);
		System.out.println(sb);
	}
}