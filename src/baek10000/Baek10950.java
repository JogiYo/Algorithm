package baek10000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek10950 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		while(tc-- > 0) {
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			sb.append(a+b+"\n");
		}
		System.out.print(sb);
	}
}