package baek2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Baek2751 {
	ArrayList<Integer> mergeList = new ArrayList<Integer>();
	
	public Baek2751() throws IOException {
		int data;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			mergeList.add(Integer.parseInt(br.readLine()));
		}
		
		// Á¤·Ä
		this.mergeSort(mergeList, mergeList.size());
	
		for(int index = 0; index < mergeList.size(); index++) {
			data = mergeList.get(index); 
			bw.write(data+"\n");
		}
		bw.flush();
		bw.close();
	}
	
	public void mergeSort(ArrayList<Integer> list, int index_count) {
		if(index_count<2) return;
		
		int mid = index_count/2;
		
		ArrayList<Integer> left_Array = new ArrayList<Integer>();
		ArrayList<Integer> right_Array = new ArrayList<Integer>();
		
		for(int i = 0; i < mid; i++) left_Array.add(i, list.get(i));
		for(int j = mid; j < index_count; j++) right_Array.add(j-mid, list.get(j));
		
		this.mergeSort(left_Array, mid);
		this.mergeSort(right_Array, index_count-mid);
		
		this.merge(list, left_Array, mid, right_Array, index_count-mid);
		
	}
	
	public void merge(ArrayList<Integer> list, ArrayList<Integer> left_Array, int left_count, ArrayList<Integer> right_Array, int right_count) {
		int i = 0, j = 0, k = 0;
		
		while( i < left_count && j < right_count) {
			if(left_Array.get(i) < right_Array.get(j)) list.set(k++, left_Array.get(i++));
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
		new Baek2751();
	}
}