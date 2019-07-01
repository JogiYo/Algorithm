package baek4000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
 
// BOJ4153, When the length of three sides is given, the problem of determining whether it is a right-angled triangle
public class Baek4153 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] input;
		int a,b,c;
		
		while(true) {
			input = br.readLine().split(" ");
			a = Integer.parseInt(input[0]);
			b = Integer.parseInt(input[1]);
			c = Integer.parseInt(input[2]);
			int temp;
			
			// Find the maximum value of three variables and place the maximum value in c.
			// swap.
			if(a < b) {
				if(b > c) {
					temp = c;
					c = b;
					b = temp;
				}
			}
			else {
				if(a > c) {
					temp = c;
					c = a;
					a = temp;
				}
			}
			if(a == 0 && b == 0 && c == 0) break;
			
			// Determine if it matches Pythagorean theorem (a^2 + b^2 = c^2)
			if(Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) sb.append("right\n");
			else sb.append("wrong\n");
		}
		System.out.print(sb);
	}
}