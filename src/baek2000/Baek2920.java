package baek2000;

import java.util.Scanner;

public class Baek2920 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[8];
		boolean flag = true;
		
		for(int i = 0; i < 8; i++) {
			arr[i] = sc.nextInt();
		}
		
		if(arr[0] == 1) {
			for(int i = 1; i < arr.length; i++) {
				if(arr[i] == arr[i-1] + 1) {
					flag = true;
				}
				else {
					flag = false;
					break;
				}
			}
			if(flag) System.out.println("ascending");
			else System.out.println("mixed");
		}
		else if(arr[0] == 8) {
			for(int i = 1; i < arr.length; i++) {
				if(arr[i] == arr[i-1] -1) {
					flag = true;
				}
				else {
					flag = false;
					break;
				}
				
			}
			if(flag) System.out.println("descending");
			else System.out.println("mixed");
		}
		else	System.out.println("mixed");
	}
}