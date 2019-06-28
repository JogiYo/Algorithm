package baek3000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek3036 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		String[] input = br.readLine().split(" ");
		int first_num = Integer.parseInt(input[0]);
		
		for(int i = 1; i < tc; i++) {
			int temp_num = Integer.parseInt(input[i]);
			int GCD = gcd(first_num, temp_num);
			sb.append(first_num/GCD + "/" + temp_num/GCD +"\n");
		}
		System.out.print(sb);
	}

	public static int gcd(int a, int b) {
		int r;
		while(b != 0) {
			r = a%b;
			a = b;
			b = r;
		}	
		return a;
	}
}