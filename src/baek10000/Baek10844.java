package baek10000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
// dp[i][j] 에서 j는 1의 자리를 나타내며, i는 몇자리인가를 나타내는 것이다.
public class Baek10844 {
	static long mod = 1000000000;
	static long[][] dp;
	static long result;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		dp = new long[N+1][10];
		
		for(int i = 1; i <= 9; i++) {
			dp[1][i] = 1;
		}
		
		for(int i = 2; i <= N; i++) {
			for(int j = 0; j < 10; j++) {
				if(j > 0 && j < 9) dp[i][j] = dp[i-1][j+1] + dp[i-1][j-1];
				else if(j == 0) dp[i][j] = dp[i-1][j+1];
				else dp[i][j] = dp[i-1][j-1];
				dp[i][j] %= mod;
			}
		}
		
		for(int i = 0; i < 10; i++) {
			result += dp[N][i];
		}
		result %= mod;
		sb.append(result);
		System.out.println(sb);
	}
}