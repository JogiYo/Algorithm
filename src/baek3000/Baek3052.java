package baek3000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

// BOJ3052, Find the Number of different rests (using ArrayList)
public class Baek3052 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		int input;
		int remainder; 
		
		for(int i = 0; i < 10; i++) {
			input = Integer.parseInt(br.readLine());
			remainder = input%42;
			if(!list.contains(remainder)) {
				list.add(remainder);
			}
		}
		sb.append(list.size());
		System.out.print(sb);
	}
}