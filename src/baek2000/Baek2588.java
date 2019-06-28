package baek2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek2588 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int first = Integer.parseInt(br.readLine());
		String second_str = br.readLine();
		int second = Integer.parseInt(second_str);
		String[] divide = second_str.split("");
		sb.append(first*Integer.parseInt(divide[2]) + "\n");
		sb.append(first*Integer.parseInt(divide[1]) + "\n");
		sb.append(first*Integer.parseInt(divide[0]) + "\n");
		sb.append(first*second + "");
		
		System.out.print(sb);
	}
}