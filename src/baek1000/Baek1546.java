package baek1000;

import java.util.Scanner;
public class Baek1546 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n,m,max;
		double sum,avg;
		max = 0;
		sum = 0;
		
		n =  sc.nextInt();
		if (n > 1000) n =  sc.nextInt();
			
		double[] modify_grade = new double[n];
		
		for(int i = 0; i < n; i++) {
			m = sc.nextInt();
			if (m < 0) m = sc.nextInt();
			modify_grade[i] = (double)m;
			if(m > max) max = m;
		}
		
		for(int i = 0; i < n; i++) {
			sum += (modify_grade[i]/max)*100; 
		}
		
		avg = sum/n;
		System.out.println(avg);
	}
}
