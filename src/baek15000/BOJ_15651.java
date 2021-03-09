package baek15000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ_15651 : N and M(3)
// Redundant permutation using backtracking
public class BOJ_15651 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		
		int[] num = new int[n];
		int[] output = new int[m];
		
		for(int i = 0; i < n; ++i) {
			num[i] = i + 1;
		}
		
		r_perm(num, output, 0, n, m);
		System.out.print(sb);
	}
	private static void r_perm(int[] num, int[] output, int depth, int n, int m) {
		if(depth == m) {
			print(output, m);
			return;
		}
		
		for(int i = 0; i < n; ++i) {
			output[depth] = num[i];
			r_perm(num, output, depth + 1, n , m);
		}
	}
	private static void print(int[] output, int m) {
		for(int i = 0; i < m; ++i) {
			sb.append(output[i] + " ");
		}
		sb.append("\n");
	}
}