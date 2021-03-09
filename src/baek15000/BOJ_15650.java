package baek15000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ 15649 : N and M(2)
// combination using backtracking
public class BOJ_15650 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		
		int[] num = new int[n];
		boolean[] visit = new boolean[n];
		
		for(int i = 0; i < n; ++i) {
			num[i] = i + 1;
		}
		
		comb(num, visit, 0, n, m);
		System.out.print(sb);
	}
	private static void comb(int[] num, boolean[] visit, int start_idx, int n, int m) {
		if(m == 0) {
			print(num, visit, n);
			return;
		}
		
		for(int i = start_idx; i < n; i++) {
			visit[i] = true;
			comb(num, visit, i + 1, n , m - 1);
			visit[i] = false;
		}
	}
	private static void print(int[] num, boolean[] visit, int n) {
		for(int i = 0; i < n; ++i) {
			if(visit[i]) sb.append(num[i] + " ");
		}
		sb.append("\n");
	}
}