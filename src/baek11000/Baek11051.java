package baek11000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek11051 {
	static int pascal[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		pascal = new int[1001][1001];
		
		pascal[1][0] = pascal[1][1] = 1;
		
		for(int i = 2; i <= n; i++) {
			for(int j = 0; j <= i; j++) {
				if(j == 0 || i == j) {
					pascal[i][j] = 1;
				}
				else {
					pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
				}
				pascal[i][j] = pascal[i][j] % 10007;
			}
		}
		sb.append(pascal[n][k]);
		System.out.println(sb);
	}
}