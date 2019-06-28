package baek1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek1463 {
	static int dp[] = new int[1000001];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();	
		int N = Integer.parseInt(br.readLine());
		
		dp[1] = 0;
		dp[2] = dp[3] = 1;
		
		if(N>3) {
			for(int i = 4; i <= N; i++) {
				if(i % 3 == 0 && i % 2 == 0) {
					dp[i] = Math.min(dp[i/3] + 1, dp[i/2] + 1);
				}
				else if(i % 3 == 0) {
					dp[i] = Math.min(dp[i/3] + 1, dp[i-1] +1);
				}
				else if(i % 2 == 0) {
					dp[i] = Math.min(dp[i/2] + 1, dp[i-1] + 1);
				}
				else {
					dp[i] = dp[i-1] + 1;
				}
			}
		}
		
		sb.append(dp[N]);
		System.out.println(sb);
	}
}