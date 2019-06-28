package baek1000;

import java.util.Scanner;

public class Baek1110 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int init_num, first_num, second_num, result;
		int compare_val = 0;
		int count = 0;
		
		init_num = sc.nextInt();
		if(init_num < 0 || init_num > 99) init_num = sc.nextInt();
		
		if(init_num < 10) {
			first_num = init_num;
			second_num = 0;
			init_num = init_num*10;
		}
		else {
			first_num = init_num/10;
			second_num = init_num%10;
		}
		
		result = first_num + second_num;
		
		if(init_num == 0) count++;
		
		while(init_num != compare_val) {
			first_num = second_num;
			second_num = result%10;
			result = first_num + second_num;
			compare_val = first_num*10 + second_num;
			count++;
		}
		
		System.out.println(count);
	}
}