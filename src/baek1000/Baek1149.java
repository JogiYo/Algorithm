package baek1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek1149 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[][] cost = new int[3][N];
		int r,g,b;
		
		String[] input = br.readLine().split(" ");
		cost[0][0] = Integer.parseInt(input[0]);
		cost[1][0] = Integer.parseInt(input[1]);
		cost[2][0] = Integer.parseInt(input[2]);
		
		for(int i = 1; i < N; i++) {
			String[] input2 = br.readLine().split(" ");
			r = Integer.parseInt(input2[0]);
			g = Integer.parseInt(input2[1]);
			b = Integer.parseInt(input2[2]);
			
			cost[0][i] = r + Math.min(cost[1][i-1], cost[2][i-1]);
			cost[1][i] = g + Math.min(cost[0][i-1], cost[2][i-1]);
			cost[2][i] = b + Math.min(cost[0][i-1], cost[1][i-1]);
		}
		
		sb.append(Math.min(cost[0][N-1], Math.min(cost[1][N-1], cost[2][N-1])));
		System.out.println(sb);
	}
}