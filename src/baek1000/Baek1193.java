package baek1000;

import java.util.Scanner;

public class Baek1193 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		sc.close();
		int t;
		int n = 1;
		
		while(n*(n+1)/2 < x) {
			n++;
		}
		
		t = x - n*(n-1)/2;
		
		if(n%2 == 1) {
			System.out.println((n-t+1) + "/" + t);
		}
		else {
			System.out.println(t + "/" + (n-t+1));
		}
	}
}