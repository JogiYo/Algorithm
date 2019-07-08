package baek2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ 2798, brute force
// Given the numbers written on the N cards, the problem is to get the sum of the three cards as close as possible to M without exceeding M.
public class Baek2798 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		int min = Integer.MAX_VALUE;
		int sum = 0;
		
		String[] card_str = br.readLine().split(" ");
		int[] card = new int[n];
		
		for(int i = 0; i < n; i++) {
			card[i] = Integer.parseInt(card_str[i]);
		}
		
		// brute force : Search all cases.
		for(int c1 = 0; c1 < n-2; c1++) {
			for(int c2 = c1 + 1; c2 < n-1; c2++) {
				for(int c3 = c2 + 1; c3 < n; c3++) {
					if((card[c1] + card[c2] + card[c3]) <= m) {
						if((m - (card[c1] + card[c2] + card[c3])) < min) {
							min = m - (card[c1] + card[c2] + card[c3]);
							sum = card[c1] + card[c2] + card[c3];
						}
					}				
				}
			}
		}
		sb.append(sum+"\n");
		System.out.print(sb);
	}
}