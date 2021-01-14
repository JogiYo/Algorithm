package baek11000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ_11653 : Factorization
public class BOJ_11653 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		// When any N can be represented by two or more multiplications (arguments), 
		// one or more of the factors must be less than or equal to °ÓN.
		// In other words, the range of the loop is repeated up to °ÓN.
		for(int i = 2; i <= Math.sqrt(n); ++i) {
			while(n % i == 0) {
				sb.append(i + "\n");
				n /= i;
			}
		}
		
		if(n != 1) {
			sb.append(n);
		}
		
		System.out.print(sb);
	}
}