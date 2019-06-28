package baek10000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://blog.naver.com/occidere/220809577000 Âü°í
public class Baek10253 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		while(tc-- > 0) {
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			int x,g;
			
			while(a != 1) {
				x = b/a + 1;
				a = a*x -b;
				b = b*x;
				
				g = gcd(a,b);
				a = a/g;
				b = b/g;
			}
			
			sb.append(b+"\n");
		}
		System.out.print(sb);
	}
	
	public static int gcd(int a, int b) {
		int r;
		while(b != 0) {
			r = a%b;
			a = b;
			b = r;
		}		
		return a;
	}
}