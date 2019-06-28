package baek11000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek11021 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= tc; i++) {
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			sb.append("Case #"+ i +": "+ (a+b) +"\n");
		}
		System.out.print(sb);
	}
}