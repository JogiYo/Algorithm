package baek2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// �Ѱ������� ���� n���� ������ ������� �� k�������� ����� �ܰ������� Ǭ��.
// 1������ �̿����� ��� k�������� ���, 2���� .. k������, n���� .. k������ ����������..
// 0���� �����ؼ� dp[0] = 1 �̶�� �͵� �˾Ƶ���.
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