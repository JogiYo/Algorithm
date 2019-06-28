package baek1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek1977 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int sum = 0;
		int min = Integer.MAX_VALUE;
		
		for(int i = 1; i <= 100; i++) {
			int x = i * i;
			if( x >= m && x <= n) {
				if(x < min) {
					min = x;
				}
				sum += x;
			}
		}
		if(sum == 0) {
			sb.append(-1);
		}
		else {
			sb.append(sum + "\n" + min);
		}
		System.out.print(sb);
	}
}