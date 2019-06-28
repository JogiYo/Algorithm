package baek1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek1934 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			
			sb.append(lcm(a,b) + "\n");
		}
		
		System.out.print(sb);
	}
	
	//�ִ�����
	public static int gcd(int a, int b) {
		while(b != 0) {
			int r = a%b;
			a = b;
			b = r;
		}
		
		return a;
	}
	
	//�ּҰ����
	public static int lcm(int a, int b) {
		return (a*b) / gcd(a,b);
	}
}