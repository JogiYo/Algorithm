package baek12000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_12865 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		
		int[] w = new int[n+1];
		int[] v = new int[n+1];
		int[] dp = new int[k+1];
		
		for(int i = 1; i <= n; ++i) {
			String[] goods = br.readLine().split(" ");
			w[i] = Integer.parseInt(goods[0]);
			v[i] = Integer.parseInt(goods[1]);
		}
		
		for(int i = 1; i <= n; ++i) {
			for(int j = k; j - w[i] >= 0; --j) {
				dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
			}
		}
		
		sb.append(dp[k] + "");
		System.out.print(sb);
	}
}