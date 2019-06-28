package baek1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek1003_recursive {
	static int zero_use;
	static int one_use;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		while(n-- > 0) {
			int exam = Integer.parseInt(br.readLine());
			zero_use = 0;
			one_use = 0;
			fibonacci(exam);
			sb.append(zero_use + " " + one_use + "\n");
		}
		
		System.out.println(sb);
	}
	
	public static int fibonacci(int n) {
		if(n < 2) {
			if(n == 1) one_use++;
			else zero_use++;
			return n;
		}
		else {
			return fibonacci(n-1) + fibonacci(n-2);
		}
	}
}