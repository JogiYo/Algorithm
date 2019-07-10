package baek2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ 2231, brute force
// Decomposition sum: Finding a constructor. For example, the constructor for 216 is 198 + 1 + 9 +8.
public class Baek2231 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int sum = 0;
		int ans = 0;
		boolean flag = false;
			
		for(int i = 1; i <= n; i++) {
			sum = i;
			int temp = i;
			
			// Finding a constructor
			while(temp != 0) {
				sum += temp%10;
				temp = temp/10;
			}
			
			if(sum == n) {
				flag = true;
				ans = i;
				break;
			}
		}
		
		if(flag) sb.append(ans +"\n");
		else sb.append("0\n");
		
		System.out.print(sb);
	}
}