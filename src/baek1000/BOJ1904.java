package baek1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ1904, Dynamic Programming
// Problem of finding the remainder of the recursive sequence divided by a specific constant
public class BOJ1904 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[n+1];
		
		dp[0] = 1;
		dp[1] = 1;
		
		// dp, The equation is the same as the Fibonacci function is designed with a dynamic programming method.
		for(int i = 2; i <= n; i++) {
			dp[i] = (dp[i-1] + dp[i-2]) % 15746;
		}
		
		sb.append(dp[n]+"");
		System.out.print(sb);
	}
}