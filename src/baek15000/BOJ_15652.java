package baek15000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ 15652 : N and M(4)
// Redundant Combination using backtracking
public class BOJ_15652 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		
		int[] num = new int[n];
		int[] com = new int[m];
		
		for(int i = 0; i < n; ++i) {
			num[i] = i + 1;
		}
		
		r_comb(num, com, 0, 0, n, m);
		System.out.print(sb);
	}
	private static void r_comb(int[] num, int[] com, int start_idx, int current, int n, int m) {
		if(current == m) {
			print(com, m);
			return;
		}
		
		for(int i = start_idx; i < n; ++i) {
			com[current] = num[i];
			r_comb(num, com, i, current + 1, n, m);
		}
	}
	private static void print(int[] com, int m) {
		for(int i = 0; i < m; ++i) {
			sb.append(com[i] + " ");
		}
		sb.append("\n");
	}
}