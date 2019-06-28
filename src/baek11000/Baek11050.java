package baek11000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek11050 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		int result;
		
		result = factorial(n)/(factorial(k) * factorial(n-k));
		sb.append(result);
		System.out.println(sb);
	}
	
	public static int factorial(int n) {
		if( n == 1 || n == 0) {
			return 1;
		}
		else {
			return n*factorial(n-1);
		}
	}
}