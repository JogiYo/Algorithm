package baek2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek2609 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);
		
		sb.append(gcd(a,b) + "\n");
		sb.append(lcm(a,b));
		System.out.print(sb);
	}
	//최대공약수
	public static int gcd(int a, int b) {
		while(b != 0) {
			int r = a%b;
			a = b;
			b = r;
		}
			
		return a;
	}	
	//최소공배수
	public static int lcm(int a, int b) {
		return (a*b) / gcd(a,b);
	}
}