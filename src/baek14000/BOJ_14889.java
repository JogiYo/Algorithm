package baek14000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ 14889 : Start and Link
// Backtracking, using Combination
public class BOJ_14889 {
	static int MIN = Integer.MAX_VALUE;
	static int n;
	static int[][] s;
	static boolean[] visit;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		s = new int[n][n];
		for(int i = 0; i < n; ++i) {
			String[] input = br.readLine().split(" ");
			for(int j = 0; j < n; ++j) {
				s[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		visit = new boolean[n];
		comb(0, 0);
		System.out.print(MIN);
	}
	// nCr, start is start index
	private static void comb(int start, int r) {
		if(r == n/2) {
			int differ = calc();
			// If the score difference between the two teams is 0, 
			// it is the lowest minimum value,
			// so there is no need to search further and output 0 and exit.
			if(differ == 0) {
				System.out.println(differ);
				System.exit(0);
			}
			
			MIN = Math.min(MIN, differ);
			return;
		}
		// combination
		for(int i = start; i < n; ++i) {
			if(!visit[i]) {
				visit[i] = true;
				comb(i + 1, r + 1);
				visit[i] = false;
			}
		}
	}

	private static int calc() {
		int t_start = 0;
		int t_link = 0;
		
		for(int i = 0; i < n-1; ++i) {
			for(int j = i+1; j < n; ++j) {
				if(visit[i] && visit[j]) {
					t_start += s[i][j];
					t_start += s[j][i];
				}
				else if((!visit[i]) && (!visit[j])) {
					t_link += s[i][j];
					t_link += s[j][i];
				}
			}
		}
		
		int differ = Math.abs(t_start - t_link);
		return differ;
	}
}