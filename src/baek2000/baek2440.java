package baek2000;

import java.util.Scanner;

public class baek2440 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n<1 || n>100) n = sc.nextInt();
		
		for(int x=n; x>0; x--) {
			for(int y=1; y<=x; y++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
