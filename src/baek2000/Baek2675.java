package baek2000;

import java.util.Scanner;
public class Baek2675 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int case_num = sc.nextInt();
		if(case_num < 1 || case_num >1000) case_num = sc.nextInt();
		
		int repeat;
		String word; 
		String[] conv_word = new String[case_num];
		
		for(int i = 0; i < case_num; i++) {
			repeat = sc.nextInt();
			word = sc.next();
			conv_word[i]  = "";
			for(int j = 0; j < word.length(); j++) {
				for(int t = 0; t < repeat; t++) {
					conv_word[i] += word.charAt(j);
				}
			}
		}	
		sc.close();
		for(int i = 0; i < case_num; i++) {
			System.out.println(conv_word[i]);
		}
	}
}