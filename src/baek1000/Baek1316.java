package baek1000;

import java.util.Scanner;
public class Baek1316 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int count = 0;
		int alph[];
		String word;
		boolean flag;
		
		for(int i = 0; i < n; i++) {
			word = sc.next();
			alph = new int[26];
			flag = true;
			
			for(int t = 0; t < word.length(); t++) {
				if(t == 0) {
					alph[word.charAt(t)-97]++;
				}
				else {
					if (word.charAt(t) != word.charAt(t-1)) alph[word.charAt(t)-97]++; 
				}
			}
			
			for(int t = 0; t < word.length(); t++) {
				if(alph[word.charAt(t)-97] != 1) flag = false;
			}
			
			if(flag) count++;
		}
		
		sc.close();
		System.out.println(count);
	}
}