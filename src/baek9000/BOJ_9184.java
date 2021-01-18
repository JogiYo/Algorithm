package baek9000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ 9184 : Exciting function execution
// using dynamic programming
// Memoization. In other words, if it is the first recursion to visit, 
// the value obtained through the calculation is stored (recorded) in memory, 
// and if it is visited again afterwards, the stored value is used rather than recalculated.
public class BOJ_9184 {
	static int[][][] dp = new int[21][21][21]; // 0 ~ 20
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String[] input = br.readLine().split(" ");
			
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			int c = Integer.parseInt(input[2]);
			
			if(a == -1 && b == -1 && c == -1) break;
			
			sb.append("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c) + "\n");
		}
		
		System.out.print(sb);
	}

	private static int w(int a, int b, int c) {
		// If it is already calculated and saved, the value is immediately returned.
		if(inRange(a, b, c) && dp[a][b][c] != 0) {
			return dp[a][b][c];
		}
		
		if(a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}
		
		if(a > 20 || b > 20 || c > 20) {
			return dp[20][20][20] = w(20, 20, 20);
		}
		
		if(a < b && b < c) {
			return dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
		}
		
		return dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
	}

	// When trying to refer to an array, 
	// any one of a, b, or c can result in a number outside the range, 
	// so this is a function to check this.
	private static boolean inRange(int a, int b, int c) {
		return 0 <= a && a <=20 && 0 <= b && b <=20 && 0 <= c && c <=20;
	}
}