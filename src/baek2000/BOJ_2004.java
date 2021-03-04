package baek2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
// BOJ 2004 : Combination: the number of 0
// The key is to find the number where the multipliers of 2 and 5 overlap a factorial value.
public class BOJ_2004 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		long n = Long.parseLong(input[0]);
		long m = Long.parseLong(input[1]);
		// nCm -> n!/(n-m)!m! -> 
		// Finding the number of zeros = n!/(n-m)!m!{2^k, 5^k}
		// = 2^a1 x 5^a2 / (2^b1 x 5^b2) x (2^c1 x 5^c2) = 2^(a1-b1-c1) x 5^(a2-b2-c2)
		long cnt_5 = five_pow_cnt(n) - five_pow_cnt(n-m) - five_pow_cnt(m);
		long cnt_2 = two_pow_cnt(n) - two_pow_cnt(n-m) - two_pow_cnt(m);
		// Since you just need to find the number of overlaps (which can be paired), 
		// you can output the minimum of the multipliers of 2 and 5.
		sb.append(Math.min(cnt_5, cnt_2));
		System.out.println(sb);
	}
	// Method to find the number of 2 in the factorial
	private static long two_pow_cnt(long n) {
		long count = 0;
		
		while(n >= 2) {
			count += n/2;
			n /= 2;
		}
		
		return count;
	}
	// Method to find the number of 5 in the factorial
	private static long five_pow_cnt(long n) {
		long count = 0;
		
		while(n >= 5) {
			count += n/5;
			n /= 5;
		}
		
		return count;
	}
}