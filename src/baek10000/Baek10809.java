package baek10000;

import java.util.Scanner;
public class Baek10809 {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int[] alph = new int[26];
		String word = sc.nextLine();
		sc.close();
		
		for(int i = 0; i < alph.length; i++) {
			alph[i] = -1;
		}
		
		for(int i = 0; i < word.length(); i++) {
			if(alph[word.charAt(i)-97] == -1) alph[word.charAt(i)-97] = i;
		}
		
		System.out.print(alph[0]);
		for(int i = 1; i < alph.length; i++) {
			System.out.print(" "+alph[i]);
		}	
	}
}