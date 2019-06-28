package baek2000;

import java.util.Scanner;
public class Baek2292 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.close();
		
		int distance = 1;
		
		while(n > 3*distance*(distance-1)+1) {
			distance++;
		}
		System.out.println(distance);
	}
}