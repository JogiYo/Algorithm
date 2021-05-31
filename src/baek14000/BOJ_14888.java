package baek14000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ 14888 : interleave operator
// Backtracking, using DFS
public class BOJ_14888 {
	static int MAX = Integer.MIN_VALUE;
	static int MIN = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		String[] input_a = br.readLine().split(" ");
		for(int i = 0; i < a.length; ++i) {
			a[i] = Integer.parseInt(input_a[i]);
		}
		
		String[] input_op = br.readLine().split(" ");
		int[] op = new int[4];
		for(int i = 0; i < 4; ++i) {
			op[i] = Integer.parseInt(input_op[i]);
		}
			
		dfs(a, op, a[0], 1);
		sb.append(MAX + "\n" + MIN);
		System.out.print(sb);
	}
	
	private static void dfs(int[] num, int[] op, int target, int idx) {
		if(idx == num.length) {
			MAX = Math.max(MAX, target);
			MIN = Math.min(MIN, target);
			return;
		}
		
		for(int i = 0; i < 4; ++i) {
			if(op[i] > 0) {
				op[i]--;
				if(i == 0) dfs(num, op, target + num[idx], idx + 1);
				else if(i == 1) dfs(num, op, target - num[idx], idx + 1);
				else if(i == 2) dfs(num, op, target * num[idx], idx + 1);
				else dfs(num, op, target / num[idx], idx + 1);
				op[i]++;
			}
		}
	}
}