package baek2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek2490 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < 3; i++) {
			int x = 0;
			String[] str = br.readLine().split(" ");
			
			for(int j = 0; j < 4; j++) {
				x += Integer.parseInt(str[j]);
			}
			
			if(x == 0) {
				sb.append("D\n");
			}
			else if(x == 1) {
				sb.append("C\n");
			}
			else if(x == 2) {
				sb.append("B\n");
			}
			else if(x == 3) {
				sb.append("A\n");
			}
			else if(x == 4) {
				sb.append("E\n");
			}
		}
		
		System.out.print(sb);
	}
}