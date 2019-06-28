package baek2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek2753 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int year = Integer.parseInt(br.readLine());
		boolean flag = false;
		
		if(year % 4 == 0) {
			flag = true;
			if(year % 100 == 0) {
				flag = false;
			}
			if(year % 400 == 0) {
				flag = true;
			}
		}
		
		if(flag) sb.append("1");
		else sb.append("0");
		
		System.out.print(sb);
	}
}