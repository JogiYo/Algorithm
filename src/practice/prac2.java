package practice;

import java.util.ArrayList;
import java.util.Scanner;

public class prac2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		String[] arr = str.split("");
		ArrayList<String> list = new ArrayList<String>();
		String temp = "";
		String ans = "";
		
		
		temp += arr[0];
		for(int i = 1; i < arr.length; i++) {
			if(arr[i].charAt(0) >= 48 && arr[i].charAt(0) <= 57) {
				if(arr[i-1].charAt(0) >= 65 && arr[i-1].charAt(0) <=122 ) {
					list.add(temp);
					list.add(arr[i]);
				}
				else {
					list.add(arr[i]);
				}
			}
			else {
				if (arr[i].charAt(0) >= 65 && arr[i].charAt(0) <= 90) {
					list.add(temp);
					temp = arr[i];
				}
	
				else {
					temp += arr[i];		
				}
			}
		}
		
		if(list.size() % 2 == 0) {
			for(int i = 0; i < list.size()/2; i++) {
				if(list.get(i + (list.size()/2)).charAt(0) == 49) {
					ans += list.get(i);
				}
				else ans += list.get(i) + list.get(i + (list.size()/2));
			}
			
			System.out.println(ans);
		}
		else System.out.println("error");
	}
}
