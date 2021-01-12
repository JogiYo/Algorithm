package baek14000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ_14681 using if
public class BOJ_14681 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int x = Integer.parseInt(br.readLine());
		int y = Integer.parseInt(br.readLine());
		
		int answer = 0;
		
		if(x > 0) {
			if(y > 0) answer = 1;
			else answer = 4;
		}
		else {
			if(y > 0) answer = 2;
			else answer = 3;
		}
		System.out.print(answer);
	}
}