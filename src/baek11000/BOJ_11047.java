package baek11000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ 11047 : Coin 0
// Greedy algorithm
public class BOJ_11047 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		int[] coin = new int[n];
		
		for(int i = 0; i < n; ++i) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		int result = solution(coin, k);
		System.out.print(result);
	}

	private static int solution(int[] coin, int k) {
		int count = 0;
		for(int i = coin.length-1; i >= 0; --i) {
			if(k == 0) break;
			count += k/coin[i];
			k = k % coin[i];
		}
		return count;
	}
}