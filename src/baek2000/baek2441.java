package baek2000;

import java.util.Scanner;

public class baek2441 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x,y,z;
		
		if(n<1 || n>100) n = sc.nextInt();
		
		for(x=n; x>=1; x--) {
			for(y=n; y>x; y--) {
				System.out.print(" ");
			}
			for(z=1; z<=y; z++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
