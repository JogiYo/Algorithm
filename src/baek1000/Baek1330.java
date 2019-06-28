package baek1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek1330 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);
		
		if(a > b) sb.append(">");
		else if (a < b) sb.append("<");
		else sb.append("==");
		
		System.out.print(sb);
	}
}