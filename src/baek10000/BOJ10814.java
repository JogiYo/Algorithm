package baek10000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// BOJ10814, Sorting Problem.
// The age and name of those who subscribe to online jersey are given in the order in which they sign up.
// At this time, the problem of arranging members in the order in which they are older 
// and the person who subscribes first comes forward when they are the same.
// I solved the problem through a merge sort
public class BOJ10814 {
	ArrayList<Account> mergeList = new ArrayList<Account>();
	
	public BOJ10814() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			String y = input[1];
			mergeList.add(new Account(x,y,i));
		}
		
		// sorting
		this.mergeSort(mergeList, mergeList.size());
		
		// print result
		for(int i = 0; i < n-1; i++) {
			sb.append(mergeList.get(i).age + " " + mergeList.get(i).name +"\n");
		}
		sb.append(mergeList.get(n-1).age + " " + mergeList.get(n-1).name);
		System.out.print(sb);
	}
	
	// sorting method
	public void mergeSort(ArrayList<Account> list, int index_count) {
		if(index_count<2) return;
		
		int mid = index_count/2;
		
		ArrayList<Account> left_Array = new ArrayList<Account>();
		ArrayList<Account> right_Array = new ArrayList<Account>();
		
		for(int i = 0; i < mid; i++) left_Array.add(i, list.get(i));
		for(int j = mid; j < index_count; j++) right_Array.add(j-mid, list.get(j));
		
		this.mergeSort(left_Array, mid);
		this.mergeSort(right_Array, index_count-mid);
		
		this.merge(list, left_Array, mid, right_Array, index_count-mid);
		
	}
	
	// merge method
	public void merge(ArrayList<Account> list, ArrayList<Account> left_Array, int left_count, ArrayList<Account> right_Array, int right_count) {
		int i = 0, j = 0, k = 0;
		
		while( i < left_count && j < right_count) {
			if(left_Array.get(i).age < right_Array.get(j).age) list.set(k++, left_Array.get(i++));
			// If the accounts are of the same age, they are sorted according to the order of subscription.
			else if(left_Array.get(i).age == right_Array.get(j).age) {
				if(left_Array.get(i).order < right_Array.get(j).order) list.set(k++, left_Array.get(i++));
				else list.set(k++, right_Array.get(j++));
			}
			else list.set(k++, right_Array.get(j++));		
		}
		
		while(i<left_count) {
			list.set(k++, left_Array.get(i++));
		}
		while(j<right_count) {
			list.set(k++, right_Array.get(j++));
		}
	}
	
	public static void main(String[] args) throws IOException {
		new BOJ10814();
	}
	
	class Account {
		int age;
		String name;
		int order;
		
		public Account() {
			this.age = 0;
			this.name = "";
			this.order = 0;
		}
		
		public Account(int age, String name, int order) {
			this.age = age;
			this.name = name;
			this.order = order;
		}
	}
}