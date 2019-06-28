package practice;

import java.util.Arrays;
import java.util.Scanner;

public class prac3_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		Table[] tb1 = new Table[n-1];
		
		for(int i = 0; i < n-1; i++) {
			tb1[i] = new Table();
			tb1[i].id = 0;
			tb1[i].value = "";
		}
		
		System.out.println("id name occupation");
		
		for(int i = 0; i < n-1; i++) {
			tb1[i].id = sc.nextInt();
			sc.nextLine();
			tb1[i].value = sc.next();
		}
		
		n = sc.nextInt();
		sc.nextLine();
		Table[] tb2 = new Table[n];
		
		for(int i = 0; i < n-1; i++) {
			tb2[i].id = 0;
			tb2[i].value = "";
		}
		
		System.out.println("id city zip");
		
		for(int i = 0; i < n-1; i++) {
			tb2[i].id = sc.nextInt();
			sc.nextLine();
			tb2[i].value = sc.next();
		}
		
		sc.nextLine();
		boolean flag = false;
		
		for(int i = 0; i < tb1.length; i++) {
			for(int t = 0; t < tb2.length; t++) {
				if(tb1[i].id == tb2[t].id) {
					tb1[i].value += " " + tb2[t].value;
					flag = true;
				}
			}
			if(!flag) tb1[i].value += " NULL NULL";
		}
		
		Arrays.sort(tb1);
		System.out.println("id name occupation city zip");
		for(int i = 0; i < tb1.length; i++) {
			System.out.println(tb1[i].value);
		}
		
		
	}
	
}

class Table {
	int id;
	String value;
	
	public Table() {
		id = 0;
		value = "";
	}
	
}
