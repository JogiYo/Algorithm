package baek8000;

import java.util.Scanner;

public class Baek8958 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int[] point = new int[n];
		
		for(int i = 0; i < point.length; i++) {
			point[i] = 0;
			String str = sc.nextLine();
			int temp_pt = 0;
			String[] ox = str.split("");
			
			for(int j = 0; j < ox.length; j++) {
				if(ox[j].equals("O")) {
					temp_pt++;
					point[i] += temp_pt;
				}
				else {
					temp_pt = 0;
				}
			}
		}
		sc.close();
		for(int i = 0; i < point.length; i++) System.out.println(point[i]);
	}
}