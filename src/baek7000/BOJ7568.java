package baek7000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ7568, brute force. 
// The problem of comparing two variables for one object and covering the rank.
public class BOJ7568 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] rank = new int[n];
		int[] weight = new int[n];
		int[] height = new int[n];
		
		for(int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			rank[i] = 1;
			weight[i] = Integer.parseInt(input[0]);
			height[i] = Integer.parseInt(input[1]);
		}
		
		// brute force. 
		// If both the weight and the height are large, the ranking increases.
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(i != j) {
					if(weight[i] < weight[j] && height[i] < height[j]) {
						rank[i]++;
					}
				}
			}
			sb.append(rank[i] + " ");
		}
		
		System.out.print(sb);
	}
}