package baek10000;

import java.util.Scanner;

public class Baek10039 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] point = new int[5];
		int sum = 0;
		
		for(int i = 0; i < 5; i++) {
			point[i] = sc.nextInt();
			if(point[i] % 5 != 0) point[i] = sc.nextInt(); 
		}
		
		for(int i = 0; i < 5; i++) {
			if(point[i] < 40) point [i] = 40;
			sum += point[i];
		}
		
		System.out.println(sum/5);
	}
}