package baek5000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ 5086 : Multiples and factors
// using conditional sentence
public class BOJ_5086 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String[] input = br.readLine().split(" ");
			int first = Integer.parseInt(input[0]);
			int second = Integer.parseInt(input[1]);
			
			if(first == 0 && second == 0) break;
			
			if(first < second) {
				if(second%first == 0) sb.append("factor\n");
				else sb.append("neither\n"); 
			}
			else {
				if(first%second == 0) sb.append("multiple\n");
				else sb.append("neither\n");
			}
		}
		System.out.print(sb);
	}
}