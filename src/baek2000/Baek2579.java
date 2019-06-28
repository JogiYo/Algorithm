package baek2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// dp[n] = dp[n-2] + a[n]  과  dp[n-3] + a[n-1] + a[n] 중에 큰 값
public class Baek2579 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] stair = new int[N+1];
		int[] point = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		
		point[1] = stair[1];
		if( N > 1) point[2] = point[1] + stair[2];
		
		for(int i = 3; i <= N; i++) {
			point[i] = Math.max(stair[i] + point[i-2], stair[i] + stair[i-1] + point[i-3]);
		}
		
		sb.append(point[N]);
		System.out.println(sb);
	}
}