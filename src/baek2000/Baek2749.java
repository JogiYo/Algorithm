package baek2000;

import java.util.Scanner;

public class Baek2749 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		sc.close();
		
		int pisano_period = 1500000;
		long div = 1000000;
		long[] fiboArr = new long[pisano_period];
		
		fiboArr[0] = 0;
		fiboArr[1] = 1;
		
		for(int i = 2; i < pisano_period; i++) {
			if(i > n) break;
			fiboArr[i] = (fiboArr[i-1] + fiboArr[i-2]) % div;
		}
		
		if(n >= pisano_period) n %= pisano_period;
		
		System.out.println(fiboArr[(int)n]);
	}
}