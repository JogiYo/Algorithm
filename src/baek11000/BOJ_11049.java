package baek11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// BOJ_11049
// Category : DP
public class BOJ_11049 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[][] matrix = new int[n][2];
		
		for(int i = 0; i < n; ++i) {
			String[] input = br.readLine().split(" ");
			matrix[i][0] = Integer.parseInt(input[0]);
			matrix[i][1] = Integer.parseInt(input[1]);
		}
		
		
		bw.write(String.valueOf(solution(matrix)));
		bw.flush();
		
		bw.close();
		br.close();
	}

	private static int solution(int[][] matrix) {
		int size = matrix.length;
		int[][] dp = new int[size][size];
		
		// A x B matrix, B x C matrix -> multiplier count = A x B x C
		for(int i = 0; i < size - 1; ++i) {
			dp[i][i+1] = matrix[i][0] * matrix[i][1] * matrix[i+1][1];
		}
		
		for(int x = 2; x < size; ++x) {
			for(int i = 0; i + x < size; ++i) {
				int j = i + x;
				dp[i][j] = Integer.MAX_VALUE;
				
				for(int k = i; k < j; ++k) {
					dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + (matrix[i][0] * matrix[k][1] * matrix[j][1]));
				}
			}
		}
		return dp[0][size-1];
	}
}