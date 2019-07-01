package baek2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ2869, Given a, b, and v
// question of how many days it takes for a snail to climb to the top of a wooden bar.
public class Baek2869 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);
		int v = Integer.parseInt(input[2]);
		
		// i = the height that can be raised during the day
		// j = total height before the day
		// The total days is increased by 1 after (j / i is raised = ceil(j/i)).
		int i = a - b;
		int j = v - a;
		double ans = Math.ceil((double)j/(double)i) + 1;
		
		if(v == a) sb.append(1);
		else sb.append((int)ans);
		
		System.out.print(sb);
	}
}