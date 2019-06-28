package baek1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ 내리막길, dp와 dfs의 이용, dfs의 재귀, 행렬에서 네방향으로 움직일 수 있다는 것을 알고 있는 것이 중요.
public class Baek1520 {
	static int[][] arr;
	static int[][] dp;
	static int[] up_down = {-1, 0, 1, 0};
	static int[] left_right = {0, -1, 0, 1};
	static int m;
	static int n;
	
 	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] str = br.readLine().split(" ");
		m = Integer.parseInt(str[0]);
		n = Integer.parseInt(str[1]);
		
		arr = new int[m][n];
		dp = new int[m][n];

		for(int i = 0; i < m; i++) {
			String[] input = br.readLine().split(" ");
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(input[j]);
				dp[i][j] = -1;
			}
		}
		sb.append(dfs(m-1,n-1));
		System.out.println(sb);
	}
 	
 	public static int dfs(int y,int x) {
 		if(y==0 && x==0) return 1;
 		
 		if(dp[y][x] == -1) {
 			dp[y][x] = 0;
 			
 			for(int i=0; i<4; i++) {
 				int nextY = up_down[i] + y;
 				int nextX = left_right[i] + x;
 				
 				if(nextY >= 0 && nextY < m && nextX >= 0 && nextX < n) {
 					if(arr[y][x] < arr[nextY][nextX]) {
 						dp[y][x] += dfs(nextY, nextX);
 					}
 				}
 			}
 		}
 		return dp[y][x];
 	}
}