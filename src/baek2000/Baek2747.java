package baek2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek2747 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		long result = 0;
		
		int n = Integer.parseInt(br.readLine());
		
		long[] fibo = new long[91]; 
		
		fibo[0] = 0;
		fibo[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			fibo[i] = fibo[i-1] + fibo[i-2];
		}
		result = fibo[n];
		
		sb.append(result);
		System.out.println(sb);
	}
}