package baek15000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ 15649 : N and M(1)
// permutation using backtracking
public class BOJ_15649 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		
		int[] num = new int[n];
		int[] output = new int[m];
		boolean[] visit = new boolean[n];
		
		for(int i = 0; i < n; ++i) {
			num[i] = i + 1;
		}
		
		perm(num, output, visit, 0, n, m);
		System.out.print(sb);
	}
	private static void perm(int[] num, int[] output, boolean[] visit, int depth, int n, int m) {
		if(depth == m) {
			print(output, m);
			return;
		}
		
		for(int i = 0; i < n; ++i) {
			if(!visit[i]) {
				visit[i] = true;
				output[depth] = num[i];
				perm(num, output, visit, depth + 1, n , m);
				visit[i] = false;
			}
		}
	}
	private static void print(int[] output, int m) {
		for(int i = 0; i < m; ++i) {
			sb.append(output[i] + " ");
		}
		sb.append("\n");
	}
}