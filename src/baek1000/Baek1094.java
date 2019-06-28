package baek1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek1094 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int input = Integer.parseInt(br.readLine());
		int count = 0;
		
		while(input != 0) {
			if(input >= 64) {
				input -= 64;
				count++;
			}
			else if(32 <= input && input < 64) {
				input -= 32;
				count++;
			}
			else if(16 <= input && input < 32) {
				input -= 16;
				count++;
			}
			else if(8 <= input && input < 16) {
				input -= 8;
				count++;
			}
			else if(4 <= input && input < 8) {
				input -= 4;
				count++;
			}
			else if(2 <= input && input < 4) {
				input -= 2;
				count++;
			}
			else if(1 <= input && input < 2) {
				input -= 1;
				count++;
			}
		}
		sb.append(count);
		System.out.print(sb);
	}
}