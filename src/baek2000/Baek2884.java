package baek2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek2884 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		int hour = Integer.parseInt(input[0]);
		int minute = Integer.parseInt(input[1]);
		
		int sum = 60*hour + minute;
		if(sum < 45) sum = 1440 + minute;
		sb.append((sum-45)/60 + " " + (sum-45)%60);
		
		System.out.print(sb);
	}
}