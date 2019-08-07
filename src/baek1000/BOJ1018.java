package baek1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ1018, Brute Force, chessboard , Complete
public class BOJ1018 {
	static String w_start = "WBWBWBWB";
	static String b_start = "BWBWBWBW";
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[][] version_1 = new String[8][8];
		String[][] version_2 = new String[8][8];
		
		for(int i = 0; i < 8; i++) {
			// Chess Board version 1
			if(i%2 == 0) {
				version_1[i] = w_start.split("");
				version_2[i] = b_start.split("");
			}
			// Chess Board version 2
			else {
				version_1[i] = b_start.split("");
				version_2[i] = w_start.split("");
			}
		}
		
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		
		String[][] base_board = new String[n][m];
		
		for(int i = 0; i < n; i++) {
			base_board[i] = br.readLine().split("");
		}
		
		// brute force
		int result = 64;
		// Distance to move board
		for(int x = 0; x <= n-8; x++) {
			for(int y = 0; y <= m-8; y++) {
				// Compare each character with version1
				int count = 0;
				for(int i = 0; i < 8; i++) {
					for(int j = 0; j < 8; j++) {
						if(!base_board[i+x][j+y].equals(version_1[i][j])) count++;
					}
				}
				result = Math.min(result, count);
				
				// Compare each character with version2
				count = 0;
				for(int i = 0; i < 8; i++) {
					for(int j = 0; j < 8; j++) {
						if(!base_board[i+x][j+y].equals(version_2[i][j])) count++;
					}
				}
				result = Math.min(result, count);
			}
		}
		sb.append(result+"");
		System.out.print(sb);
	}
}