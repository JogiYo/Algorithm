package baek1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ 1010 : Bridge laying
// using dynamic programming(Pascal triangle, combination)
public class BOJ_1010 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[][] pascal_triangle = new int[30][30];
		
		for(int i = 0; i < 30; ++i) {
			pascal_triangle[i][0] = 1;
			pascal_triangle[i][i] = 1;
		}
		
		for(int i = 2; i < 30; ++i) {
			for(int j = 1; j < 30; ++j) {
				pascal_triangle[i][j] = pascal_triangle[i-1][j-1] + pascal_triangle[i-1][j];
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			String[] input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int m = Integer.parseInt(input[1]);
			
			sb.append(pascal_triangle[m][n] + "\n");
		}
		
		System.out.print(sb);
	}
}