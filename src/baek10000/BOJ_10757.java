package baek10000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

// BOJ 10757 : Big number A+B
// using BigInteger and carry
// It was more efficient to use carry.
public class BOJ_10757 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		// using BigInteger : 17824KB, 280ms
		BigInteger answer = new BigInteger(input[0]).add(new BigInteger(input[1]));
		System.out.print(answer);
		
		// use carry : 15464KB, 152ms
		int c = 0;
		String A = input[0];
		String B = input[1];
		int len_a = A.length()-1;
		int len_b = B.length()-1;
		
		while(len_a >= 0 || len_b >= 0) {
			int c1 = len_a < 0 ? c1 = 0 : A.charAt(len_a) - '0';
			int c2 = len_b < 0 ? c2 = 0 : B.charAt(len_b) - '0';
			
			int sum = c1 + c2 + c;
			int remain = sum%10;
			c = sum / 10;
			sb.insert(0, remain);
			
			len_a--;
			len_b--;
		}
		
		if(c > 0) {
			sb.insert(0, c);
		}
		System.out.print("\n" + sb.toString());
	}
}