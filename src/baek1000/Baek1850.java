package baek1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Baek1850 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		BigInteger a = new BigInteger(input[0]);
		BigInteger b = new BigInteger(input[1]);
		
		BigInteger b_gcd = gcd(a,b);
		
		while(!b_gcd.equals(BigInteger.ZERO)) {
			sb.append("1");
			b_gcd = b_gcd.subtract(BigInteger.valueOf(1));
		}
		System.out.println(sb);
	}
	//최대공약수
	public static BigInteger gcd(BigInteger a, BigInteger b) {
		while(b != BigInteger.valueOf(0)) {
			BigInteger r = a.remainder(b);
			a = b;
			b = r;
		}		
		return a;
	}	
}