package baek10000;

import java.util.ArrayList;
import java.util.Scanner;
public class Baek10871 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> num_arr = new ArrayList<Integer>();
		int n,x;
		
		n = sc.nextInt();
		if (n < 1)  n = sc.nextInt();
		x = sc.nextInt();
		if ( x >10000 ) x = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			int num = sc.nextInt();
			if (num < x)  num_arr.add(num);
		}
		for(int i = 0; i < num_arr.size()-1; i++) System.out.print(num_arr.get(i) + " ");
		System.out.println(num_arr.get(num_arr.size()-1));
	}
}
