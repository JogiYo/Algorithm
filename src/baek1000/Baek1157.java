package baek1000;

import java.util.Scanner;
public class Baek1157 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next().toUpperCase();
		sc.close();
		int[] count = new int[26];
		int max = 0;
		char ans = '?';
		
		for(int i = 0; i < word.length(); i++) {
			count[word.charAt(i)-65]++;
			if(max < count[word.charAt(i)-65]) {
				max = count[word.charAt(i)-65];
				ans = word.charAt(i);
			}
			else if(max == count[word.charAt(i)-65]) ans = '?';
		}
		
		System.out.println(ans);
 	}
}