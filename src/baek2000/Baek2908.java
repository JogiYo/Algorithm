package baek2000;

import java.util.Scanner;
public class Baek2908 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int first, second;
		String temp = "";
		
		String num = sc.next();
		temp = extend_num(temp, num);
		
		first = Integer.parseInt(temp);
		
		num = sc.next();
		temp = extend_num(temp, num);
		
		second = Integer.parseInt(temp);
		
		if (first > second) System.out.println(first);
		else System.out.println(second);
		
	}

	private static String extend_num(String temp, String num) {
		temp = "";
		for(int i = num.length()-1; i >= 0; i--) {
			temp += num.charAt(i);
		}
		return temp;
	}
}
