package baek10000;

import java.util.Scanner;

public class Baek10951 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		while(sc.hasNextInt()) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			sb.append((a+b) + "\n");
		}
		System.out.print(sb);
	}
}