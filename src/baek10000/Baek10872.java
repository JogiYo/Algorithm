package baek10000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek10872 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int input = Integer.parseInt(br.readLine());
		
		long[] factorial = new long[501];
		factorial[0] = factorial[1] = 1;
		
		for(int i = 2; i <= input; i++) {
			factorial[i] = i * factorial[i-1];
		}
		
		sb.append(factorial[input]);
		System.out.println(sb);
	}
}