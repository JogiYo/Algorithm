package baek1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
// 5가 사용되는 횟수가 0이 등장하는 횟수이다.
public class Baek1676 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int count = 0;
		int input = Integer.parseInt(br.readLine());
		int temp = 0;
		
		for(int i = 1; i <= input; i++) {
			temp = i;
			
			while(temp % 2 == 0 || temp % 5 == 0) {
				if(temp % 2 == 0) temp /= 2;
				if(temp % 5 == 0) {
					temp /= 5;
					count++;
				}
			}
		}
		
		sb.append(count);
		System.out.println(sb);
	}
}