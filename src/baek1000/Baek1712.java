package baek1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ1712, Problem finding break-even point
public class Baek1712 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] str = br.readLine().split(" ");
		int[] input = new int[3];
		
		for(int i = 0; i < 3; i++) {
			input[i] = Integer.parseInt(str[i]);
		}
		// a is a fixed cost
		// b is a variable cost, and c is a selling price.
		int a = input[0];
		int b = input[1];
		int c = input[2];
		
		// If the total sales cost exceeds the break-even point, b should not be more than c.
		if(b >= c) sb.append("-1");
		// The value of a divided by c-b is the maximum value that does not exceed the break-even point, 
		// and adding 1 to it is a break-even point.
		else {
			sb.append(a/(c-b) + 1);
		}
		System.out.print(sb);
	}
}