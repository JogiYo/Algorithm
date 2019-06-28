package baek1000;

import java.util.Scanner;

public class Baek1152 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String[] arr = input.split(" ");
		int count = 0;
		
		for(int i = 0; i < arr.length; i++) {
			if(!arr[i].equals("")) count++;
		}
		
		System.out.println(count);		
	}
}
