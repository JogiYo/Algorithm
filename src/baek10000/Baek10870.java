package baek10000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek10870 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		sb.append(fibo(n) + "");
		System.out.print(sb);
	}

	private static int fibo(int n) {
		if(n == 0 || n == 1) return n;
		return fibo(n-1) + fibo(n-2);
	}
}