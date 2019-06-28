package practice;

import java.util.Scanner;

public class prac4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] x = new int[n];
		int max = 0;
		int max2 = 0;
		int x1, x2;
		
		for(int i = 0; i < n; i++) {
			x[i] = sc.nextInt();
		}
		
		max = x[0];
		x1 = 0;
		for (int i = 1; i < x.length; i++) { 
			if (max < x[i]) {
				max = x[i];
				x1 = i;
			}
		}
		
		if(x1 != 0) {
			max2 = x[0];
			x2 = 0;
		}
		else x2 = -1;
		
		for (int i = 1; i < x.length; i++) { 
			if (max2 < x[i] && i != x1) {
				max2 = x[i];
				x2 = i;
			}
		}
		
		if(x1 > x2) System.out.println(x1-x2);
		else System.out.println(x2-x1);
	}
}
