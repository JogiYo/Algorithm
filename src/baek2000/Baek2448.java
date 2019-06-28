package baek2000;

import java.util.Scanner;

public class Baek2448 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		String triangle[] = new String[n];
		triangle[0] = "  *  ";
		triangle[1] = " * * ";
		triangle[2] = "*****";
		
		for(int k = 1; 3*(int)Math.pow(2, k) <= n; ++k) {
			pointStar(k, triangle);
		}
		
		for(int i = 0; i < n; ++i) {
			System.out.println(triangle[i]);
		}
	}

	private static void pointStar(int k, String[] triangle) {
		int bottom_area = 3 * (int)Math.pow(2, k);
		int top_area = bottom_area/2;
		String blank = "";
		
		for(int i = top_area; i <bottom_area; ++i) {
			triangle[i] = triangle[i-top_area] + " " + triangle[i-top_area];
		}
		while(blank.length() < top_area) blank += " ";
		
		for(int i = 0; i < top_area; ++i) {
			triangle[i] = blank + triangle[i] + blank;
		}
	}
}
