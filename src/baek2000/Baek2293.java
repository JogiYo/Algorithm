package baek2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 한가지에서 부터 n가지 동전을 사용했을 때 k원까지의 방법을 단계적으로 푼다.
// 1가지를 이용했을 경우 k원까지의 방법, 2가지 .. k원까지, n가지 .. k원까지 순차적으로..
// 0원을 생각해서 dp[0] = 1 이라는 것도 알아두자.
public class Baek2293 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		
		int[] coin = new int[n];
		int[] dp = new int [k+1];
		
		for(int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(coin);
		
		dp[0] = 1;
		
		for(int i = 0; i < n; i++) {
			for(int j = coin[i]; j <= k; j++) {
				dp[j] = dp[j] + dp[j-coin[i]];
			}
		}
		
		sb.append(dp[k]);
		System.out.println(sb);
	}
}