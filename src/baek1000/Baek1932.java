package baek1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek1932 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[][] sum = new int[N][N];
		
		sum[0][0] = Integer.parseInt(br.readLine());
		
		for(int i = 1; i < N; i++) {
			String[] input = br.readLine().split(" ");
			sum[i][0] = Integer.parseInt(input[0]) + sum[i-1][0]; 
			for(int j = 1; j < input.length; j++) {
				sum[i][j] = Integer.parseInt(input[j]) + Math.max(sum[i-1][j-1], sum[i-1][j]);
			}
		}
		
		int max = 0;
		for(int i = 0; i < N; i++) {
			if(max < sum[N-1][i]) max = sum[N-1][i];
		}
		sb.append(max);
		System.out.println(sb);
	}
}