package baek1000;

import java.util.Scanner;

public class Baek1065 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n < 1 || n > 1000) n = sc.nextInt();
		
		System.out.println(sequence_count(n));
	}
	
	private static int sequence_count(int n) {
		int count = 0;
		int thou, hund, ten, sin, first_gap, second_gap;
		if (n < 100) count = n;
		else {
			count = 99;
			
			for(int i = 100; i <= n; i++) {
				thou = i/1000;
				hund = (i-thou*1000)/100;
				ten = (i - thou*1000 - hund*100)/10;
				sin = i%10;
				
				if (thou != 1) {
					first_gap = ten - hund;
					second_gap = sin - ten;
					
					if(first_gap == second_gap) count++;
					}	
			}
		}
		return count;
	}
}
