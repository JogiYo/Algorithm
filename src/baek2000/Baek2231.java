package baek2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ 2231, brute force (-ing)
public class Baek2231 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int length = 0;
		int sum = 0;
		boolean flag = false;
			
		for(int i = 1; i <= n; i++) {
			length = (int)Math.log10(i);
			sum = i;
			while(length >= 0) {
				sum += i / (int)Math.pow(10, length);
				i = i - (i / ((int)Math.pow(10, length))) * (int)Math.pow(10, length); 
				length--;
			}
			if(sum == n) {
				flag = true;
				break;
			}
		}
		
		if(flag) sb.append(sum +"\n");
		else sb.append("0\n");
		
		System.out.print(sb);
	}
}