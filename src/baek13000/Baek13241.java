package baek13000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek13241 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		int a = Integer.parseInt(input[0]);
		long b = (long) Integer.parseInt(input[1]);
		
		sb.append(lcm((long)a,b));
		System.out.print(sb);
	}
	
	//최대공약수
	public static long gcd(long a, long b) {
		while(b != 0) {
			long r = a%b;
			a = b;
			b = r;
		}
			
		return a;
	}
		
	//최소공배수
	public static long lcm(long a, long b) {
		return (a*b) / gcd(a,b);
	}
}