package baek2000;

import java.util.Scanner;

public class Baek2577 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		if(a < 100 || a >= 1000) a = sc.nextInt();
		int b = sc.nextInt();
		if(b < 100 || a >= 1000) b = sc.nextInt();
		int c = sc.nextInt();
		if(c < 100 || c >= 1000) c = sc.nextInt();
		
		String[] num = (Integer.toString(a*b*c)).split("");
		int[] count = {0,0,0,0,0,0,0,0,0,0};
		
		for(int i = 0; i < num.length; i++) {
			for(int j = 0; j < count.length; j++) {
				if(j == Integer.parseInt(num[i])) count[j]++;
			}
		}
		
		for(int i = 0; i < count.length; i++) System.out.println(count[i]);
	}
}
