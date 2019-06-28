package baek9000;

import java.util.Scanner;

public class Baek9498 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int point = sc.nextInt();
		String grade;
		
		if(point < 0 || point > 100) point = sc.nextInt();
		
		if (point >= 90 && point <= 100) grade = "A";
		else if (point < 90 && point >= 80) grade = "B";
		else if (point < 80 && point >= 70) grade = "C";
		else if (point < 70 && point >= 60) grade = "D";
		else grade = "F";
		
		System.out.println(grade);
	}
}
