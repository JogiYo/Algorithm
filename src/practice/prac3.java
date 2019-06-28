package practice;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class prac3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		HashMap map1 = new HashMap<Integer, String>();
		Map map2 = new HashMap<Integer, String>();
		HashMap result = new HashMap<Integer, String>();
		
		int n = sc.nextInt();
		sc.nextLine();
		System.out.println("id name occupation");
		
		for(int i = 1; i < n; i++) {
			map1.put(sc.nextInt(), sc.nextLine());
		}
		
		
		n = sc.nextInt();
		sc.nextLine();
		System.out.println("id city zip");
		
		for(int i = 1; i < n; i++) {
			map2.put(sc.nextInt(), sc.nextLine());
		}
		
		
		
	}
	
	private class table {
		int id;
		String value;
		
		public table() {
			id = 0;
			value = "";
		}
	}
}
