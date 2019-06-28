package baek4000;

import java.util.Scanner;
public class Baek4344 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c,n;
		int[] grade;
		double[] ratio;
		
		c = sc.nextInt();
		ratio = new double[c];
		
		for(int i = 0; i < c; i++) {
			n = sc.nextInt();
			if (n < 1 || n > 1000) n = sc.nextInt();
			grade = new int[n];
			int sum = 0;
			for(int j = 0; j < n; j++) {
				int point = sc.nextInt();
				grade[j] = point;
				sum += grade[j];
			}
			double avg = (double)sum / (double)n;
			
			int count = 0;
			for(int j=0; j < n; j++) {
				if(grade[j] > avg) count++; 
			}
			ratio[i] = (double)count / (double)n * 100;
		}
		
		for(int i = 0; i < c; i++) {
			System.out.println(String.format("%.3f", ratio[i])+"%");
		}
	}
}
