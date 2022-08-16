package baek6000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek6591 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String[] input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int r = Integer.parseInt(input[1]);
			int div = 1;
			long result = 1;
			
			if(n == 0 && r == 0) break;
			
			if(n-r < r) r = n-r;
			
			while(r-- > 0) {
				result *= n--;
				result /= div++;
			}
			sb.append(result + "\n");
		}
		System.out.println(sb);
	}
}